package util;

import java.sql.*;

import com.mysql.jdbc.Statement;

public class JDBCUtil {
	public static ResultSet getQueryData(String sql){
		
		//先有数据库连接
		Connection conn = null;
		java.sql.Statement st =null;
		try {
//			conn = MyConnection.getConnection();
//			conn = DBCPUtils.getConnection();
			conn = new MyDataSource().getConnection();
			if (conn ==null) {
				return null;
			}
			st = conn.createStatement();
			return st.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void free(ResultSet rs, Statement st, Connection conn) {
		
			try {
				if (rs!=null) {
				rs.close();
				}
				if (st!=null) {
					st.close();
				}
				if (conn!=null){
					conn.close();
				} 
			}
				catch (SQLException e) {
				e.printStackTrace();
			}
		}

	public static int executeUpdate(String sql) {
		int num = 0;
		Connection conn = null;
		java.sql.Statement st =null;
		try {
			conn = new MyDataSource().getConnection();
			if (conn ==null) {
				return 0;
			}
			st = conn.createStatement();
			return st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	}

