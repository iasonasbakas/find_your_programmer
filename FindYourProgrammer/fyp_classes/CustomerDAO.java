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

			Customer customer = new Customer(rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("surname"), rs.getString("phone"), rs.getString("email") );

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

			Customer customer = new Customer(rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("surname"), rs.getString("phone"), rs.getString("email") );

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

	public void saveCustomer(Customer customer) throws Exception {

		Connection con = null;

		String sqlquery = "INSERT INTO customer (username, password, name, surname, email, phone) VALUES (?, ?, ?, ?, ?, ?);";

		DB db = new DB();

		PreparedStatement stmt = null;

		try {

			db.open();

			con = db.getConnection();

			stmt = con.prepareStatement(sqlquery);

			String username = customer.getUsername();
			String password = customer.getPassword();
			String name = customer.getName();
			String surname = customer.getSurname();
			String phone = customer.getPhone();
			String email = customer.getEmail();

			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, name);
			stmt.setString(4, surname);
			stmt.setString(5, email);
			stmt.setString(6, phone);

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
