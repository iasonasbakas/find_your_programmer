package fyp_classes;

import java.util.Date;


public class Meet {

	private String date;
	private String time;
	private String place;
	private String extrainfo;
	private String social;
	private Customer customer;
	private Programmer programmer;

	public Meet(String date, String time, String place, String extrainfo, String social, Customer customer, Programmer programmer) {

		this.customer = customer;
		this.programmer = programmer;
		this.date = date;
		this.time = time;
		this.place = place;
		this.social = social;
		this.extrainfo = extrainfo;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Programmer getProgrammer() {
		return programmer;
	}

	public void setProgrammer(Programmer programmer) {
		this.programmer = programmer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getSocial() {
		return social;
	}

	public void setSocial(String social) {
		this.social = social;
	}

	public String getExtrainfo() {
		return extrainfo;
	}

	public void setExtrainfo(String extrainfo) {
		this.extrainfo = extrainfo;
	}
}
