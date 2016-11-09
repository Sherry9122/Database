package again;

public class customerAddress {

	private int cid;
	private int rid;
	private String name;
	private String email;
	private String phoneNumber;
	private String account;
	private String state;
	private String city;
	private String zipcode;
	private String street;
	private String number;
	public customerAddress(int cid, int rid, String name, String email, String phoneNumber, String account,
			String state, String city, String zipcode, String street, String number) {
		super();
		this.cid = cid;
		this.rid = rid;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.account = account;
		this.state = state;
		this.city = city;
		this.zipcode = zipcode;
		this.street = street;
		this.number = number;
	}
	public customerAddress(String name, String email, String phoneNumber, String account, String state, String city,
			String zipcode, String street, String number) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.account = account;
		this.state = state;
		this.city = city;
		this.zipcode = zipcode;
		this.street = street;
		this.number = number;
	}
	public customerAddress(int cid, String name, String email, String phoneNumber, String account, String state,
			String city, String zipcode, String street, String number) {
		super();
		this.cid = cid;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.account = account;
		this.state = state;
		this.city = city;
		this.zipcode = zipcode;
		this.street = street;
		this.number = number;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
	@Override
	public String toString() {
		return "customerAddress [cid=" + cid + ", rid=" + rid + ", name=" + name + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", account=" + account + ", state=" + state + ", city=" + city + ", zipcode=" + zipcode
				+ ", street=" + street + ", number=" + number + "]";
	}
	
	
}
