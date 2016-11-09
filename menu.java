package again;

public class menu {

	private int id;
	private String name;
	private int price;
	private String course;
	private String description;
	private int menu;
	private String username;
	private int userId;
	private int quantity;
	private String picture;
	
	public menu(int id, String name, int price, String course, String description, int menu, int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.course = course;
		this.description = description;
		this.menu = menu;
		this.quantity = quantity;
	}
	
	

	
	public menu(String picture) {
		super();
		this.picture = picture;
	}



	
	public menu(int id, String name, int price, String course, String description, int menu, String username,
			int userId, String picture) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.course = course;
		this.description = description;
		this.menu = menu;
		this.username = username;
		this.userId = userId;
		this.picture = picture;
	}




	public menu(int id, String name, int price, String course, String description, int menu, String username,
			String picture) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.course = course;
		this.description = description;
		this.menu = menu;
		this.username = username;
		this.picture = picture;
	}




	public menu(int id, String name, int price, String course, String description, int menu, String username,
			int userId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.course = course;
		this.description = description;
		this.menu = menu;
		this.username = username;
		this.userId = userId;
	}

	public menu(int id, String name, int price, String course, String description, String username) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.course = course;
		this.description = description;
		this.username = username;
	}

	
	public menu(int id, String name, int price, String course, String description, int menu) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.course = course;
		this.description = description;
		this.menu = menu;
	}
	
	public menu(int id, String name, int price, String course, String description, int menu, String username) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.course = course;
		this.description = description;
		this.menu = menu;
		this.username = username;
	}

	public menu(String name, int price, String course, String description, int menu) {
		super();
		this.name = name;
		this.price = price;
		this.course = course;
		this.description = description;
		this.menu = menu;
	}
	
	public menu(int id, String name, int price, String course, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.course = course;
		this.description = description;
	}
	public menu(String name, int price, String course, String description) {
		super();
		this.name = name;
		this.price = price;
		this.course = course;
		this.description = description;
	}
	
	
	public String getPicture() {
		return picture;
	}



	public void setPicture(String picture) {
		this.picture = picture;
	}



	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public int getMenu() {
		return menu;
	}
	public void setMenu(int menu) {
		this.menu = menu;
	}



	@Override
	public String toString() {
		return "menu [id=" + id + ", name=" + name + ", price=" + price + ", course=" + course + ", description="
				+ description + ", menu=" + menu + ", username=" + username + ", userId=" + userId + ", quantity="
				+ quantity + ", picture=" + picture + "]";
	}

	

	
}
