package vo;

public class OpMemVo {
	private String opmem_id;
	private String opmem_pass;
	private String opmem_num;
	private String opmem_name;
	private String role;
	@Override
	public String toString() {
		return "OpMemVo [opmem_id=" + opmem_id + ", opmem_pass=" + opmem_pass + ", opmem_num=" + opmem_num
				+ ", opmem_name=" + opmem_name + ", role=" + role + "]";
	}
	public String getOpmem_id() {
		return opmem_id;
	}
	public void setOpmem_id(String opmem_id) {
		this.opmem_id = opmem_id;
	}
	public String getOpmem_pass() {
		return opmem_pass;
	}
	public void setOpmem_pass(String opmem_pass) {
		this.opmem_pass = opmem_pass;
	}
	public String getOpmem_num() {
		return opmem_num;
	}
	public void setOpmem_num(String opmem_num) {
		this.opmem_num = opmem_num;
	}
	public String getOpmem_name() {
		return opmem_name;
	}
	public void setOpmem_name(String opmem_name) {
		this.opmem_name = opmem_name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
