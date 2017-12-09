package fyp_classes;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ProgrLangDAO {

	public ProgrLangDAO() {

	}

	public List<ProgrLang> getProgrLangs() throws Exception {

		Connection con = null;

		String sqlquery = "SELECT * FROM progrlang;";

		DB db = new DB();

		List<ProgrLang> progrlangs = new ArrayList<ProgrLang>();

		try {

			db.open();

			con = db.getConnection();

			PreparedStatement stmt = con.prepareStatement(sqlquery);

			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				progrlangs.add(new ProgrLang(rs.getInt("id"), rs.getString("name")));
			}

			rs.close();
			stmt.close();
			db.close();

			return progrlangs;

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		} finally {

			try {
				db.close();
			} catch (Exception e) {

			}
		}
	} //End of getProgrLangs


	public ProgrLang getProgrLangByID(int id) throws Exception {

		Connection con = null;

		String sqlquery = "SELECT * FROM progrlang WHERE id = ?;";

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

				throw new Exception("Could not find ProgrLang with id: "+id);
			}

			ProgrLang progrlang = new ProgrLang(rs.getInt("id"), rs.getString("name"));

			rs.close();
			stmt.close();
			db.close();

			return progrlang;

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		} finally {

			try {
				db.close();
			} catch(Exception e) {}
		}

	} //End of getProgrLangByID

}
