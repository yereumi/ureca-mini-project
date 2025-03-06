package m1jdbc.general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * connection.setAutoCommit(false);
 * connection.commit();
 * connection.rollback();
 */
public class JDBC6Commit {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Step1.
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step2.
		String url = "jdbc:mysql://127.0.0.1:3306/ureca";
		String user = "ureca";
		String password = "ureca";
		Connection con = DriverManager.getConnection(url, user, password);

		// Connection 생성 직후.
		con.setAutoCommit(false);

		// Step3.
		Statement stmt = con.createStatement();

		// Step4.
		String query1 = "insert into test_board(brd_title, brd_writer, brd_cntns, brd_date)"
				+ " values('테스트1', '수업1', '수업 중 테스트 1', now())";
		String query2 = "insert into test_board(brd_title, brd_writer, brd_cntns, brd_date)"
				+ " values('테스트2', '수업2', '수업 중 테스트 2', now())";
		int sCnt1 = 0, sCnt2 = 0;
		sCnt1 = stmt.executeUpdate(query1);
		sCnt2 = stmt.executeUpdate(query2);

		con.commit();
		//con.rollback();
		System.out.println( (sCnt1 + sCnt2) + "건이 입력 되었습니다." );

		// Step5.
		stmt.close();
		con.close();
	} // main

} // class
