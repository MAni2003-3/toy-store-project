package toy_store_project.dto;

public class Toy {
	private int id,cost,quantity;
	private String brand,type,color;
	public Toy(int cost, int quantity, String brand, String type, String color) {
		super();
		this.cost = cost;
		this.quantity = quantity;
		this.brand = brand;
		this.type = type;
		this.color = color;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Toy [id=" + id + ", cost=" + cost + ", quantity=" + quantity + ", brand=" + brand + ", type=" + type
				+ ", color=" + color + "]";
	}
	

	

}
