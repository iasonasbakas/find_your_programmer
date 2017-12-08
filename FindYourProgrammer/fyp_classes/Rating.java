package fyp_classes;

import java.util.Date;

public class Rating {

	private int id;
	private int rating;
	private Meet meet;
	private String ratinginfo;
	private Date ratingdate;

	public Rating(int id, int rating, Meet meet, String ratinginfo, Date ratingdate) {

		this.id = id;
		this.rating = rating;
		this.meet = meet;
		this.ratinginfo = ratinginfo;
		this.ratingdate = ratingdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Meet getMeet() {
		return meet;
	}

	public void setMeet(Meet meet) {
		this.meet = meet;
	}

	public String getRatinginfo() {
		return ratinginfo;
	}

	public void setRatinginfo(String ratinginfo) {
		this.ratinginfo = ratinginfo;
	}

	public Date getDate() {
		return ratingdate;
	}

	public void setDate(Date date) {
		this.ratingdate = ratingdate;
	}
}
