package toy_store_project.dto;

public class Shop {
	private int id;
	private String name,address,vendorEmail;
	public Shop(String name, String address, String vendorEmail) {
		this.name = name;
		this.address = address;
		this.vendorEmail = vendorEmail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVendorEmail() {
		return vendorEmail;
	}
	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}
	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + ", address=" + address + ", vendorEmail=" + vendorEmail + "]";
	}
	
	
	
	
	

}
