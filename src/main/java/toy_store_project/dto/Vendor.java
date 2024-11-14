package toy_store_project.dto;

public class Vendor {
	private int id;
	private String email,pwd;
	public Vendor( String email, String pwd) {
		super();
		this.email = email;
		this.pwd = pwd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Vendor [id=" + id + ", email=" + email + ", pwd=" + pwd + "]";
	}
	
	

}
