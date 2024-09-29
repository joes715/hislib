package com.hospital.adapt.model.local;

import com.hospital.adapt.utils.CodecUtil2;
import com.hospital.adapt.utils.Str2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"file:${my.contxtPath}/${my.dsCfg}"}, encoding = "UTF-8")
public class LocDBCfgModel {

    private String password = null;
    private String username = null;
    private String driverClassName = null;
    private String jdbcUrl = null;

    @Value("${hikari.local.automaticTestTable}")
    private String automaticTestTable = "test";
    @Value("${hikari.local.idleConnectionTestPeriod}")
    private int idleConnectionTestPeriod = 60;
    @Value("${hikari.local.maxIdleTime}")
    private int maxIdleTime = 30;
    @Value("${hikari.local.testConnectionOnCheckin}")
    private boolean testConnectionOnCheckin = true;
    @Value("${hikari.local.testConnectionOnCheckout}")
    private boolean testConnectionOnCheckout = false;
    @Value("${hikari.local.minPoolSize}")
    private int minPoolSize = 1;
    @Value("${hikari.local.maxPoolSize}")
    private int maxPoolSize = 10;
    @Value("${hikari.local.checkoutTimeout}")
    private int checkoutTimeout = 30000;

    Logger log = LoggerFactory.getLogger(LocDBCfgModel.class);

    public String getDriverClassName() {
        return driverClassName;
    }

    @Value("${hikari.local.driverClassName}")
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = CodecUtil2.decode(Str2.chkNull(driverClassName));
    }

    public String getPassword() {
        return password;
    }

    @Value("${hikari.local.password}")
    public void setPassword(String password) {
        this.password = CodecUtil2.decode(Str2.chkNull(password));
    }

    public String getUsername() {
        return username;
    }

    @Value("${hikari.local.username}")
    public void setUsername(String username) {
        this.username = CodecUtil2.decode(Str2.chkNull(username));
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    @Value("${hikari.local.jdbcUrl}")
    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = CodecUtil2.decode(Str2.chkNull(jdbcUrl));
    }

    public String getAutomaticTestTable() {
        return automaticTestTable;
    }

    public void setAutomaticTestTable(String automaticTestTable) {
        this.automaticTestTable = automaticTestTable;
    }

    public int getIdleConnectionTestPeriod() {
        return idleConnectionTestPeriod;
    }

    public void setIdleConnectionTestPeriod(int idleConnectionTestPeriod) {
        this.idleConnectionTestPeriod = idleConnectionTestPeriod;
    }

    public boolean isTestConnectionOnCheckout() {
        return testConnectionOnCheckout;
    }

    public void setTestConnectionOnCheckout(boolean testConnectionOnCheckout) {
        this.testConnectionOnCheckout = testConnectionOnCheckout;
    }

    public boolean isTestConnectionOnCheckin() {
        return testConnectionOnCheckin;
    }

    public void setTestConnectionOnCheckin(boolean testConnectionOnCheckin) {
        this.testConnectionOnCheckin = testConnectionOnCheckin;
    }

    public int getMaxIdleTime() {
        return maxIdleTime;
    }

    public void setMaxIdleTime(int maxIdleTime) {
        this.maxIdleTime = maxIdleTime;
    }

    public int getMinPoolSize() {
        return minPoolSize;
    }

    public void setMinPoolSize(int minPoolSize) {
        this.minPoolSize = minPoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public int getCheckoutTimeout() {
        return checkoutTimeout;
    }

    public void setCheckoutTimeout(int checkoutTimeout) {
        this.checkoutTimeout = checkoutTimeout;
    }
}
