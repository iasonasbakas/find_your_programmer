package fyp_classes;

public class Programmer {

	private int id;
	private String name;
	private String surname;
	private String phone;
	private String email;
	private String extrainfo;
	private ProgrLang progrlang;

	public Programmer(int id, String name, String surname, String phone, String email, String extrainfo, ProgrLang progrlang) {

		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
		this.extrainfo = extrainfo;
		this.progrlang = progrlang;
	}

	public int getId() {
		return id;
	}

	public void setId(String id) {
		this.name = name;
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
		return name;
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

	public String getExtrainfo() {
		return name;
	}

	public void setExtrainfo(String extrainfo) {
		this.extrainfo = extrainfo;
	}

	public ProgrLang getProgrlang() {
		return progrlang;
	}

	public void setProgrLang(ProgrLang progrlang) {
		this.progrlang = progrlang;
	}
}
