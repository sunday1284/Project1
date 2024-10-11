package vo;

public class ReturnVo {
	private String return_date;
	private String return_name;
	private String return_id;
	@Override
	public String toString() {
		return "ReturnVo [return_date=" + return_date + ", return_name=" + return_name + ", return_id=" + return_id
				+ "]";
	}
	public String getReturn_date() {
		return return_date;
	}
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	public String getReturn_name() {
		return return_name;
	}
	public void setReturn_name(String return_name) {
		this.return_name = return_name;
	}
	public String getReturn_id() {
		return return_id;
	}
	public void setReturn_id(String return_id) {
		this.return_id = return_id;
	}
	
}
