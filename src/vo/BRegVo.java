package vo;
//
public class BRegVo {
	private String breg_id;
	private String breg_pass;
	private String breg_name;
	private String breg_num;
	private String role; // ROLE 필드 추가

	// Getters and setters for all fields including ROLE
	public String getBreg_id() {
		return breg_id;
	}

	public void setBreg_id(String breg_id) {
		this.breg_id = breg_id;
	}

	public String getBreg_pass() {
		return breg_pass;
	}

	public void setBreg_pass(String breg_pass) {
		this.breg_pass = breg_pass;
	}

	public String getBreg_name() {
		return breg_name;
	}

	public void setBreg_name(String breg_name) {
		this.breg_name = breg_name;
	}

	public String getBreg_num() {
		return breg_num;
	}

	public void setBreg_num(String breg_num) {
		this.breg_num = breg_num;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
