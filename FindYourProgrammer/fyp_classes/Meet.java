package fyp_classes;

import java.util.Date;


public class Meet {

	private int meetid;
	private Date date;
	private String time;
	private String place;
	private String extrainfo;
	private Customer customer;
	private Programmer programmer;

	public Meet(int meetid, Date date, String time, String place, String extrainfo, Customer customer, Programmer programmer) {

		this.meetid = meetid;
		this.customer = customer;
		this.programmer = programmer;
		this.date = date;
		this.time = time;
		this.place = place;
		this.extrainfo = extrainfo;
	}

	public int getMeetID() {
		return meetid;
	}

	public void setMeetID(int meetid) {
		this.meetid = meetid;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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

	public String getExtrainfo() {
		return extrainfo;
	}

	public void setExtrainfo(String extrainfo) {
		this.extrainfo = extrainfo;
	}
}
