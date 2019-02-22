package com.suxia.innocence.common.mybatis;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.springframework.stereotype.Component;

/**
 * @date Created in 2019年2月18日 下午7:23:14
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @description TODO
 */
@Component
 @Intercepts({ @Signature(type = StatementHandler.class, method = "query", 
   args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }) })
public class PageInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		return null;
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {

	}

}
