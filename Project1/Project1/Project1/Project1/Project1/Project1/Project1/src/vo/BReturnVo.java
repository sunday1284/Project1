package vo;

public class BReturnVo {
   
   private String breturn_id;
   private String btrturn_date;
   private String mem_id;
   private String book_id;
   @Override
   public String toString() {
      return "BReturnVo [breturn_id=" + breturn_id + ", btrturn_date=" + btrturn_date + ", mem_id=" + mem_id
            + ", book_id=" + book_id + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
            + super.toString() + "]";
   }
   public String getBreturn_id() {
      return breturn_id;
   }
   public void setBreturn_id(String breturn_id) {
      this.breturn_id = breturn_id;
   }
   public String getBtrturn_date() {
      return btrturn_date;
   }
   public void setBtrturn_date(String btrturn_date) {
      this.btrturn_date = btrturn_date;
   }
   public String getMem_id() {
      return mem_id;
   }
   public void setMem_id(String mem_id) {
      this.mem_id = mem_id;
   }
   public String getBook_id() {
      return book_id;
   }
   public void setBook_id(String book_id) {
      this.book_id = book_id;
   }
   
   
}