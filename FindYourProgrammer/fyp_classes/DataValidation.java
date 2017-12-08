package fyp_classes;

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

}
