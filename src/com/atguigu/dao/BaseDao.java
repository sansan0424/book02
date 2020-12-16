package com.atguigu.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.atguigu.utils.JDBCUtils;

/**
 * 基础dao
 * @author Administrator
 *
 */
@SuppressWarnings("unchecked")
public abstract class BaseDao<T> {

	private QueryRunner queryRunner = new QueryRunner();
	
	private Class<T> type;
	{
		// 获取具体实现dao的父类的泛型的类型
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType)genericSuperclass;
		type = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		
	}
	
	/**
	 * 获取单个JavaBean
	 * @return
	 */
	public T getBean(String sql, Object... params) {
		T t = null;
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			t = queryRunner.query(conn, sql, new BeanHandler<T>(type), params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		return t;
	}
	
	/**
	 * 获取JavaBean列表
	 * @return
	 */
	public List<T> getBeanList(String sql, Object... params){
		List<T> list = null;
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			list = queryRunner.query(conn, sql, new BeanListHandler<T>(type), params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		return list;
	}
	
	/**
	 * 增删改操作
	 * @return
	 */
	public int update(String sql, Object... params) {
		int result = 0;
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			result = queryRunner.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		return result;
	}
	
	/**
	 * 查询单个数值
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Object getValue(String sql, Object... params) {
		Object result = null;
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			result = queryRunner.query(conn, sql, new ScalarHandler(), params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		return result;
	}
	
	public int[] batch(String sql, Object[][] params) {
		int[] result = null;
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			result = queryRunner.batch(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		return result;
	} 
	
}
