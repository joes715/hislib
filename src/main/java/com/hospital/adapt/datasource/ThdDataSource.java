package com.hospital.adapt.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.hospital.adapt.config.AppProperties;
import com.hospital.adapt.model.third.ThdDBCfgModel;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

//@Configuration
public class ThdDataSource {
    private AppProperties ap = null;

    Logger log = LoggerFactory.getLogger(ThdDataSource.class);

    @Autowired
    public void setAppProperties(AppProperties ap) {
        this.ap = ap;
    }

    @Bean(name = "mThirdDataSource")
    public DataSource getthirdDataSource(ThdDBCfgModel m) {

        ComboPooledDataSource ds = null;
        log.info("Building local datasource...");

        try {
            ds = new ComboPooledDataSource();
            ds.setUser(m.getUsername());
            ds.setPassword(m.getPassword());
            ds.setDriverClass(m.getDriverClassName());
            ds.setJdbcUrl(m.getJdbcUrl());
        } catch (Exception e) {
            log.error("ThirdDataSource exception:", e);
        }

        return ds;
    }

    @Bean(name = "thirdSqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("mThirdDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setVfs(SpringBootVFS.class);
        bean.setTypeAliasesPackage("com.hospital.adapt.model.third");
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(ap.getThirdMapperPath()));
        return bean.getObject();
    }

    @Bean(name = "thirdSqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("thirdSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
