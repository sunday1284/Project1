package kr.or.ddit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.or.ddit.util.ScanUtil;

public class JdbcTest04 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1588/FREEPDB1", 
					"CHOI", "java");
			
			System.out.println("계좌번호 정보를 입력하세요..");
			
			System.out.println("계좌번호 >> ");
			String bankNo = ScanUtil.nextLine();
			
			String bankName = ScanUtil.nextLine("은 행 명 >> ");
			
			String bankUser = ScanUtil.nextLine("예금주명 >> ");
			
			String sql = "insert into bankinfo "
					+ " (bank_no, bank_name, bank_user_name, bank_date) "
					+ " values( ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bankNo);
			pstmt.setString(2, bankName);
			pstmt.setString(3, bankUser);
			
			// select문을 실행할때는 executeQuery()메서드를 사용하고 
			
			// insert문, update문, delete문과  같이 select문이 아닌 SQL문을
			// 실행할 때는 executeUpdate()메서드를 사용한다.
			// executeUpdate()메서드의 반환값 ==> 작업 성공한 레코드 수
			int cnt = pstmt.executeUpdate();
			
			System.out.println("반환값 : " + cnt);
			if(cnt>0) {
				System.out.println("insert 성공!!!");
			}else {
				System.out.println("insert 실패~~~");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(pstmt !=null)try {pstmt.close();} catch(SQLException e) {}
			if(conn !=null)try {conn.close();} catch(SQLException e) {}
		}
	}

}
