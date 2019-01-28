package com.suxia.innocence.system.base.quartz;

import com.suxia.innocence.common.util.ConnectDBUtil;
import com.suxia.innocence.common.util.ValidationUtil;
import com.suxia.innocence.system.exception.base.ServiceValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Connection;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月28 10:34 星期一
 * @description TODO 定时连接数据库
 */
@Component
public class DataSourceTask {

    private Logger LOG = LoggerFactory.getLogger(DataSourceTask.class);

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Scheduled(cron = "0 0 2 * * ?")
    public void validateDataSourceConfig() {
        String driverClassName = dataSourceProperties.getDriverClassName();
        String username = dataSourceProperties.getUsername();
        String password = dataSourceProperties.getPassword();
        String url = dataSourceProperties.getUrl();
        String dataSourceType = null;
        if (driverClassName.contains(ConnectDBUtil.MYSQL)) {
            dataSourceType = ConnectDBUtil.MYSQL;
        }
        if (driverClassName.contains(ConnectDBUtil.ORACLE)) {
            dataSourceType = ConnectDBUtil.ORACLE;
        }
        Connection connection = null;
        try {
            connection = ConnectDBUtil.getConnection(dataSourceType, url, username, password);
            if (ValidationUtil.isEmptyObject(connection)) {
                LOG.info("DataSourceTask：连接数据库异常！");
            }
            if (!ValidationUtil.isEmptyObject(connection)) {
                LOG.info("DataSourceTask：连接数据库成功！");
            }
        } catch (Exception e) {
            throw new ServiceValidationException("定时连接数据库出错！");
        } finally {
            ConnectDBUtil.closeConnection(connection);
        }
    }
}
