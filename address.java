package again;

public class address {

	private int id;
	private String state;
	private String city;
	private String zipcode;
	private String street;
	private String number;
	private int addressOfRestaurant;
	private int addressOfCustomer;
	public address(int id, String state, String city, String zipcode, String street, String number,
			int addressOfRestaurant, int addressOfCustomer) {
		this.id = id;
		this.state = state;
		this.city = city;
		this.zipcode = zipcode;
		this.street = street;
		this.number = number;
		this.addressOfRestaurant = addressOfRestaurant;
		this.addressOfCustomer = addressOfCustomer;
	}
	public address(String state, String city, String zipcode, String street, String number, int addressOfRestaurant,
			int addressOfCustomer) {
		this.state = state;
		this.city = city;
		this.zipcode = zipcode;
		this.street = street;
		this.number = number;
		this.addressOfRestaurant = addressOfRestaurant;
		this.addressOfCustomer = addressOfCustomer;
	}
	
	public address(String state, String city, String zipcode, String street, String number) {
		this.state = state;
		this.city = city;
		this.zipcode = zipcode;
		this.street = street;
		this.number = number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getAddressOfRestaurant() {
		return addressOfRestaurant;
	}
	public void setAddressOfRestaurant(int addressOfRestaurant) {
		this.addressOfRestaurant = addressOfRestaurant;
	}
	public int getAddressOfCustomer() {
		return addressOfCustomer;
	}
	public void setAddressOfCustomer(int addressOfCustomer) {
		this.addressOfCustomer = addressOfCustomer;
	}
	@Override
	public String toString() {
		return "address [id=" + id + ", state=" + state + ", city=" + city + ", zipcode=" + zipcode + ", street="
				+ street + ", number=" + number + ", addressOfRestaurant=" + addressOfRestaurant
				+ ", addressOfCustomer=" + addressOfCustomer + "]";
	}
	
	
}
