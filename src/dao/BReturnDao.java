package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;
////return ==> x--;
//book y ++;
public class BReturnDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	// 도서 반납 메서드
    public int breturnBook(int bookId, int memId) {
        int result = 0;
        String returnSql = "DELETE FROM RENTAL WHERE BOOK_ID = ? AND MEM_ID = ?";
        String updateBookStockSql = "UPDATE BOOK SET BOOK_STOCK = BOOK_STOCK + 1 WHERE BOOK_ID = ?"; // 재고 증가 쿼리
        try {
            con = DBUtil.getConnection();
            con.setAutoCommit(false); // 트랜잭션 처리 시작

            // 1. 대여 정보를 삭제
            ps = con.prepareStatement(returnSql);
            ps.setInt(1, bookId);
            ps.setInt(2, memId);
            result = ps.executeUpdate();

            if (result > 0) {
                // 2. 재고를 증가시킴
                ps = con.prepareStatement(updateBookStockSql);
                ps.setInt(1, bookId);
                ps.executeUpdate();
            }

            con.commit(); // 트랜잭션 완료
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (con != null) con.rollback(); // 오류 시 롤백
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
        	if(rs != null) try { rs.close(); } catch(Exception e) {}
    		if(ps != null) try { ps.close(); } catch(Exception e) {}
    		if(con != null) try { con.close(); } catch(Exception e) {}
        }
        return result;
    }
}

