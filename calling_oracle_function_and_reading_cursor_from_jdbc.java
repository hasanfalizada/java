package ha;

import java.sql.*;

import oracle.jdbc.internal.OracleTypes;

public class Development {

	public static void main(String args[]) {

		Connection myConnection = null;
		Statement myStatement = null;

		try {

			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			myConnection = DriverManager.getConnection("jdbc:oracle:thin:@172.21.14.34:1521/ldbtest", "cbapp", "cbapp");

			myConnection.setAutoCommit(false);

			CallableStatement cstmt = myConnection.prepareCall("{? = call cbapp.cb_api_front.login(?, ?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.setString(2, "3507337AZSuperNTest1");
			cstmt.setString(3,
					"3627909a29c31381a071ec27f7c9ca97726182aed29a7ddd2e54353322cfb30abb9e3a6df2ac2c20fe23436311d678564d0c8d305930575f60e2d3d048184d79");
			cstmt.execute();

			String sess_id = null;
			ResultSet rset = (ResultSet) cstmt.getObject(1);
			for (int i = 0; rset.next(); i++)
				sess_id = rset.getString(1);

			cstmt = myConnection.prepareCall("{? = call cbapp.cb_batch_operations.create_entries(?, ?)}");
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.setInt(2, 64);
			cstmt.setString(3, sess_id);
			cstmt.executeUpdate();
			System.out.println(cstmt.getInt(1));

		} catch (SQLException e) {

			System.out.println("Error code = " + e.getErrorCode());
			System.out.println("Error message = " + e.getMessage());
			System.out.println("SQL state = " + e.getSQLState());
			e.printStackTrace();

		} finally {

			try {

				// close the Statement object using the close() method
				if (myStatement != null) {
					myStatement.close();
				}

				// close the Connection object using the close() method
				if (myConnection != null) {
					myConnection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // end of main()
}
