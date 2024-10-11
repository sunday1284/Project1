package vo;

public class MemberVo {
   private String mem_name;
   private String mem_id;
   private String mem_addr;
   private String mem_num;
   
   @Override
   public String toString() {
      return "MemberVo [mem_name=" + mem_name + ", mem_id=" + mem_id + ", mem_addr=" + mem_addr + ", mem_num="
            + mem_num + "]";
   }

   public String getMem_name() {
      return mem_name;
   }

   public void setMem_name(String mem_name) {
      this.mem_name = mem_name;
   }

   public String getMem_id() {
      return mem_id;
   }

   public void setMem_id(String mem_id) {
      this.mem_id = mem_id;
   }

   public String getMem_addr() {
      return mem_addr;
   }

   public void setMem_addr(String mem_addr) {
      this.mem_addr = mem_addr;
   }

   public String getMem_num() {
      return mem_num;
   }

   public void setMem_num(String mem_num) {
      this.mem_num = mem_num;
   }
   
}
