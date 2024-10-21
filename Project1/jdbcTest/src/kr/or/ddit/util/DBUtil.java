package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// JDBC드라이버를 로딩하고 Connection객체를 생성하여 반환하는 메서드로 구성된 class
public class DBUtil {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패~~");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1588/FREEPDB1"
					,"CHOI","java");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패 ~~~");
			e.printStackTrace();
		}
		
		return conn;
	}
}
