package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import vo.MemberVo;

public class MemberDao {
   
   private Connection con = null;
   private PreparedStatement ps = null;
   private ResultSet rs = null;
   
   
   private void disConnect() {
      if(rs != null) try { rs.close(); } catch(Exception e) {}
      if(ps != null) try { ps.close(); } catch(Exception e) {}
      if(con != null) try { con.close(); } catch(Exception e) {}
   }

   public List<MemberVo> getMemberList(){
      List<MemberVo> memberList = null;
      
      String sql = "SELECT * FROM MEMBER";
      
      try {
         con = DBUtil.getConnection();
         ps = con.prepareStatement(sql);
         rs = ps.executeQuery();
         memberList = new ArrayList<MemberVo>();
         while(rs.next()) {
            MemberVo mvo = new MemberVo();
            mvo.setMem_name(rs.getString("MEM_NAME"));
            mvo.setMem_id(rs.getString("MEM_ID"));
            mvo.setMem_num(rs.getString("MEM_NUM"));
            mvo.setMem_pass(rs.getString("MEM_PASS"));
            mvo.setRole(rs.getString("ROLE"));
            memberList.add(mvo);
         }   
      
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         disConnect();
      }   
      return memberList;
   }
}