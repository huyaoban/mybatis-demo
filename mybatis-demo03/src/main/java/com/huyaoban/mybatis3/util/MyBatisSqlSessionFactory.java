package com.huyaoban.mybatis3.util;

import javax.sql.DataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.huyaoban.mybatis3.domain.PhoneNumber;
import com.huyaoban.mybatis3.domain.Student;
import com.huyaoban.mybatis3.domain.handler.PhoneTypeHandler;
import com.huyaoban.mybatis3.mapper.StudentMapper;

public class MyBatisSqlSessionFactory {
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSessionFactory getSqlSessionFactory() {
		if(sqlSessionFactory == null) {
			DataSource dataSource = DataSourceFactory.getDataSource();
			TransactionFactory transactionFactory = new JdbcTransactionFactory();
			
			Environment env = new Environment("develop", transactionFactory, dataSource);
			Configuration configuration = new Configuration(env);
			configuration.getTypeAliasRegistry().registerAlias("Student", Student.class);
			configuration.getTypeHandlerRegistry().register(PhoneNumber.class, PhoneTypeHandler.class);
			configuration.addMapper(StudentMapper.class);
			
			//全局参数设置
			//configuration.setCacheEnabled(true);
			//configuration.setLazyLoadingEnabled(false);
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		}
		
		return sqlSessionFactory;
	}
	
	public static SqlSession openSession() {
		return getSqlSessionFactory().openSession();
	}
}
