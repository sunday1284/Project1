package vo;

public class RegVo {
   private String reg_id;
   private String reg_pass;
   private String reg_name;
   @Override
   public String toString() {
      return "RegVo [reg_id=" + reg_id + ", reg_pass=" + reg_pass + ", reg_name=" + reg_name + ", getClass()="
            + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
   }
   public String getReg_id() {
      return reg_id;
   }
   public void setReg_id(String reg_id) {
      this.reg_id = reg_id;
   }
   public String getReg_pass() {
      return reg_pass;
   }
   public void setReg_pass(String reg_pass) {
      this.reg_pass = reg_pass;
   }
   public String getReg_name() {
      return reg_name;
   }
   public void setReg_name(String reg_name) {
      this.reg_name = reg_name;
   }
   
   
}
