package fyp_classes;

public class Customer {

	private int custid;
	private String username;
	private String password;
	private String name;
	private String surname;
	private String phone;
	private String email;


	public Customer(int custid, String username, String password, String name, String surname, String phone, String email) {
		this.custid = custid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
	}

		/*Getters and Setters*/

	public int getCustomerID() {
		return custid;
	}

	public void setCustomerID(int custid) {
		this.custid = custid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
