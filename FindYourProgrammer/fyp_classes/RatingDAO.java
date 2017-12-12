package fyp_classes;

import java.sql.*;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;

public class RatingDAO {

	public RatingDAO() {

	}

	public void saveRating(Rating rating) throws Exception {

		Connection con = null;

		String sqlquery = "INSERT INTO rating (ratid, rating, ratinginfo, ratingdate, meetid) VALUES (?, ?, ?, ?, ?, ?);";

		DB db = new DB();

		PreparedStatement stmt = null;

		try {

			db.open();

			con = db.getConnection();

			stmt = con.prepareStatement(sqlquery);

			int id = rating.getId();
			int ratingnum = rating.getRating();
			String ratinginfo = rating.getRatinginfo();
			String ratingdate = rating.getRatingdate();
			Meet meet = rating.getMeet();
			int meetid = meet.getId();

			stmt.setInt(1, id);
			stmt.setInt(2, ratingnum);
			stmt.setString(3, ratinginfo);
			stmt.setString(4, ratingdate);
			stmt.setInt(5, meetid);

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

		String sqlquery = "SELECT rating FROM rating,meet,programmer WHERE rating.meetid = meet.meetid AND meet.progrid = ?;";

		DB db = new DB();

		PreparedStatement stmt = null;

		double avg = 0;
		int sum = 0;
		int count = 0;

		try {

			db.open();

			con = db.getConnection();

			stmt.setInt(1, id);

			stmt = con.prepareStatement(sqlquery);

			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {

				count += 1;
				sum += rs.getInt("rating");
			}

			avg = Math.round((1.0*sum / count*10.0)/10.0);

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

		String sqlquery = "SELECT id, rating, ratinginfo, ratingdate, meetid FROM rating, meet WHERE rating.meetid = meet.meetid AND meet.progrid = ?;";

		DB db = new DB();

		PreparedStatement stmt = null;

		List<Rating> ratings = new ArrayList<Rating>();

		try {
			db.open();

			con = db.getConnection();

			stmt.setInt(1, id);

			stmt = con.prepareStatement(sqlquery);

			ResultSet rs = stmt.executeQuery();


			while(rs.next()) {

				int meetid = rs.getInt("meetid");
				MeetDAO meetdao

				ratings.add(new Rating(rs.getInt("id"), rs.getInt("rating"), rs.getString("ratinginfo"), rs.getString("ratingdate"), rs.getMeet("meetid")));
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

}
