package fyp_classes;

public class Programmer {

	private int progrid;
	private String name;
	private String surname;
	private String phone;
	private String email;
	private String extrainfo;
	private ProgrLang progrlang;

	public Programmer(int progrid, String name, String surname, String phone, String email, String extrainfo, ProgrLang progrlang) {

		this.progrid = progrid;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
		this.extrainfo = extrainfo;
		this.progrlang = progrlang;
	}

	public int getProgrammerId() {
		return progrid;
	}

	public void setProgrammerId(String id) {
		this.progrid = progrid;
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

	public String getExtrainfo() {
		return extrainfo;
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
