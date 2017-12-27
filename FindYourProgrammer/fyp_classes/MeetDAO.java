package fyp_classes;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class MeetDAO {

	public MeetDAO() {

	}

	public List<Meet> getMeetsByCustomer(String username) throws Exception {

		Connection con = null;

		String sqlquery = "SELECT * FROM meet WHERE username = ?;";

		PreparedStatement stmt = null;

		DB db = new DB();


		try {

			db.open();

			con = db.getConnection();

			stmt = con.prepareStatement(sqlquery);

			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();

			List<Meet> meets = new ArrayList<Meet>();

			while(rs.next()) {

				CustomerDAO customerdao = new CustomerDAO();
				Customer customer = customerdao.findCustomer(username);

				int programmerid = rs.getInt("progrid");
				ProgrammerDAO programmerdao = new ProgrammerDAO();
				Programmer programmer = programmerdao.getProgrammerByID(programmerid);

				meets.add(new Meet(rs.getString("date"),rs.getString("time"), rs.getString("place"), rs.getString("extrainfo"), rs.getString("social"), customer, programmer));

			}

			rs.close();
			stmt.close();
			db.close();

			return meets;

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		} finally {

			try {

				db.close();

			} catch (Exception e) {

			}
		}
	}



	public List<Integer> getMeetIDsByCustomer(String username) throws Exception {

		Connection con = null;

		String sqlquery = "SELECT meetid FROM meet WHERE username = ?;";

		PreparedStatement stmt = null;

		DB db = new DB();

		List<Integer> ids = new ArrayList<Integer>();


		try {

			db.open();

			con = db.getConnection();

			stmt = con.prepareStatement(sqlquery);

			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();


			while(rs.next()) {

				ids.add(rs.getInt("meetid"));

			}

			rs.close();
			stmt.close();
			db.close();

			return ids;

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		} finally {

			try {

				db.close();

			} catch (Exception e) {

			}
		}
	}




	public Meet getMeetByID(int meetid) throws Exception {

		Connection con = null;

		String sqlquery = "SELECT * FROM meet WHERE meetid = ?;";

		DB db = new DB();

		try {

			db.open();

			con = db.getConnection();

			PreparedStatement stmt = con.prepareStatement(sqlquery);

			stmt.setInt(1, meetid);

			ResultSet rs = stmt.executeQuery();

			if(!rs.next()) {

				rs.close();
				stmt.close();
				db.close();

				throw new Exception("Could not find Meet with id: "+meetid);
			}

			String username = rs.getString("username");
			CustomerDAO customerdao = new CustomerDAO();
			Customer customer = customerdao.findCustomer(username);

			int programmerid = rs.getInt("progrid");
			ProgrammerDAO programmerdao = new ProgrammerDAO();
			Programmer programmer = programmerdao.getProgrammerByID(programmerid);

			Meet meet = new Meet(rs.getString("date"), rs.getString("place"), rs.getString("extrainfo"), rs.getString("email"), rs.getString("social"), customer, programmer);

			rs.close();
			stmt.close();
			db.close();

			return meet;

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		} finally {

			try {

				db.close();

			} catch(Exception e) {}
		}

	}

	public void saveMeet(Meet meet) throws Exception {

		Connection con = null;

		String sqlquery = "INSERT INTO meet (date, time, place, extrainfo, progrid, username, social) VALUES (?, ?, ?, ?, ?, ?, ?);";

		DB db = new DB();

		PreparedStatement stmt = null;

		try {

			db.open();

			con = db.getConnection();

			stmt = con.prepareStatement(sqlquery);

			String date = meet.getDate();
			String time = meet.getTime();
			String place = meet.getPlace();
			String extrainfo = meet.getExtrainfo();
			String social = meet.getSocial();

			Customer customer = meet.getCustomer();
			String username = customer.getUsername();

			Programmer progr = meet.getProgrammer();
			int progrid = progr.getProgrammerId();



			stmt.setString(1, date);
			stmt.setString(2, time);
			stmt.setString(3, place);
			stmt.setString(4, extrainfo);
			stmt.setInt(5, progrid);
			stmt.setString(6, username);
			stmt.setString(7, social);

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

}
