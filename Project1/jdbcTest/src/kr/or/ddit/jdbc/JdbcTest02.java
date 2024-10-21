package kr.or.ddit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.ddit.util.ScanUtil;

// 사용자로부터 LPROD_ID값을 입력 받아 입력한 값보다
//LPROD_ID가 큰 자료들을 출력하시오.
public class JdbcTest02 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int num = ScanUtil.nextInt("Lprod_Id값 입력 >> ");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1588/FREEPDB1",
					 "CHOI","java");
			//SQL문에 데이터가 들어갈 자리를 물음표(?)로 표시하여 작성한다.
			String sql = "select lprod_id, lprod_gu gu, lprod_nm " 
					     + " from lprod where lprod_id > ? ";
			//sql문 쓸 때 유의할점: 띄워쓰기를 꼭 해야한다 줄바꿈시 + " "가 되야함
			
			pstmt = conn.prepareStatement(sql);
			
			//SQL문의 물음표(?)자리에 들어갈 데이터를 셋팅한다.
			//형식) PreparedStatement객체.set자료형이름(물음표번호, 셋팅할데이터);
			//			물음표 번호는 1부터 시작한다.
			pstmt.setInt(1, num);
			
			// 데이터 셋팅이 완료되면 SQL문을 실행
			rs = pstmt.executeQuery();
			
			System.out.println("== 결 과 ===");
			while(rs.next()) {
				System.out.println("ID : " +rs.getInt("lprod_id"));
				System.out.println("GU : " +rs.getString("gu")); //엘리어스 지정
				System.out.println("NM : " +rs.getString(3));
				System.out.println("---------------------------------");
			}
			System.out.println("출력 끝...");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			//5. 자원 반납
			if(rs != null) try {rs.close();}catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException e) {}
			if(conn != null) try {conn.close();}catch(SQLException  e) {}
		}
		
	}

}
