package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;
import vo.RegVo;


public class RegDao {
   private Connection con = null;
   private PreparedStatement ps = null;
   private ResultSet rs = null;
   
   //싱글톤 패턴 ---------------------------------------------------
   private static RegDao dao;
   private RegDao(){}
   public static RegDao getInstance(){
      if(dao == null){
         dao = new RegDao();
      }
      return dao;
   }
   // ---------------------------------------------------------------
   
   private void disConnect() {
      if(rs != null) try { rs.close(); } catch(Exception e) {}
      if(ps != null) try { ps.close(); } catch(Exception e) {}
      if(con != null) try { con.close(); } catch(Exception e) {}
   }
   
   public int insertREG(RegVo regVo){
      int cnt = 0;
      
      String sql = "INSERT INTO REGISTER (REG_ID, REG_PASS, REG_NAME) VALUES (?, ?, ?)";
      
      try {
         con = DBUtil.getConnection();
         ps = con.prepareStatement(sql);
         ps.setString(1, regVo.getReg_id());
         ps.setString(2, regVo.getReg_pass());
         ps.setString(3, regVo.getReg_name());
         
         cnt = ps.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         disConnect();
      }
      
      return cnt;
   }
   
   public RegVo getReg(RegVo regVo) {
      RegVo getRegVo = null;
      
      String sql = "SELECT REG_ID, REG_PASS, REG_NAME FROM REGISTER "
            + " WHERE REG_ID = ? AND REG_PASS = ?";
      try {
         con = DBUtil.getConnection();
         ps = con.prepareStatement(sql);
         ps.setString(1, regVo.getReg_id());
         ps.setString(2, regVo.getReg_pass());
         rs = ps.executeQuery();
         if(rs.next()) {
            getRegVo = new RegVo();
            getRegVo.setReg_id(rs.getString("REG_ID"));
            getRegVo.setReg_pass(rs.getString("REG_PASS"));
            getRegVo.setReg_name(rs.getString("REG_NAME"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         disConnect();
      }
      
      
      return getRegVo;
   }
   
}








