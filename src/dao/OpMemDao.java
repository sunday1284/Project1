package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import vo.OpMemVo;

public class OpMemDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

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
	}

	public List<OpMemVo> getOpMemList() {
		List<OpMemVo> opmemList = null;

		String sql = "SELECT * FROM OPMEM";

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			opmemList = new ArrayList<OpMemVo>();
			while (rs.next()) {
				OpMemVo ovo = new OpMemVo();
				ovo.setOpmem_id(rs.getString("OPMEM_ID"));
				ovo.setOpmem_pass(rs.getString("OPMEM_PASS"));
				ovo.setOpmem_num(rs.getString("OPMEM_NUM"));
				ovo.setOpmem_name(rs.getString("OPMEM_NAME"));
				opmemList.add(ovo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return opmemList;
	}

		public OpMemVo isAdmin(OpMemVo opMemVo) {
	        OpMemVo result = null;
	        String sql = "SELECT * FROM OPMEM WHERE OPMEM_ID = ? AND OPMEM_PASS = ? AND ROLE = 'ADMIN'";

	        try (Connection con = DBUtil.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {
	            ps.setString(1, opMemVo.getOpmem_id());
	            ps.setString(2, opMemVo.getOpmem_pass());
	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    result = new OpMemVo();
	                    result.setOpmem_id(rs.getString("OPMEM_ID"));
	                    result.setOpmem_pass(rs.getString("OPMEM_PASS"));
	                    result.setRole(rs.getString("ROLE"));
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
}
