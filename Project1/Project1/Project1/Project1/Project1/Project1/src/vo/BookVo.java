package vo;

public class BookVo {
   
   private String book_id;
   private String book_name;
   private String book_pub;
   @Override
   
   public String toString() {
      return "BookVo [book_id=" + book_id + ", book_name=" + book_name + ", book_pub=" + book_pub + ", getClass()="
            + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
   }
   public String getBook_id() {
      return book_id;
   }
   public void setBook_id(String book_id) {
      this.book_id = book_id;
   }
   public String getBook_name() {
      return book_name;
   }
   public void setBook_name(String book_name) {
      this.book_name = book_name;
   }
   public String getBook_pub() {
      return book_pub;
   }
   public void setBook_pub(String book_pub) {
      this.book_pub = book_pub;
   }
   
   
}


