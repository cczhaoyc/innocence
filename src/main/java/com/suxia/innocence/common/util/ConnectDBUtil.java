package com.suxia.innocence.common.util;

import com.suxia.innocence.system.exception.base.BusinessValidationException;
import com.suxia.innocence.system.exception.base.ServiceValidationException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月28 10:53 星期一
 * @description TODO 数据库连接工具类
 */
public class ConnectDBUtil {

    public static  final String MYSQL = "mysql";
    public static  final String ORACLE = "oracle";

    public static Connection getConnection(String dataSourceType, String url, String userName, String password)
             {
        validateParameter(dataSourceType,url,userName,password);
        String driver = "com.mysql.jdbc.Driver";
        if (MYSQL.equals(dataSourceType.trim().toLowerCase())) {
            driver = "com.mysql.jdbc.Driver";
        }
        if (ORACLE.equals(dataSourceType.trim().toLowerCase())) {
            driver = "oracle.jdbc.driver.OracleDriver";
        }
        try {
            Class.forName(driver);// 加载驱动
            return DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            throw new ServiceValidationException("ConnectDBUtil:Database connection error!");
        }
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new ServiceValidationException("ConnectDBUtil:Database close connection error!");

            }
        }
    }

    private static void validateParameter(String dataSourceType, String url, String userName, String password){
        if(ValidationUtil.isEmptyString(dataSourceType)){
            throw  new BusinessValidationException("ConnectDBUtil:dataSourceType is null!");
        }
        if(ValidationUtil.isEmptyString(url)){
            throw  new BusinessValidationException("ConnectDBUtil:url is null!");
        }
        if(ValidationUtil.isEmptyString(userName)){
            throw  new BusinessValidationException("ConnectDBUtil:userName is null!");
        }
        if(ValidationUtil.isEmptyString(password)){
            throw  new BusinessValidationException("ConnectDBUtil:password is null!");
        }
    }

}
