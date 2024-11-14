package toy_store_project.dto;

public class Customer {
	private int id,wallet;
	private String email,pwd;
	public Customer(int wallet, String email, String pwd) {
		super();
		this.wallet = wallet;
		this.email = email;
		this.pwd = pwd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWallet() {
		return wallet;
	}
	public void setWallet(int wallet) {
		this.wallet = wallet;
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
		return "Customer [id=" + id + ", wallet=" + wallet + ", email=" + email + ", pwd=" + pwd + "]";
	}
	

}
