package com.huyaoban.mybatis3.paging;

import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

/**
 * 分页拦截器
 * 
 * @author Administrator StatementHandler中的prepare函数，不同的mybatis版本不一样，注意args参数设置
 */
@Intercepts({
		@Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class, Integer.class }) })
public class PageInterceptor implements Interceptor {
	private int pageSize;
	private String dbType;

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		if (invocation.getTarget() instanceof StatementHandler) {
			StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
			MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);

			// 分离代理对象链(由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面的两次循环
			// 可以分离出最原始的的目标类)
			while (metaStatementHandler.hasGetter("h")) {
				Object object = metaStatementHandler.getValue("h");
				metaStatementHandler = SystemMetaObject.forObject(object);
			}

			// 分离最后一个代理对象的目标类
			while (metaStatementHandler.hasGetter("target")) {
				Object object = metaStatementHandler.getValue("target");
				metaStatementHandler = SystemMetaObject.forObject(object);
			}

			MappedStatement mappedStatement = (MappedStatement) metaStatementHandler
					.getValue("delegate.mappedStatement");

			String mapperId = mappedStatement.getId();
			if (mapperId.matches(".+ByPage$")) {
				ParameterHandler parameterHandler = (ParameterHandler) metaStatementHandler
						.getValue("delegate.parameterHandler");
				Map<String, Object> paraObjects = (Map<String, Object>) parameterHandler.getParameterObject();
				// 也可以这样获取参数
				// paraObject = (Map<String, Object>)
				// statementHandler.getBoundSql().getParameterObject();
				PageInfo pageInfo = (PageInfo) paraObjects.get("pageInfo");

				BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
				String sql = boundSql.getSql();
				String pageSql = sql + " limit " + (pageInfo.getCurrentPage() - 1) * pageSize + ", " + pageSize;

				metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
			}
		} 

		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		if (target instanceof StatementHandler || target instanceof ResultSetHandler) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}

	@Override
	public void setProperties(Properties properties) {
		String limit = properties.getProperty("limit", "10");
		this.pageSize = Integer.valueOf(limit);
		this.dbType = properties.getProperty("dbType", "mysql");
	}
}
