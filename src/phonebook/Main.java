package phonebook;

import java.sql.SQLException;
public class Main {

	public static void main(String[] args) throws SQLException {
		MenuInterface menu = new MenuInterface();
		menu.build();
	}
}
