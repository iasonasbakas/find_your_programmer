package fyp_classes;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class MeetDAO {

	public MeetDAO() {

	}

	public List<Meet> getMeetsByCustomerID(int custid) throws Exception {

		Connection con = null;

		String sqlquery = "SELECT * FROM customer WHERE custid = ?;";

		PreparedStatement stmt = null;

		DB db = new DB();


		try {

			db.open();

			con = db.getConnection();

			stmt = con.prepareStatement(sqlquery);

			stmt.setInt(1, custid);

			ResultSet rs = stmt.executeQuery();

			List<Meet> meets = new ArrayList<Meet>();

			while(rs.next()) {

				int customerid = rs.getInt("custid");
				CustomerDAO customerdao = new CustomerDAO();
				Customer customer = customerdao.getCustomerByID(customerid);

				int programmerid = rs.getInt("progrid");
				ProgrammerDAO programmerdao = new ProgrammerDAO();
				Programmer programmer = programmerdao.getProgrammerByID(programmerid);

				meets.add(new Meet(rs.getInt("meetid"), rs.getDate("date"), rs.getString("place"), rs.getString("extrainfo"), rs.getString("email"), customer, programmer));

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

			int customerid = rs.getInt("custid");
			CustomerDAO customerdao = new CustomerDAO();
				Customer customer = customerdao.getCustomerByID(customerid);

			int programmerid = rs.getInt("progrid");
			ProgrammerDAO programmerdao = new ProgrammerDAO();
			Programmer programmer = programmerdao.getProgrammerByID(programmerid);

			Meet meet = new Meet(rs.getInt("meetid"), rs.getDate("date"), rs.getString("place"), rs.getString("extrainfo"), rs.getString("email"), customer, programmer);

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

}
