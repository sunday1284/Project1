package kr.or.ddit.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.ScanUtil;

/*
 	LPROD테이블에 새로운 데이터 추가하기
 	
 	Lprod_gu와 Lpord_nm은 직접 입력 받아서 처리,
 	Lprod_id는 현재의 Lprod_id 중에서 제일 큰 값보다 1 크게 한다.
 	
 	입력 받은 lprod_gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다. 
 */
public class JdbcTest05 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1588/FREEPDB1",
//					"CHOI","java");
			
			conn = DBUtil.getConnection();
			
//			Lprod_id는 현재의 Lprod_id 중에서 제일 큰 값보다 1 크게 한다.
			String sql = "select max(lprod_id) maxid from lprod";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			int nextId = 0;
			
			// ResultSet에 저장된 데이터가 1개의 Row(레코드)일 경우에는 
			// 반복문 대신 if문으로 처리해도 된다.
			if(rs.next()) {
				nextId = rs.getInt("maxid");
			}
			nextId++;
			//------------------------------------------------
			
			//입력 받은 lprod_gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다.----
			String gu = null;	// 입력한 Lprod_Gu값이 저장될 변수
			int count = 0;      // 입력한 Lprod_Gu의 갯수가 저장될 변수
			
			String sql2 = "select count(*) cnt from lprod where lprod_gu = ?";
			pstmt = conn.prepareStatement(sql2);
			
			do {
				gu = ScanUtil.nextLine("Lprod_Gu 입력 >> ");
				
				// 입력한 값을 SQL문의 물음표 자리에 셋팅 
				pstmt.setString(1, gu);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt("cnt");
				}
				
				if(count>0) {
					System.out.println("입력한 LPROD_GU인 " + gu 
							+ "는 이미 등록된 값입니다..");
					System.out.println("다시 입력하세요...");
				}
			}while(count>0);
			
			
			//-------------------------------------------------------
			
			
			String nm =ScanUtil.nextLine("LPROD_NM 입력 >>");
			
			String sql3 = "insert into lprod(lprod_id, lprod_gu, lprod_nm)"
					+ " values( ?, ?, ?)";
			pstmt = conn.prepareStatement(sql3);
			pstmt.setInt(1, nextId);
			pstmt.setString(2, gu);
			pstmt.setString(3, nm);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("등록 성공!!!");
			}else {
				System.out.println("등록 실패~~~");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
		}finally {
			if(conn!=null)try {conn.close();} catch(SQLException e){}
			if(pstmt!=null)try {pstmt.close();} catch(SQLException e){}
			if(rs!=null)try {rs.close();} catch(SQLException e){}
		}
	}

}
