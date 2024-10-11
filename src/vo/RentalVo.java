package vo;

public class RentalVo {
	private String rental_date;
	private String rental_name;
	private String rental_id;
	
	
	public String getRental_date() {
		return rental_date;
	}


	public void setRental_date(String rental_date) {
		this.rental_date = rental_date;
	}


	public String getRental_name() {
		return rental_name;
	}


	public void setRental_name(String rental_name) {
		this.rental_name = rental_name;
	}


	public String getRental_id() {
		return rental_id;
	}


	public void setRental_id(String rental_id) {
		this.rental_id = rental_id;
	}


	@Override
	public String toString() {
		return "RentalVo [rental_date=" + rental_date + ", rental_name=" + rental_name + ", rental_id=" + rental_id
				+ "]";
	}
	
	
}
