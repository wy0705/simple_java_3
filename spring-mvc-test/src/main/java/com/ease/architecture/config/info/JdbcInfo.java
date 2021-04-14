package com.ease.architecture.config.info;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:mysql.properties")
public class JdbcInfo {

    @Value("${mariaDB.url}")
    private String url;

    @Value("${mariaDB.driver}")
    private String driver;

    @Value("${mariaDB.username}")
    private String username;

    @Value("${mariaDB.password}")
    private String password;

    @Value("${mariaDB.filters}")
    private String filters;


    @Value("${mariaDB.connectionProperties}")
    private String connectionProperties;


    @Value("${mybatis.type.alias.package}")
    private String typeAliasesPackage;

    public String getTypeAliasesPackage() {
        return typeAliasesPackage;
    }

    public void setTypeAliasesPackage(String typeAliasesPackage) {
        this.typeAliasesPackage = typeAliasesPackage;
    }


//    @Value("${mariaDB.validationQuery}")
//    private String validationQuery;
//
//    public String getValidationQuery() {
//        return validationQuery;
//    }


    public String getFilters() {
        return filters;
    }

    public String getConnectionProperties() {
        return connectionProperties;
    }


    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
