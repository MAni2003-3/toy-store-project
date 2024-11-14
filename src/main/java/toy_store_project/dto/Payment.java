package toy_store_project.dto;

public class Payment {
	private int id,bill,cu_id;

	public Payment(int id, int bill, int cu_id) {
		super();
		this.id = id;
		this.bill = bill;
		this.cu_id = cu_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBill() {
		return bill;
	}

	public void setBill(int bill) {
		this.bill = bill;
	}

	public int getCu_id() {
		return cu_id;
	}

	public void setCu_id(int cu_id) {
		this.cu_id = cu_id;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", bill=" + bill + ", cu_id=" + cu_id + "]";
	}
	

}
