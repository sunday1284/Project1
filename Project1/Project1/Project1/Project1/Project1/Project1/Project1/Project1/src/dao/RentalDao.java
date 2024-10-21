package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
//도서 대여 
import vo.BookVo;
public class RentalDao {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
   

 //===========================================================================================================
    
    
    // 도서 재고 감소 메서드
    public int getRentalStock(String bookId) {
        int result = 0;
        String sql = "UPDATE BOOK SET BOOK_STOCK = BOOK_STOCK - 1 WHERE BOOK_ID = ? AND BOOK_STOCK > 0 ";
        
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, bookId);
            result = ps.executeUpdate();
            
            if (result > 0) {
                System.out.println("재고가 성공적으로 감소되었습니다.");
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
    //===========================================================================================================

    //대여할 책 코드를 입력했을때 리스트를 보여주는 메서드
    public List<BookVo> getBookRentalList(String bookId) {
        List<BookVo> bookRentalList = null;
        String sql = "SELECT BOOK_ID, BOOK_NAME, BOOK_PUB, BOOK_STOCK FROM BOOK WHERE BOOK_ID = ?";
//       "INSERT INTO  MEMBER (MEM_ID) VALUES(?)"
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, bookId); // 코드에 해당하는 도서 조회
            rs = ps.executeQuery();
            bookRentalList = new ArrayList<BookVo>();
            while (rs.next()) {
                BookVo bvo = new BookVo();
                bvo.setBook_id(rs.getString("BOOK_ID"));
                bvo.setBook_name(rs.getString("BOOK_NAME"));
                bvo.setBook_pub(rs.getString("BOOK_PUB"));
                bvo.setBook_stock(rs.getInt("BOOK_STOCK"));
                bookRentalList.add(bvo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disConnect();
        }
        return bookRentalList;
    }
    
    //===========================================================================================================
  
    public int rentBook(String memId, String bookId) {
        int result = 0;
        String rentSql = "INSERT INTO RENTAL (MEM_ID, BOOK_ID, RENTAL_DATE) VALUES (?, ?, SYSDATE)";
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(rentSql);

            // 디버깅 메시지 추가
//            System.out.println("MEM_ID: " + memId);
//           System.out.println("BOOK_ID: " + bookId);

            // 쿼리문에 값 설정
            ps.setString(1, memId);
            ps.setString(2, bookId);

            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) try { ps.close(); } catch (Exception e) {}
            if (con != null) try { con.close(); } catch (Exception e) {}
        }
        return result;
    }
    //===========================================================================================================

    private void disConnect() {
        if(rs != null) try { rs.close(); } catch(Exception e) {}
        if(ps != null) try { ps.close(); } catch(Exception e) {}
        if(con != null) try { con.close(); } catch(Exception e) {}
     }//디스커넥트  
} 

    
    
   










