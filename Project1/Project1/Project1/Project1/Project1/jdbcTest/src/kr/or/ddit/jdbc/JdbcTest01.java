package kr.or.ddit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * JDBC(Java DataBase Connectivity)라이브러리를 이용하여 DB자료 처리하기
 * 
 * -처리 순서
 * 1. 드라이버 로딩 ==> 라이브러리를 사용할 수 있게 메모리로 읽어 들이는 작업
 * 	   Class.forName("oracle.jdbc.driver.OracleDriver");
 * 2. DB에 접속하기 ==> 접속이 완료되면 Connection객체가 반환된다.
 * 	  DriverManager.getConnection()메서드를 이용한다.
 * 3. 질의 ==> SQL문장을 DB서버로 보내서 처리하고 그 결과를 얻어온다.
 * 	  (Statement객체 또는 PreparedStatement객체를 이용한다.)
 * 4. 결과 처리 ==> 질의 결과를 받아서 원하는 작업을 수행한다.
 * 	 1) SQL문이 select문일 경우에는 select한 결과가 ResultSet객체에 
 *     저장되어 반환된다.
 *   2) SQL문이 select문이 아닐 경우(insert문, delete문, update문 등)
 *      ==> 정수값이 반환된다. 
 *      	(이 정수값은 보통 실행에 성공한 레코드 수를 의미)
 *  5. 사용했던 자원을 반납한다.
 *  	  ==> 각 객체의 close()메서드를 호출하여 처리한다.
 * 	
 */
public class JdbcTest01 {

	public static void main(String[] args) {
		//DB작업에 필요한 변수 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. DB 연결 ==> Connection 객체 생성
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1588/FREEPDB1",
					"CHOI","java"); //도커를 썼을때는 /를 써야함
			
			//3. 질의
			
			//3-1. SQL문 작성
			String sql = "select * from lprod";
			
			//3-2. PreparedStatement객체 생성 ==>질의하는 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 3-3. SQL문을 DB서버로 보내서 결과를 얻어온다.
			//		(실행할 SQL문이 select문이기 때문에 실행 결과가
			//		ResultSet객체에 저장되어 반환된다.
			rs = pstmt.executeQuery(); //rs는 resultSet select 결과가 들어감
			
			//4. 결과 처리 ==> 한 레코드씩 화면 출력
			//ResultSet에 저장된 데이터를 차례로 꺼내오려면
			//반복문과 next()메서드를 이용한다.
			System.out.println("== 처리문 처리 결과 ==");
			
			//ResultSet객체의 next()메서드 
			// ==> 데이터를 가리키는 포인터를 다음번째 레코드로 이동시키고
			//	   그 곳에 데이터가 있으면 true, 없으면 false를 반환한다.
			while(rs.next()) { //결과 처리
				//포인터가 가리키는 곳의 자료 가져오기
				//형식1) ResultSet객체.get자료형이름("컬럼명");
				//형식2) ResultSet객체.get자료형이름("엘리어스명");
				//형식3) ResultSet객체.get자료형이름(컬럼번호);
				//				==> 컬럼 번호는 1부터 시작한다.
				System.out.println("LPROD_ID : " +rs.getInt("lprod_id"));
				System.out.println("LPROD_GU : " +rs.getString(2));
				System.out.println("LPROD_NM : " +rs.getString("LPROD_NM"));
				System.out.println("----------------------------------------");
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
