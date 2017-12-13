package fyp_classes;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class ProgrammerDAO {

	public ProgrammerDAO() {

	}

	public List<Programmer> getProgrammers() throws Exception {

		Connection con = null;

		String sqlquery = "SELECT * FROM programmer;";

		DB db = new DB();

		PreparedStatement stmt = null;

		try {

			db.open();

			con = db.getConnection();

			stmt = con.prepareStatement(sqlquery);

			ResultSet rs = stmt.executeQuery();

			List<Programmer> programmers = new ArrayList<Programmer>();

			while(rs.next()) {

				programmers.add(new Programmer(rs.getInt("progrid"), rs.getString("name"), rs.getString("surname"), rs.getString("phone"), rs.getString("email"), rs.getString("extrainfo")));

			}

			rs.close();
			stmt.close();
			db.close();

			return programmers;

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		} finally {

			try {

				db.close();

			} catch (Exception e) {

			}
		}
	}


	public List<Programmer> getProgrammersByLang(int langid) throws Exception {

		Connection con = null;

		String sqlquery = "SELECT * FROM progrskills WHERE langid = ?;";

		DB db = new DB();

		PreparedStatement stmt = null;

		try {

			db.open();

			con = db.getConnection();

			stmt = con.prepareStatement(sqlquery);

			stmt.setInt(1, langid);

			ResultSet rs = stmt.executeQuery();

			List<Programmer> programmers = new ArrayList<Programmer>();

			while(rs.next()) {

				int prid = rs.getInt("progrid");
				Programmer programmer = getProgrammerByID(prid);

				programmers.add(programmer);

			}

			rs.close();
			stmt.close();
			db.close();

			return programmers;

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		} finally {

			try {

				db.close();

			} catch (Exception e) {

			}
		}
	}


	public Programmer getProgrammerByID(int id) throws Exception {

		Connection con = null;

		String sqlquery = "SELECT * FROM programmer WHERE progrid = ?;";

		DB db = new DB();

		try {

			db.open();

			con = db.getConnection();

			PreparedStatement stmt = con.prepareStatement(sqlquery);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			if(!rs.next()) {

				rs.close();
				stmt.close();
				db.close();

				throw new Exception("Could not find Programmer with id: "+id);
			}

			Programmer programmer = new Programmer(rs.getInt("progrid"), rs.getString("name"), rs.getString("surname"), rs.getString("phone"), rs.getString("email"), rs.getString("extrainfo"));

			rs.close();
			stmt.close();
			db.close();

			return programmer;

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		} finally {

			try {
				db.close();
			} catch(Exception e) {}
		}

	}

}






