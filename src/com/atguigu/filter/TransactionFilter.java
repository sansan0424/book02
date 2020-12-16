package com.atguigu.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.atguigu.utils.JDBCUtils;

/**
 * 事务过滤器
 */
public class TransactionFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		Connection conn = null;
		
		try {
			conn = JDBCUtils.getConnection();
			// 开启事务
			conn.setAutoCommit(false);
			// 放行
			chain.doFilter(request, response);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JDBCUtils.closeConnection(conn);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
