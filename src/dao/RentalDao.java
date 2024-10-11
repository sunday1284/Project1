package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;
////rental ==> x++;
//book y --;
public class RentalDao {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public int rentBook(String rentalId, String memberId) {
        int result = 0;
        String sql = "INSERT INTO RENTAL (RENTAL_NAME,MEM_ID, RENTAL_DATE,RENTAL_ID) VALUES (?, ?, ?, ?)";
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "RENTAL_NAME");
            ps.setString(2, "MEM_ID");
            ps.setString(3, "RENTAL_DATE");
            ps.setString(4, "RENTAL_ID");
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	if(rs != null) try { rs.close(); } catch(Exception e) {}
    		if(ps != null) try { ps.close(); } catch(Exception e) {}
    		if(con != null) try { con.close(); } catch(Exception e) {}
        }
        return result;
    }

    public int returnBook(int bookId, int memberId) {
        int result = 0;
        String sql = "DELETE FROM RENTAL WHERE BOOK_ID = ? AND MEM_ID = ?";
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, bookId);
            ps.setInt(2, memberId);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	if(rs != null) try { rs.close(); } catch(Exception e) {}
    		if(ps != null) try { ps.close(); } catch(Exception e) {}
    		if(con != null) try { con.close(); } catch(Exception e) {}
        }
        return result;
    }
}
