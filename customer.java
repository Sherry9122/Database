package again;

public class customer {

	private int id;
	private String name;
	private String email;
	private String phoneNumber;
	private String account;
	private String password;
	public customer(int id, String name, String email, String phoneNumber, String account, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.account = account;
		this.password = password;
	}
	public customer(String name, String email, String phoneNumber, String password) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}
	
	public customer(String name, String email, String phoneNumber, String account, String password) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.account = account;
		this.password = password;
	}
	public customer(int id, String name, String email, String phoneNumber, String account) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.account = account;
	}
	
	
	public customer(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public customer(String password) {
		this.password = password;
	}
	public customer(String account, String password) {
		this.account = account;
		this.password = password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "customer [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", account=" + account + ", password=" + password + "]";
	}
	
}
