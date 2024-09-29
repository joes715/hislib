package com.hospital.adapt.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.hospital.adapt.config.AppProperties;
import com.hospital.adapt.model.local.LocDBCfgModel;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.hospital.adapt.mapper.local", sqlSessionTemplateRef = "localSqlSessionTemplate")
public class LocDataSource {
    private AppProperties ap = null;

    Logger log = LoggerFactory.getLogger(LocDataSource.class);

    @Resource
    public void setAppProperties(AppProperties ap) {
        this.ap = ap;
    }

    @Bean(name = "mLocalDataSource")
    @Primary
    public DataSource getLocalDataSource(LocDBCfgModel m) {
        ComboPooledDataSource ds = null;
        log.info("Building local datasource...");

        try {
            ds = new ComboPooledDataSource();
            ds.setUser(m.getUsername());
            ds.setPassword(m.getPassword());
            ds.setDriverClass(m.getDriverClassName());
            ds.setJdbcUrl(m.getJdbcUrl());
            ds.setAutomaticTestTable(m.getAutomaticTestTable());
            ds.setIdleConnectionTestPeriod(m.getIdleConnectionTestPeriod());
            ds.setMaxIdleTime(m.getMaxIdleTime());
            ds.setTestConnectionOnCheckin(m.isTestConnectionOnCheckin());
            ds.setTestConnectionOnCheckout(m.isTestConnectionOnCheckout());
            ds.setMinPoolSize(m.getMinPoolSize());
            ds.setMaxPoolSize(m.getMaxPoolSize());
            ds.setCheckoutTimeout(m.getCheckoutTimeout());
        } catch (Exception e) {
            log.error("LocalDataSource exception:", e);
        }

        return ds;
    }

    @Bean(name = "localSqlSessionFactory")
    @Primary
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("mLocalDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setVfs(SpringBootVFS.class);
        bean.setTypeAliasesPackage("com.hospital.adapt.model.local");
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(ap.getLocalMapperPath()));
        return bean.getObject();
    }

    @Bean(name = "localSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("localSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
