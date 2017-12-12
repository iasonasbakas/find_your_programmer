package fyp_classes;

import java.sql.*;

public class CustomerDAO {

	public CustomerDAO() {

	}

	public Customer findCustomer(String username) throws Exception {

		Connection con = null;

		String sqlquery= "SELECT * FROM customer WHERE username=?;";

		DB db = new DB();

		try {

			db.open();

			con = db.getConnection();

			PreparedStatement stmt = con.prepareStatement(sqlquery);
			stmt.setString( 1, username );

			ResultSet rs = stmt.executeQuery();

			if( !rs.next() ) {

				rs.close();
				stmt.close();
				db.close();

				throw new Exception("Not valide username");

			}

			Customer customer = new Customer( rs.getInt("custid"), rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("surname"), rs.getString("phone"), rs.getString("email") );

			rs.close();
			stmt.close();
			db.close();

			return customer;

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		} finally {

			try {
				db.close();
			} catch (Exception e) {
				//no need to do anything...
			}

		}

	}


	public Customer getCustomerByID(int custid) throws Exception {

		Connection con = null;

		String sqlquery= "SELECT * FROM customer WHERE custid = ?;";

		DB db = new DB();

		try {

			db.open();

			con = db.getConnection();

			PreparedStatement stmt = con.prepareStatement(sqlquery);
			stmt.setInt( 1, custid );

			ResultSet rs = stmt.executeQuery();

			if( !rs.next() ) {

				rs.close();
				stmt.close();
				db.close();

				throw new Exception("Not valide username");

			}

			Customer customer = new Customer( rs.getInt("custid"), rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("surname"), rs.getString("phone"), rs.getString("email") );

			rs.close();
			stmt.close();
			db.close();

			return customer;

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		} finally {

			try {
				db.close();
			} catch (Exception e) {
				//no need to do anything...
			}

		}

	}


	public void authenticate(String username, String password) throws Exception {

		Connection con = null;

		String sqlquery = "SELECT * FROM customer WHERE username=? AND password=?;";

		DB db = new DB();

		try {

			db.open();

			con = db.getConnection();

			PreparedStatement stmt = con.prepareStatement(sqlquery);
			stmt.setString(1, username);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();

			if(!rs.next()) {
				rs.close();
				stmt.close();
				db.close();
				throw new Exception("Wrong username or password");
			}

			rs.close();
			stmt.close();
			db.close();

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
