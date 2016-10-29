package com.century.longjiang.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * c3p0连接MySQL数据库工具包
 * 
 * @author 冰雨凌風
 * 
 */
public class C3P0Utils {
	// 定义全局变量
	private static ComboPooledDataSource cpds;
	// 静态代码块
	static {
		cpds = new ComboPooledDataSource("test");
	}

	// 获得数据源
	public static DataSource getDataSource() {
		return cpds;
	}

	// 获得连接
	public static Connection getConnection() throws Exception {
		return cpds.getConnection();
	}
	
	public static void closeAll(Connection conn,Statement stmt,ResultSet rs){
		
		if(rs!=null){
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
}
