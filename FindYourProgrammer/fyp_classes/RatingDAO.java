package fyp_classes;

import java.sql.*;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class RatingDAO {

	public RatingDAO() {

	}

	public void saveRating(Rating rating,int meetid) throws Exception {

		Connection con = null;

		String sqlquery = "INSERT INTO rating (rating, ratinginfo, ratingdate, meetid) VALUES (?, ?, ?, ?);";

		DB db = new DB();

		PreparedStatement stmt = null;

		try {

			db.open();

			con = db.getConnection();

			stmt = con.prepareStatement(sqlquery);


			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();

			String ratingnum = rating.getRating();
			String ratinginfo = rating.getRatinginfo();
			String ratingdate = dateFormat.format(date);



			stmt.setString(1, ratingnum);
			stmt.setString(2, ratinginfo);
			stmt.setString(3, ratingdate);
			stmt.setInt(4, meetid);

			stmt.executeUpdate();
			stmt.close();
			db.close();

		} catch (SQLException e) {

			throw new Exception(e.getMessage());

		} finally {

			try {

				db.close();

			}catch(Exception e) {

			}

		}

	}

	public double getAverageRatingByProgID(int id) throws Exception {

		Connection con = null;

		String sqlquery = "SELECT ROUND(AVG(rating),2) FROM rating,meet,programmer WHERE rating.meetid = meet.meetid AND meet.progrid = ?;";

		DB db = new DB();

		PreparedStatement stmt = null;

		double avg=0;

		try {

			db.open();

			con = db.getConnection();

			stmt = con.prepareStatement(sqlquery);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();


			if(rs.next()) {

				avg = rs.getDouble(1);

			}

			rs.close();
			stmt.close();
			db.close();

			return avg;

		}  catch (Exception e) {

			throw new Exception(e.getMessage());

		} finally {

			try {
				db.close();
			} catch (Exception e) {

			}

		}

	}

	public List<Rating> getProgrRatings(int id) throws Exception {

		Connection con = null;

		String sqlquery = "SELECT ratid, rating, ratinginfo, ratingdate, rating.meetid FROM rating, meet WHERE rating.meetid = meet.meetid AND meet.progrid = ?;";

		DB db = new DB();

		PreparedStatement stmt = null;

		List<Rating> ratings = new ArrayList<Rating>();

		try {
			db.open();

			con = db.getConnection();

			stmt = con.prepareStatement(sqlquery);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();


			while(rs.next()) {

				int meetid = rs.getInt("meetid");
				MeetDAO meetdao = new MeetDAO();
				Meet meet = meetdao.getMeetByID(meetid);

				ratings.add(new Rating(rs.getString("rating"), rs.getString("ratinginfo"), rs.getString("ratingdate"), meet));
			}

			rs.close();
			stmt.close();
			db.close();

			return ratings;

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		} finally {

			try {
				db.close();
			} catch (Exception e) {

			}
		}
	}

	public String hasRating(int meetid) throws Exception {

		String rat;

		Connection con = null;

		String sqlquery = "SELECT rating FROM rating WHERE rating.meetid = ?;";

		DB db = new DB();

		PreparedStatement stmt = null;

		try {
			db.open();

			con = db.getConnection();

			stmt = con.prepareStatement(sqlquery);
			stmt.setInt(1, meetid);

			ResultSet rs = stmt.executeQuery();


			if(rs.next()) {
				rat = rs.getString("rating");; }
			else {
				rat = null;}

			rs.close();
			stmt.close();
			db.close();

			return rat;

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		} finally {

			try {
				db.close();
			} catch (Exception e) {

			}
		}
	}





}
