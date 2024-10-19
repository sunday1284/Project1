package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBUtil;
import vo.BookVo;

   public class BookDao {
      
      private Connection con = null;
      private PreparedStatement ps = null;
      private ResultSet rs = null;
//--------------------------------------------------------------------------
      private void disConnect() {
      if(rs != null) try { rs.close(); } catch(Exception e) {}
      if(ps != null) try { ps.close(); } catch(Exception e) {}
      if(con != null) try { con.close(); } catch(Exception e) {}
   }//디스커넥트
      
   // 책 전체 내용을 가져와 List에 저장하는 메서드
      public List<BookVo> getBookList(String code){      // 전체
         List<BookVo> bookList = null;
         
         String sql = "SELECT * FROM BOOK "
         		+ " ORDER BY BOOK_ID ASC";
         
         try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            bookList = new ArrayList<BookVo>();
            while(rs.next()) {
               BookVo bvo = new BookVo();
               bvo.setBook_id(rs.getString("BOOK_ID"));
               bvo.setBook_name(rs.getString("BOOK_NAME"));
               bvo.setBook_pub(rs.getString("BOOK_PUB"));
               bookList.add(bvo);
            }
            
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            disConnect();
         }
         
         return bookList;
      }//리스트
//===================================================================================      
      public List<BookVo> getSBookList(){      // 과학
         List<BookVo> sbookList = null;
         
         String sql = "SELECT BOOK_ID, BOOK_NAME, BOOK_PUB "
         		+ " FROM BOOK "
         		+ " WHERE BOOK_ID LIKE 's%%' "
         		+ " ORDER BY BOOK_ID ASC";
         try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            sbookList = new ArrayList<BookVo>();
            while(rs.next()) {
               BookVo bvo = new BookVo();
               bvo.setBook_id(rs.getString("BOOK_ID"));
               bvo.setBook_name(rs.getString("BOOK_NAME"));
               bvo.setBook_pub(rs.getString("BOOK_PUB"));
               sbookList.add(bvo);
            }
            
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            disConnect();
         }
         
         return sbookList;
      }//리스트
//================================================================================================
      public List<BookVo> getFBookList(){         // 동화
         List<BookVo> fbookList = null;
         
         String sql = "SELECT BOOK_ID, BOOK_NAME, BOOK_PUB FROM BOOK WHERE BOOK_ID LIKE 'f%%' ";
         
         try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            fbookList = new ArrayList<BookVo>();
            while(rs.next()) {
               BookVo bvo = new BookVo();
               bvo.setBook_id(rs.getString("BOOK_ID"));
               bvo.setBook_name(rs.getString("BOOK_NAME"));
               bvo.setBook_pub(rs.getString("BOOK_PUB"));
               fbookList.add(bvo);
            }
            
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            disConnect();
         }
         
         return fbookList;
      }//리스트
//==============================================================================================================
      public List<BookVo> getABookList(){      // 심리학
         
         
         List<BookVo> abookList = null;
         
         String sql = "SELECT BOOK_ID, BOOK_NAME, BOOK_PUB FROM BOOK WHERE BOOK_ID LIKE 'a%%' ";
         
         
         try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            abookList = new ArrayList<BookVo>();
            while(rs.next()) {
               BookVo bvo = new BookVo();
               bvo.setBook_id(rs.getString("BOOK_ID"));
               bvo.setBook_name(rs.getString("BOOK_NAME"));
               bvo.setBook_pub(rs.getString("BOOK_PUB"));
               abookList.add(bvo);
            }
            
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            disConnect();
         }
         
         return abookList;
      }//리스트
//=============================================================================================
      public List<BookVo> getGBookList(){      // 고전
         List<BookVo> gbookList = null;
         
         String sql = "SELECT BOOK_ID, BOOK_NAME, BOOK_PUB FROM BOOK WHERE BOOK_ID LIKE 'g%%' ";
         
         try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            gbookList = new ArrayList<BookVo>();
            while(rs.next()) {
               BookVo bvo = new BookVo();
               bvo.setBook_id(rs.getString("BOOK_ID"));
               bvo.setBook_name(rs.getString("BOOK_NAME"));
               bvo.setBook_pub(rs.getString("BOOK_PUB"));
               gbookList.add(bvo);
            }
            
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            disConnect();
         }
         
         return gbookList;
      }//리스트
//================================================================================
      public List<BookVo> getPBookList(){         // 정치
         List<BookVo> pbookList = null;
         
         String sql = "SELECT BOOK_ID, BOOK_NAME, BOOK_PUB FROM BOOK WHERE BOOK_ID LIKE 'p%%' ";
         
         try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            pbookList = new ArrayList<BookVo>();
            while(rs.next()) {
               BookVo bvo = new BookVo();
               bvo.setBook_id(rs.getString("BOOK_ID"));
               bvo.setBook_name(rs.getString("BOOK_NAME"));
               bvo.setBook_pub(rs.getString("BOOK_PUB"));
               pbookList.add(bvo);
            }
            
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            disConnect();
         }
         
         return pbookList;
      }//리스트
//===========================================================================
      public List<BookVo> getEBookList(){            // 경제
         List<BookVo> ebookList = null;
         
         String sql = "SELECT BOOK_ID, BOOK_NAME, BOOK_PUB FROM BOOK WHERE BOOK_ID LIKE 'e%%' ";
         
         try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ebookList = new ArrayList<BookVo>();
            while(rs.next()) {
               BookVo bvo = new BookVo();
               bvo.setBook_id(rs.getString("BOOK_ID"));
               bvo.setBook_name(rs.getString("BOOK_NAME"));
               bvo.setBook_pub(rs.getString("BOOK_PUB"));
               ebookList.add(bvo);
            }
            
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            disConnect();
         }
         
         return ebookList;
      }//리스트
//============================================================================================
      public List<BookVo> getHBookList(){         // 역사
         List<BookVo> hbookList = null;
         
         String sql = "SELECT BOOK_ID, BOOK_NAME, BOOK_PUB FROM BOOK WHERE BOOK_ID LIKE 'h%%' ";
         
         try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            hbookList = new ArrayList<BookVo>();
            while(rs.next()) {
               BookVo bvo = new BookVo();
               bvo.setBook_id(rs.getString("BOOK_ID"));
               bvo.setBook_name(rs.getString("BOOK_NAME"));
               bvo.setBook_pub(rs.getString("BOOK_PUB"));
               hbookList.add(bvo);
            }
            
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            disConnect();
         }
         
         return hbookList;
      }//리스트
//=================================================================================================
      public List<BookVo> getDBookList(){            // 자기개발
         List<BookVo> dbookList = null;
         
         String sql = "SELECT BOOK_ID, BOOK_NAME, BOOK_PUB FROM BOOK WHERE BOOK_ID LIKE 'd%%' ";
         
         try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            dbookList = new ArrayList<BookVo>();
            while(rs.next()) {
               BookVo bvo = new BookVo();
               bvo.setBook_id(rs.getString("BOOK_ID"));
               bvo.setBook_name(rs.getString("BOOK_NAME"));
               bvo.setBook_pub(rs.getString("BOOK_PUB"));
               dbookList.add(bvo);
            }
            
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            disConnect();
         }
         
         return dbookList;
      }//리스트
//===================================================================================================
      public List<BookVo> getMBookList(){               // 음악
         List<BookVo> mbookList = null;
         
         String sql = "SELECT BOOK_ID, BOOK_NAME, BOOK_PUB FROM BOOK WHERE BOOK_ID LIKE 'm%%' ";
         
         try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            mbookList = new ArrayList<BookVo>();
            while(rs.next()) {
               BookVo bvo = new BookVo();
               bvo.setBook_id(rs.getString("BOOK_ID"));
               bvo.setBook_name(rs.getString("BOOK_NAME"));
               bvo.setBook_pub(rs.getString("BOOK_PUB"));
               mbookList.add(bvo);
            }
            
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            disConnect();
         }
         
         return mbookList;
      }//리스트
//====================================================================================
      public List<BookVo> getBookAlList(){      // 전체
         List<BookVo> bookAlList = null;
         
         String sql = "SELECT * FROM BOOK ORDER BY BOOK_ID ASC";
         
         try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            bookAlList = new ArrayList<BookVo>();
            while(rs.next()) {
               BookVo bvo = new BookVo();
               bvo.setBook_id(rs.getString("BOOK_ID"));
               bvo.setBook_name(rs.getString("BOOK_NAME"));
               bvo.setBook_pub(rs.getString("BOOK_PUB"));
               bookAlList.add(bvo);
            }
            
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            disConnect();
         }
         
         return bookAlList;
      }//리스트
      
      public int insertBook(String bookId, String bookName, String bookPub, int bookStock) {
    	    Connection con = null;
    	    PreparedStatement insertPs = null;
    	    int insertResult = 0;
    	    try {
    	        con = DBUtil.getConnection();
    	        String insertSql = "INSERT INTO BOOK (BOOK_ID, BOOK_NAME, BOOK_PUB, BOOK_STOCK) VALUES (?, ?, ?, ?)";
    	        insertPs = con.prepareStatement(insertSql);
    	        insertPs.setString(1, bookId);
    	        insertPs.setString(2, bookName);
    	        insertPs.setString(3, bookPub);
    	        insertPs.setInt(4, bookStock);
    	        insertResult = insertPs.executeUpdate();

    	        if (insertResult > 0) {
    	            System.out.println("새 책이 추가되었습니다.");
    	        } else {
    	            System.out.println("책 추가에 실패했습니다.");
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    } finally {
    	        if (insertPs != null) try { insertPs.close(); } catch (Exception e) {}
    	        if (con != null) try { con.close(); } catch (Exception e) {}
    	    }
    	    return insertResult;
    	}
      	
   // 책이 이미 존재하는지 확인하는 메서드
      public boolean checkBookExists(String bookId) {
          Connection con = null;
          PreparedStatement ps = null;
          ResultSet rs = null;
          boolean exists = false;

          try {
              con = DBUtil.getConnection();
              String sql = "SELECT COUNT(*) FROM BOOK WHERE BOOK_ID = ?";
              ps = con.prepareStatement(sql);
              ps.setString(1, bookId);
              rs = ps.executeQuery();

              if (rs.next()) {
                  exists = rs.getInt(1) > 0;
              }
          } catch (SQLException e) {
              e.printStackTrace();
          } finally {
              if (rs != null) try { rs.close(); } catch (Exception e) {}
              if (ps != null) try { ps.close(); } catch (Exception e) {}
              if (con != null) try { con.close(); } catch (Exception e) {}
          }
          return exists;
      }
    	public int updateBookStock1(String bookId) {
    	    Connection con = null;
    	    PreparedStatement updatePs = null;
    	    int updateResult = 0;
    	    try {
    	        con = DBUtil.getConnection();
    	        String updateSql = "UPDATE BOOK SET BOOK_STOCK = BOOK_STOCK + 1 WHERE BOOK_ID = ?";
    	        updatePs = con.prepareStatement(updateSql);
    	        updatePs.setString(1, bookId);
    	        updateResult = updatePs.executeUpdate();

    	        if (updateResult > 0) {
    	            System.out.println("기존 책의 재고량이 1 증가되었습니다.");
    	        } else {
    	            System.out.println("책 재고량 증가에 실패했습니다.");
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    } finally {
    	        if (updatePs != null) try { updatePs.close(); } catch (Exception e) {}
    	        if (con != null) try { con.close(); } catch (Exception e) {}
    	    }
    	    return updateResult;
    	}

    	public int deleteBook(String bookId) {
    	    Connection con = null;
    	    PreparedStatement deletePs = null;
    	    int deleteResult = 0;
    	    try {
    	        con = DBUtil.getConnection();
    	        String deleteSql = "DELETE FROM BOOK WHERE BOOK_ID = ? AND BOOK_STOCK = 0";
    	        deletePs = con.prepareStatement(deleteSql);
    	        deletePs.setString(1, bookId);
    	        deleteResult = deletePs.executeUpdate();

    	        if (deleteResult > 0) {
    	            System.out.println("재고량이 1이었으므로 해당 도서가 삭제되었습니다.");
    	        } else {
    	            System.out.println("재고량이 1 이상이 아니며 해당 도서도 삭제되지 않았습니다.");
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    } finally {
    	        if (deletePs != null) try { deletePs.close(); } catch (Exception e) {}
    	        if (con != null) try { con.close(); } catch (Exception e) {}
    	    }
    	    return deleteResult;
    	}

    	public int updateBookStock2(String bookId) {
    	    Connection con = null;
    	    PreparedStatement updatePs = null;
    	    int updateResult = 0;
    	    try {
    	        con = DBUtil.getConnection();
    	        String updateSql = "UPDATE BOOK SET BOOK_STOCK = BOOK_STOCK - 1 WHERE BOOK_ID = ? AND BOOK_STOCK > 0";
    	        updatePs = con.prepareStatement(updateSql);
    	        updatePs.setString(1, bookId);
    	        updateResult = updatePs.executeUpdate();

    	        if (updateResult > 0) {
    	            System.out.println("재고량이 1개 이상이므로 재고량이 감소되었습니다.");
    	        } else {
    	            deleteBook(bookId);
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    } finally {
    	        if (updatePs != null) try { updatePs.close(); } catch (Exception e) {}
    	        if (con != null) try { con.close(); } catch (Exception e) {}
    	    }
    	    return updateResult;
    	}

      
      

}//클래스

   