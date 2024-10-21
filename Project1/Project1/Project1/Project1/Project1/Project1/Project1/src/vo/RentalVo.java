package vo;

public class RentalVo {
	private String rental_date;
	private String book_id;
	private String rental_id;
	private String mem_id;

	@Override
	public String toString() {
		return "RentalVo [rental_date=" + rental_date + ", book_id=" + book_id + ", rental_id=" + rental_id
				+ ", mem_id=" + mem_id + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public String getRental_date() {
		return rental_date;
	}

	public void setRental_date(String rental_date) {
		this.rental_date = rental_date;
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

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

}
