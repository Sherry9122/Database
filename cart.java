package again;

public class cart {

	private int menu;
	private int customer;
	private int quantity;
	private String deliveryTime;
	private String name;
	private int id;
	private int price;
	private String course;
	private String description;
	private String user;
	private String restaurant;
	private String picture;
	public cart(int menu, int customer, int quantity, String deliveryTime) {
		this.menu = menu;
		this.customer = customer;
		this.quantity = quantity;
		this.deliveryTime = deliveryTime;
	}
	
	
	
	public cart(int quantity, String name, int price, String course, String description, String picture) {
		this.quantity = quantity;
		this.name = name;
		this.price = price;
		this.course = course;
		this.description = description;
		this.picture = picture;
	}



	public cart(int quantity, String name, int price, String course, String description) {
		this.quantity = quantity;
		this.name = name;
		this.price = price;
		this.course = course;
		this.description = description;
	}



	public cart(int menu, int customer, int quantity, String name, int id, int price, String course, String description,
			String user, String restaurant, String picture) {
		super();
		this.menu = menu;
		this.customer = customer;
		this.quantity = quantity;
		this.name = name;
		this.id = id;
		this.price = price;
		this.course = course;
		this.description = description;
		this.user = user;
		this.restaurant = restaurant;
		this.picture = picture;
	}



	public cart(int menu, int customer, int quantity, String name, int id, int price, String course, String description,
			String user, String restaurant) {
		super();
		this.menu = menu;
		this.customer = customer;
		this.quantity = quantity;
		this.name = name;
		this.id = id;
		this.price = price;
		this.course = course;
		this.description = description;
		this.user = user;
		this.restaurant = restaurant;
	}



	public cart(int quantity, String name, int id, int price, String course, String description) {
		super();
		this.quantity = quantity;
		this.name = name;
		this.id = id;
		this.price = price;
		this.course = course;
		this.description = description;
	}
	
	

	public cart(int menu, int customer, int quantity) {
		super();
		this.menu = menu;
		this.customer = customer;
		this.quantity = quantity;
	}
	
	public cart(int quantity, String name) {
		super();
		this.quantity = quantity;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMenu() {
		return menu;
	}
	public void setMenu(int menu) {
		this.menu = menu;
	}
	public int getCustomer() {
		return customer;
	}
	public void setCustomer(int customer) {
		this.customer = customer;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	
	
	public String getPicture() {
		return picture;
	}



	public void setPicture(String picture) {
		this.picture = picture;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}



	@Override
	public String toString() {
		return "cart [menu=" + menu + ", customer=" + customer + ", quantity=" + quantity + ", deliveryTime="
				+ deliveryTime + ", name=" + name + ", id=" + id + ", price=" + price + ", course=" + course
				+ ", description=" + description + ", user=" + user + ", restaurant=" + restaurant + ", picture="
				+ picture + "]";
	}

	

	
	
	
	
	
}
