package preparestate;

import java.sql.SQLException;

public class PrepareMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		PrepareStatement ps = new PrepareStatement();
		//ps.createTable();
		//ps.insertData();
		//ps.updateData();
		//ps.deleteData();
		ps.fetchData();

	}

}
