package com.hospital.adapt.model.remote;

import com.hospital.adapt.utils.CodecUtil2;
import com.hospital.adapt.utils.Str2;
import com.hospital.adapt.model.local.LocDBCfgModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"file:${my.contxtPath}/${my.dsCfg}"}, encoding = "UTF-8")
public class RmDBCfgModel {

    private String driverClassName = null;
    private String password = null;
    private String username = null;
    private String jdbcUrl = null;

    @Value("${hikari.remote.connectionTimeout}")
    private int connectionTimeout = 30000;
    @Value("${hikari.remote.idleTimeout}")
    private int idleTimeout = 600000;
    @Value("${hikari.remote.maxLifetime}")
    private int maxLifetime = 1800000;
    @Value("${hikari.remote.connectionTestQuery}")
    private String connectionTestQuery = "select 1";
    @Value("${hikari.remote.minimumIdle}")
    private int minimumIdle = 1;
    @Value("${hikari.remote.maximumPoolSize}")
    private int maximumPoolSize = 10;


    Logger log = LoggerFactory.getLogger(LocDBCfgModel.class);

    public String getDriverClassName() {
        return driverClassName;
    }

    @Value("${hikari.remote.driverClassName}")
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = CodecUtil2.decode(Str2.chkNull(driverClassName));
    }

    public String getPassword() {
        return password;
    }

    @Value("${hikari.remote.password}")
    public void setPassword(String password) {
        this.password = CodecUtil2.decode(Str2.chkNull(password));
    }

    public String getUsername() {
        return username;
    }

    @Value("${hikari.remote.username}")
    public void setUsername(String username) {
        this.username = CodecUtil2.decode(Str2.chkNull(username));
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    @Value("${hikari.remote.jdbcUrl}")
    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = CodecUtil2.decode(Str2.chkNull(jdbcUrl));
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public int getIdleTimeout() {
        return idleTimeout;
    }

    public void setIdleTimeout(int idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    public int getMaxLifetime() {
        return maxLifetime;
    }

    public void setMaxLifetime(int maxLifetime) {
        this.maxLifetime = maxLifetime;
    }

    public String getConnectionTestQuery() {
        return connectionTestQuery;
    }

    public void setConnectionTestQuery(String connectionTestQuery) {
        this.connectionTestQuery = connectionTestQuery;
    }

    public int getMinimumIdle() {
        return minimumIdle;
    }

    public void setMinimumIdle(int minimumIdle) {
        this.minimumIdle = minimumIdle;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

}
