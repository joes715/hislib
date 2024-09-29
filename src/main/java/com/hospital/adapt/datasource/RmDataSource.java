package com.hospital.adapt.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.hospital.adapt.config.AppProperties;
import com.hospital.adapt.model.remote.RmDBCfgModel;
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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.hospital.adapt.mapper.remote", sqlSessionTemplateRef = "remoteSqlSessionTemplate")
public class RmDataSource {
    private AppProperties ap = null;

    Logger log = LoggerFactory.getLogger(RmDataSource.class);

    @Resource
    public void setAppProperties(AppProperties ap) {
        this.ap = ap;
    }

    @Bean(name = "mRemoteDataSource")
    public DataSource getRemoteDataSource(RmDBCfgModel m) {

        ComboPooledDataSource ds = null;
        log.info("Building remote datasource...");

        try {
            ds = new ComboPooledDataSource();
            ds.setUser(m.getUsername());
            ds.setPassword(m.getPassword());
            ds.setDriverClass(m.getDriverClassName());
            ds.setJdbcUrl(m.getJdbcUrl());
        } catch (Exception e) {
            log.error("RemoteDataSource exception:", e);
        }

        return ds;
    }

    @Bean(name = "remoteSqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("mRemoteDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setVfs(SpringBootVFS.class);
        bean.setTypeAliasesPackage("com.hospital.adapt.model.remote");
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(ap.getRemoteMapperPath()));
        return bean.getObject();
    }

    @Bean(name = "remoteSqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("remoteSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
