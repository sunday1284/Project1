package vo;

public class LoanVo {
	private String loan_date;
	private String loan_name;
	private String loan_id;
	
	public String getLoan_date() {
		return loan_date;
	}

	public void setLoan_date(String loan_date) {
		this.loan_date = loan_date;
	}

	public String getLoan_name() {
		return loan_name;
	}

	public void setLoan_name(String loan_name) {
		this.loan_name = loan_name;
	}

	public String getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(String loan_id) {
		this.loan_id = loan_id;
	}

	@Override
	public String toString() {
		return "LoanVo [loan_date=" + loan_date + ", loan_name=" + loan_name + ", loan_id=" + loan_id + "]";
	}
}
