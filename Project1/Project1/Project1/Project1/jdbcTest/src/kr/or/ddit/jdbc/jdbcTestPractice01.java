package kr.or.ddit.jdbc;
/*
 * jdbcTest6연습
 *회원 관리를 하는 프로그램을 작성하시오. (MYMEMBER 테이블 이용)
 * 
 * 아래 메뉴의 기능을 모두 구현하시오. (CRUD기능 구현)
 * C - CREATE ==> insert 문
 * R - Read   ==> select 문
 * U - Update ==> update 문
 * D - Delete ==> delete 문
 * 
 * 예시메뉴)
 * ----------------------
 * 1.자료 추가
 * 2.자료 삭제
 * 3.자료 수정
 * 4.전체 자료 출력
 * 0.작업 끝
 * ----------------------
 * 
 * 조건)
 * 1) 자료 추가에서 '회원ID'는 중복되지 않는다.(중복되면 다시 입력 받음)
 * 2) 자료 삭제는 '회원ID'를 입력 받아서 처리한다.
 * 3) 자료 수정에서 '회원ID'는 변경되지 않는다.
 * 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.ScanUtil;

public class jdbcTestPractice01 {
	//인스턴스 변수 초기화 
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	public static void main(String[] args) {
		new jdbcTestPractice01().memberStart();
	}
	//회원 아이디를 매개변수로 받아서 해당 회원ID의 개수를 반환하는 메서드
	private int getMemberCount(String memId) {
		int count = 0; //변환값 저장될 변수
		try {
			conn = DBUtil.getConnection();
			String sql = "select count(*) cnt from mymember "
					+ " where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		    } catch (SQLException e) {
		    	e.printStackTrace();
		    }finally {
		    	disConnect();
		    }
			return count;
	}
	
	private void memberStart() {
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("		회 원 관 리 프 로 그 램");
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println();
		while(true) {
			int choice = displayMenu();
			switch(choice) {
			case 1:
				insertMember();
				return;
			case 2:
				deleteMember();
				break;
			case 3:
				updateMember();
				break;
			case 4:
				displayAllMember();
				break;
			case 5:
				updateMember2();
				break;
			case 0:
				System.out.println("회원 관리 프로그램을 종료합니다.");
				return;
			default:
				System.out.println("숫자를 잘못 입력하였습니다.");
				System.out.print("다시 입력 >>");
				System.out.println();
			}
		}
	}
	

	private int displayMenu() {
		//메뉴 
		System.out.println("------------------------------------------------");
		System.out.println("		1.자료 추가  ");
		System.out.println("		2.자료 삭제  ");
		System.out.println("		3.자료 전체 항목  ");
		System.out.println("		4.자료 자료 출력  ");
		System.out.println("		5.자료 선택 항목  ");
		System.out.println("		0.작업 끝  ");
		System.out.println("------------------------------------------------");
		return ScanUtil.nextInt("작업 번호 선택 >> ");
	}
	//update ==> 선택 항목 수정 -> sql문을 전체 항목 수정에서 4등분 하여 switch문 활용하여 구함
	private void updateMember2() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요.");
		String memId = ScanUtil.nextLine("회원ID >> ");
		
		int count = getMemberCount(memId);
		if(count == 0) {//회원이 없으면
			System.out.println(memId +"는(은) 없는 회원ID 입니다.");
			System.out.println("수정 작업을 마칩니다....");
			return;
		}
		System.out.println();
		System.out.println("수정할 내용을 입력하세요.");
		System.out.println("1. 비밀번호");
		System.out.println("2. 이름");
		System.out.println("3. 전화번호");
		System.out.println("4. 주소");
		int num = ScanUtil.nextInt("수정할 항목(번호)을 입력하세요: ");
		
		String sql = null; //null값으로 변수 초기화
		try {
			conn = DBUtil.getConnection();
			//switch문을 활용하여 num값에 따라 항목을 선택하여 수정하는 코드이다.
			//전체 수정 sql문을 쪼개어 4개로 나누면 가능하다 
			//memId값도 있어야 하므로 where절에 memId값을 무조건 써줘야함. => 증가값이 들어가야된다.
			switch(num) {
			case 1:
				String newMemPass = ScanUtil.nextLine("새로운 비밀번호 >> ");
				sql = "update mymember set mem_pass = ? where mem_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, newMemPass);
				pstmt.setString(2, memId);
				break;
			case 2:
				String newMemName = ScanUtil.nextLine("수정할 회원이름 >> ");
				sql = "update mymember set mem_name = ? where mem_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, newMemName);
				pstmt.setString(2, memId);
				break;
			case 3:
				String newMemTel = ScanUtil.nextLine("수정할 전화번호 >> ");
				sql = "update mymember set mem_tel = ? where mem_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, newMemTel);
				pstmt.setString(2, memId);
				break;
			case 4:
				String newMemAddr = ScanUtil.nextLine("수정할 회원주소 >> ");
				sql = "update mymember set mem_addr = ? where mem_id = ?";
				pstmt.setString(1, newMemAddr);
				pstmt.setString(2, memId);
				break;
			default:
				System.out.println("잘못 선택하였습니다...");
				return;
			}
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println(memId + " 회원 정보 수정 완료!!!");
			}else {
				System.out.println(memId + " 회원 정보 수정 실패~~~");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
	}
	//insert
	private void insertMember() {
		System.out.println();
		System.out.println("추가할 회원 정보 입력하세요.");
		int count = 0; //회원ID의 개수가 저장될 변수
		String memId = null; //회원ID가 저장될 변수
		do {
			System.out.println();
			memId = ScanUtil.nextLine("회원ID >> ");
			count = getMemberCount(memId);
			if(count>0) {
				System.out.println(memId + "는(은) 이미 등록된 회원ID 입니다.");
				System.out.println("다른 회원ID를 입력하세요....");
			}
		} while (count>0);
			String MEMPASS = ScanUtil.nextLine("비밀번호 입력하세요 : ");
			String MEMNAME = ScanUtil.nextLine("회원이름을 입력하세요 : ");
			String MEMTEL = ScanUtil.nextLine("전화번호를 입력하시오 : ");
			String MEMADDR = ScanUtil.nextLine("회원주소를 입력하세요 : ");
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into MYMEMBER (MEM_ID, MEM_PASS, MEM_NAME, "
					+ " MEM_TEL, MEM_ADDR) values( ?, ?, ?, ?, ? )";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memId);
			pstmt.setString(2, MEMPASS);
			pstmt.setString(3, MEMNAME);
			pstmt.setString(4, MEMTEL);
			pstmt.setString(5, MEMADDR);
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println(memId + "회원 정보 추가 완료!!");
			}else {
				System.out.println(memId + "회원 정보 추가 실패~~");
			}
			
			System.out.println("자료가 추가되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}
	
	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력세요.");
		System.out.print("삭제할 회원ID >> ");
		String memId = ScanUtil.nextLine();
		
		int count = getMemberCount(memId);
		if(count == 0) {
			System.out.println(memId + "는(은) 없는 회원ID 입니다.");
			System.out.println("삭제 작업을 마칩니다....");
			return;
		}
		
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from mymember where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			int cnt = pstmt.executeUpdate(); //삭제작업 시작
			if(cnt>0) {
				System.out.println(memId+"회원 정보 삭제 완료!!");
			}else {
				System.out.println(memId+"회원 정보 삭제 실패~~");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}
	
	private void updateMember() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요.");
		String memId = ScanUtil.nextLine("회원ID >> ");
		
		int count = getMemberCount(memId);
		if(count == 0) {
			System.out.println(memId + "는(은) 없는 회원ID 입니다.");
			System.out.println("수정 작업을 마칩니다.");
			return;
		}
		System.out.println();
		System.out.println("수정할 내용을 입력하세요. ");
		String newMemPass = ScanUtil.nextLine("새로운 비밀번호 >> ");
		String newMemName = ScanUtil.nextLine("새로운 회원이름 >> ");
		String newMemTel= ScanUtil.nextLine("새로운 전화번호 >> ");
		String newMemAddr = ScanUtil.nextLine("새로운 회원주소 >> ");
		try {
			conn = DBUtil.getConnection();
			String sql = "update mymember set mem_pass = ?, mem_name = ? , "
					+ " mem_tel = ?, mem_addr = ? "
					+ " where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, newMemPass);
			pstmt.setString(2, newMemName);
			pstmt.setString(3, newMemTel);
			pstmt.setString(4, newMemAddr);
			pstmt.setString(5, memId);
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println(memId + " 회원 정보 수정 완료!!!");
			}else {
				System.out.println(memId + " 회원 정보 수정 실패~~~");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
	}
	//전체 출력
	private void displayAllMember() {
		System.out.println();
		System.out.println("--------------------------------------------");
		System.out.println(" ID		비밀번호		이름		전화번호		주소");
		System.out.println("--------------------------------------------");
		try {
			conn = DBUtil.getConnection();
			
			String sql = "select * from mymember";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery(); //select문이므로 이 함수를 쓴다.
			
			int cnt = 0;
			
			while(rs.next()) {
				cnt++;
				String memId = rs.getString("mem_id");
				String memPass = rs.getString("mem_pass");
				String memName = rs.getString("mem_name");
				String memTel = rs.getString("mem_tel");
				String memAddr = rs.getString("mem_addr");
				System.out.println(memId + "\t" + memPass + "\t" + memName +
								"\t" + memTel + "\t" + memAddr);
			}
			if(cnt==0) {
				System.out.println("등록된 회원이 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
	}
	
	
	//사용한 자원 반환 메서드
	private void disConnect() {
		if(rs!=null) try {rs.close();}catch(SQLException e) {}
		if(pstmt!=null) try {pstmt.close();}catch(SQLException e) {}
		if(conn!=null) try {conn.close();}catch(SQLException e) {}
	}

}
