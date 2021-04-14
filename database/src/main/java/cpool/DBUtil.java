package cpool;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

    public static Connection getConnection() {
        //从配置文件里把相应的配置读出来
        File config = new File("src/mysql.properties");
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(config);
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jdbcDriver;
        //主机
        String jdbcUrl;
        //数据库用户名
        String userName;
        String password;
        jdbcDriver = properties.getProperty("DRIVER");
        jdbcUrl = properties.getProperty("URL");
        userName = properties.getProperty("USERNAME");
        password = properties.getProperty("PASSWORD");
        Connection connection = null;
        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }
}
