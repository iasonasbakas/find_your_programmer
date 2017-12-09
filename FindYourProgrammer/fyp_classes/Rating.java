package fyp_classes;


public class Rating {

	private int id;
	private int rating;
	private Meet meet;
	private String ratinginfo;
	private String ratingdate;

	public Rating(int id, int rating, String ratinginfo, String ratingdate, Meet meet) {

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

	public String getRatingdate() {
		return ratingdate;
	}

	public void setRatingdate(String date) {
		this.ratingdate = ratingdate;
	}
}
