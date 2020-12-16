package com.atguigu.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * JDBC工具类
 * @author Administrator
 *
 */
public class JDBCUtils {

	private static Map<String, Connection> threadMap = new HashMap<String, Connection>();
	
	// 连接池
	private static DataSource dataSource = null;
	static {
		InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
		Properties pro = new Properties();
		try {
			// 读取配置文件信息
			pro.load(is);
			// 创建德鲁伊连接池
			dataSource = DruidDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// 线程名
			String threadName = Thread.currentThread().getName();
			conn = threadMap.get(threadName);
			if (conn == null) {
				conn = dataSource.getConnection();
				threadMap.put(threadName, conn);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 *	释放数据库连接 
	 */
	public static void closeConnection(Connection conn) {
		try {
			String threadName = Thread.currentThread().getName();
			threadMap.remove(threadName);
			// 这里调用的是德鲁伊连接池的连接的close方法，并没有真正地close
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
