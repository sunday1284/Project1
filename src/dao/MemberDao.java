package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	private void disConnect() {
		if(rs != null) try { rs.close(); } catch(SQLException e) {}
		if(ps != null) try { ps.close(); } catch(SQLException e) {}
		if(con != null) try { con.close(); } catch(SQLException e) {}
	}
}
