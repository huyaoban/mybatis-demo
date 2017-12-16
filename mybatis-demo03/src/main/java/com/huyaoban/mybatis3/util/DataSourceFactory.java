package com.huyaoban.mybatis3.util;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;

public class DataSourceFactory {
	public static DataSource getDataSource() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://192.168.119.10:3306/mybatis";
		String username = "root";
		String password = "root.123";
		
		PooledDataSource dataSource = new PooledDataSource(driver, url, username, password);
		return dataSource;
	}
}
