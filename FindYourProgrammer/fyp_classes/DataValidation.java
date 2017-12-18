package fyp_classes;
import java.sql.*;

public class DataValidation {

	public DataValidation() {

	}

	public boolean isNameValid(String name) {

		return (name == null || name.length() < 3 ? false : true);

	}

	public boolean isValidEmailAddress(String email) {

        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);

        return m.matches();
	}

	public boolean isValidPhoneNumber(String phone) {

		if( phone == null || phone.length() != 10) {

			return false;
		}

		try {

			Long.parseLong(phone);

		} catch (NumberFormatException e) {

			return false;
		}

		return true;
	}

	public boolean isPasswordValid(String p1, String p2) {

		if(p1.equals(p2)) {

			return true;

		} else {

			return false;
		}
	}

	public boolean isUsernameValid(String username) throws Exception {

		Connection con = null;

		String sqlquery = "SELECT username FROM customer WHERE username = ?;";

		PreparedStatement stmt = null;

		DB db = new DB();

		try {

			db.open();

			con = db.getConnection();

			stmt = con.prepareStatement(sqlquery);

			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {

				return false;

			} else {

				return true;
			}



		} catch (Exception e) {

			throw new Exception(e.getMessage());

		} finally {

			try {
				db.close();

			} catch (Exception e) {

			}
		}
	}

	public static boolean isNull(String s)	{

	  return (s==null || s.trim().equals(""));
	}





}
