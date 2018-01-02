package fyp_classes;


public class Rating {


	private String rating;
	private String ratinginfo;
	private String ratingdate;
	private Meet meet;

	public Rating(String rating, String ratinginfo, String ratingdate, Meet meet) {

		this.rating = rating;
		this.meet = meet;
		this.ratinginfo = ratinginfo;
		this.ratingdate = ratingdate;
	}


	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
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
