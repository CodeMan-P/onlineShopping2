package com.util;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;

public class DbConn {
	public static BasicDataSource bds;
	//jdbc:mysql://localhost:3306/mydb
	//jdbc:oracle:thin:@localhost:1521:orcl
	final String Url = "jdbc:mysql://localhost:3306/shop?characterEncoding=UTF-8";
	public DbConn() {
			bds = new BasicDataSource();
			bds.setDriverClassName("com.mysql.jdbc.Driver");
			bds.setUrl(Url);
			bds.setUsername("root");
			bds.setPassword("mysql");
			bds.setMaxActive(5);
			bds.setMaxIdle(5);
			bds.setMaxWait(1000);
	}
	public static Connection getCon(){
		Connection con = null;
		if(bds == null)
			 new DbConn();
		try {
			con = bds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void closeBds() {
		try {
			if(bds != null) {
				bds.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
