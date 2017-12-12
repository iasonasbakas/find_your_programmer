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
		return password;
	}

	public void setName(String password) {
		this.password = password;
	}

	public String getSurname() {
		return password;
	}

	public void setSurname(String password) {
		this.password = password;
	}

	public String getPhone() {
		return password;
	}

	public void setPhone(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
