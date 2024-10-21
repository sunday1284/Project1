package kr.or.ddit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.ddit.util.ScanUtil;

/*
 * LPROD_ID값을 2개 입력 받아서 두 값 중 작은 값부터 
 * 큰 값사이의 자료들을 출력하시오.
 */
public class JdbcTest03 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int num1 = ScanUtil.nextInt("첫번째 Lprod_Id값 입력 >> ");
		int num2 = ScanUtil.nextInt("두번째 Lprod_Id값 입력 >> ");
		
		//큰 값과 작은 값 찾기
		int max = Math.max(num1, num2);
		int min = Math.min(num1, num2);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1588/FREEPDB1",
					 "CHOI","java");
			//SQL문에 데이터가 들어갈 자리를 물음표(?)로 표시하여 작성한다.
//			String sql = "select * from lprod " 
//					     + " where lprod_id >= ? and lprod_id <= ? ";
			String sql = "select * from lprod " 
					+ " where lprod_id between ? and ? ";
			//sql문 쓸 때 유의할점: 띄워쓰기를 꼭 해야한다 줄바꿈시 + " "가 되야함
			// + 쓰고 띄우기 " 하나 쓰고 띄우기 필수!
			pstmt = conn.prepareStatement(sql);
			
			//SQL문의 물음표(?)자리에 들어갈 데이터를 셋팅한다.
			//형식) PreparedStatement객체.set자료형이름(물음표번호, 셋팅할데이터);
			//			물음표 번호는 1부터 시작한다.
			pstmt.setInt(1, min);
			pstmt.setInt(2, max);
			
			// 데이터 셋팅이 완료되면 SQL문을 실행
			rs = pstmt.executeQuery();
			
			System.out.println("== 결 과 ===");
			while(rs.next()) {
				System.out.println("ID : " +rs.getInt("lprod_id"));
				System.out.println("GU : " +rs.getString("lprod_gu")); 
				System.out.println("NM : " +rs.getString("lprod_nm"));
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
