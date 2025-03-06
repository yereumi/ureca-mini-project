package m1jdbc.general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * ResutSet Type
 * - TYPE_FORWARD_ONLY : 단방향 이동.
 * - TYPE_SCROLL_INSENSITIVE : 양방향 이동 + UPDATE 불가.
 * - TYPE_SCROLL_SENSITIVE : 양방향 이동 + UPDATE 가능.
 * - CONCUR_READ_ONLY : 읽기 전용.
 * - CONCUR_UPDATABLE : UPDATE 가능.
 */
public class JDBC5ResultSetUpdate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Step1.
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step2.
		String url = "jdbc:mysql://127.0.0.1:3306/ureca";
		String user = "ureca";
		String password = "ureca";
		Connection con = DriverManager.getConnection(url, user, password);

		// Step3.
		Statement stmt = con.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

		// Step4.
		String query = "SELECT * FROM emp3";
		ResultSet rs = stmt.executeQuery(query);

		while(rs.next()) {
			if( rs.getString("ename").equals("MILLER") ) {
				rs.updateInt("comm", 100);
				rs.updateRow();
			} // if
		} // while
		System.out.println("complete update test...");

		// Step5.
		rs.close();
		stmt.close();
		con.close();
	} // main

} // class
