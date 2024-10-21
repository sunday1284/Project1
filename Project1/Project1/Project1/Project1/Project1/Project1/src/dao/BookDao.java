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
	
	public List<BookVo> getbookList(){
		List<BookVo> bookList = null;
		
		String sql =" SELECT *FROM BOOK";
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
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return bookList;
	}
	private void disConnect() {
		if(rs != null) try { rs.close(); } catch(Exception e) {}
		if(ps != null) try { ps.close(); } catch(Exception e) {}
		if(con != null) try { con.close(); } catch(Exception e) {}
	}
}
