package vo;

public class BReturnVo {

	private String btreturn_date;
	private String mem_id;
	private String book_id;
	private String rental_id;
	
	public String getBtreturn_date() {
		return btreturn_date;
	}
	public void setBtreturn_date(String btreturn_date) {
		this.btreturn_date = btreturn_date;
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
	public String getRental_id() {
		return rental_id;
	}
	public void setRental_id(String rental_id) {
		this.rental_id = rental_id;
	}
	@Override
	public String toString() {
		return "BReturnVo [btreturn_date=" + btreturn_date + ", mem_id=" + mem_id + ", book_id=" + book_id
				+ ", rental_id=" + rental_id + "]";
	}
	
	
	
}