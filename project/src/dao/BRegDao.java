package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;
import vo.MemberVo;
import vo.BRegVo;

//
public class BRegDao {
   private Connection con = null;
   private PreparedStatement ps = null;
   private ResultSet rs = null;
   
   //싱글톤 패턴 ---------------------------------------------------
   private static BRegDao dao;
   public BRegDao(){}
   public static BRegDao getInstance(){
      if(dao == null){
         dao = new BRegDao();
      }
      return dao;
   }
   // ---------------------------------------------------------------
   
   private void disConnect() {
      if(rs != null) try { rs.close(); } catch(Exception e) {}
      if(ps != null) try { ps.close(); } catch(Exception e) {}
      if(con != null) try { con.close(); } catch(Exception e) {}
   }
   
   // 입력 받은 값을 회원가입 테이블에 인서트 시키는 메서드
   public int insertBREG(BRegVo bregVo){
      int cnt = 0;
      
      String sql = "INSERT INTO BREGISTER (BREG_ID, BREG_PASS, BREG_NAME, BREG_NUM,ROLE) VALUES (?, ?, ?, ?, ?)";
      
      try {
         con = DBUtil.getConnection();
         ps = con.prepareStatement(sql);
         ps.setString(1, bregVo.getBreg_id());
         ps.setString(2, bregVo.getBreg_pass());
         ps.setString(3, bregVo.getBreg_name());
         ps.setString(4, bregVo.getBreg_num());
         ps.setString(5, bregVo.getRole());
         cnt = ps.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         disConnect();
      }
      return cnt;
   }
   
   
   
   // 보여주는 메서드
   public BRegVo getBReg(BRegVo bregVo) {
      BRegVo getBRegVo = null;
      
      String sql = "SELECT BREG_ID, BREG_PASS, BREG_NAME, ROLE FROM BREGISTER "
            + " WHERE BREG_ID = ? AND BREG_PASS = ?";
      try {
         con = DBUtil.getConnection();
         ps = con.prepareStatement(sql);
         ps.setString(1, bregVo.getBreg_id());
         ps.setString(2, bregVo.getBreg_pass());
         rs = ps.executeQuery();
         if(rs.next()) {
            getBRegVo = new BRegVo();
            getBRegVo.setBreg_id(rs.getString("BREG_ID"));
            getBRegVo.setBreg_pass(rs.getString("BREG_PASS"));
            getBRegVo.setBreg_name(rs.getString("BREG_NAME"));
            getBRegVo.setRole(rs.getString("ROLE"));
            
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         disConnect();
      }
      
      
      return getBRegVo;
   }
//========================================================================================
   public int insertBREG1(MemberVo bregVo1){
      int cnt1 = 0;
      
      String sql = "INSERT INTO MEMBER (MEM_ID, MEM_PASS, MEM_NAME, MEM_NUM,ROLE) VALUES (?, ?, ?, ?, ?)";
      
      try {
         con = DBUtil.getConnection();
         ps = con.prepareStatement(sql);
         ps.setString(1, bregVo1.getMem_id());
         ps.setString(2, bregVo1.getMem_pass());
         ps.setString(3, bregVo1.getMem_name());
         ps.setString(4, bregVo1.getMem_num());
         ps.setString(5, bregVo1.getRole());
         cnt1 = ps.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         disConnect();
      }
      
      return cnt1;
   }
   
}








