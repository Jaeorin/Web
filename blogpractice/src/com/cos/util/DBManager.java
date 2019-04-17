package com.cos.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class DBManager {

	static final Logger LOG = LogManager.getLogger(DBManager.class.getName());
	
	public static Connection getConnection() {

		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			Connection conn = ds.getConnection();

			return conn;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			pstmt.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
