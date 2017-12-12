package fyp_classes;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class MeetDAO {

	public MeetDAO() {

	}

	public List<Meet> getMeetByCustomer(int custid) throws Exception {

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

				int custid = rs.getInt("custid");
				CustomerDAO customerdao = new CustomerDAO();
				Customer customer = customerdao.getCustomerByID(custid);

				meets.add(new Meet(rs.getInt("meetid"), rs.getString("date"), rs.getString("place"), rs.getString("extrainfo"), rs.getString("email"), customer, programmer));

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

}
