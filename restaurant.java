package again;

public class restaurant {

	private int id;
	private String name;
	private int averagePrice;
	private String phoneNumber;
	private String openingHour;
	private String type;
	private String username;
	public restaurant(int id, String name, int averagePrice, String phoneNumber, String openingHour, String type) {
		this.id = id;
		this.name = name;
		this.averagePrice = averagePrice;
		this.phoneNumber = phoneNumber;
		this.openingHour = openingHour;
		this.type = type;
	}
	public restaurant(String name, int averagePrice, String phoneNumber, String openingHour, String type) {
		this.name = name;
		this.averagePrice = averagePrice;
		this.phoneNumber = phoneNumber;
		this.openingHour = openingHour;
		this.type = type;
	}
	
	public restaurant(int id, String name, int averagePrice, String phoneNumber, String openingHour, String type,
			String username) {
		super();
		this.id = id;
		this.name = name;
		this.averagePrice = averagePrice;
		this.phoneNumber = phoneNumber;
		this.openingHour = openingHour;
		this.type = type;
		this.username = username;
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
	public int getAveragePrice() {
		return averagePrice;
	}
	public void setAveragePrice(int averagePrice) {
		this.averagePrice = averagePrice;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getOpeningHour() {
		return openingHour;
	}
	public void setOpeningHour(String openingHour) {
		this.openingHour = openingHour;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "restaurant [id=" + id + ", name=" + name + ", averagePrice=" + averagePrice + ", phoneNumber="
				+ phoneNumber + ", openingHour=" + openingHour + ", type=" + type + ", username=" + username + "]";
	}
	
	
}
