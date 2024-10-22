package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import vo.RentalVo;
//도서 반납 ,
public class BReturnDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	// 도서 재고 증가 메서드
	public int bReturnbookStock(String bookId) {
		int result = 0;
		String sql = "UPDATE BOOK SET BOOK_STOCK = BOOK_STOCK + 1 WHERE BOOK_ID = ? AND BOOK_STOCK > 0 ";

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, bookId);
			result = ps.executeUpdate();

			if (result > 0) {
				System.out.println("재고가 성공적으로 증가되었습니다.");
			} else {
				System.out.println("재고가 부족합니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return result;
	}

	public List<RentalVo> getBookBreturnList(String bookId) {
		List<RentalVo> bookBreturnList = null;
		String sql = "SELECT RENTAL_DATE, RENTAL_ID, BOOK_ID, MEM_ID FROM RENTAL WHERE BOOK_ID = ?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, bookId); // 코드에 해당하는 도서 조회
			rs = ps.executeQuery();
			bookBreturnList = new ArrayList<RentalVo>();
			while (rs.next()) {
				RentalVo rvo = new RentalVo();
				rvo.setRental_date(rs.getString("RENTAL_DATE"));
				rvo.setRental_id(rs.getString("RENTAL_ID"));
				rvo.setBook_id(rs.getString("BOOK_ID"));
				rvo.setMem_id(rs.getString("MEM_ID"));
				bookBreturnList.add(rvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return bookBreturnList;
	}
	public int breturnBook(String memId, String bookId,String rentalId) {
		int result = 0;
		String rentSql = "INSERT INTO BRETURN (MEM_ID, BOOK_ID, BRETURN_DATE,RENTAL_ID) VALUES (?, ?, SYSDATE,?)";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(rentSql);


			// 쿼리문에 값 설정
			ps.setString(1, memId);
			ps.setString(2, bookId);
			ps.setString(3, rentalId);

			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
		return result;
	}
	
	//RENTAL 테이블에 있는 데이터 값들을 제거
	public int delebreturnBook(String memId, String bookId) {
		int result = 0;
		String sql = "DELETE FROM RENTAL WHERE MEM_ID = ? AND BOOK_ID = ?";
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);

			
			// 쿼리문에 값 설정
			ps.setString(1, memId); // memId에 삭제할 회원 ID를 넣음
			ps.setString(2, bookId); // bookId에 삭제할 도서 ID를 넣음

			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
		return result;
	}
	private void disConnect() {
		if (rs != null)
			try {
				rs.close();
			} catch (Exception e) {
			}
		if (ps != null)
			try {
				ps.close();
			} catch (Exception e) {
			}
		if (con != null)
			try {
				con.close();
			} catch (Exception e) {
			}
	}// 디스커넥트
}
