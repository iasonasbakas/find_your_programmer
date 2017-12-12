package fyp_classes;


public class Rating {

	private int ratid;
	private int rating;
	private String ratinginfo;
	private String ratingdate;
	private Meet meet;

	public Rating(int ratid, int rating, String ratinginfo, String ratingdate, Meet meet) {

		this.ratid = ratid;
		this.rating = rating;
		this.meet = meet;
		this.ratinginfo = ratinginfo;
		this.ratingdate = ratingdate;
	}

	public int getRatingID() {
		return ratid;
	}

	public void setRatingID(int id) {
		this.ratid = ratid;
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

	public String getRatingdate() {
		return ratingdate;
	}

	public void setRatingdate(String date) {
		this.ratingdate = ratingdate;
	}
}
