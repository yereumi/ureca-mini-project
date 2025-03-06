package m1jdbc.general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * PreparedStatement
 * 쿼리를 미리 만들어 적용하는 Statement.
 * 쿼리의 일부를 ?로 만든 후, 나중에 ?에 값을 대입한다.
 */
public class JDBC4InsertPrepare {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Step1.
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step2.
		String url = "jdbc:mysql://127.0.0.1:3306/ureca";
		String user = "ureca";
		String password = "ureca";
		Connection con = DriverManager.getConnection(url, user, password);

		//data in
		Scanner scan = new Scanner(System.in);
		System.out.print("제목 : ");
		String title = scan.nextLine();
		System.out.print("작성자 : ");
		String writer = scan.nextLine();
		System.out.print("내용 : ");
		String contents = scan.nextLine();

		// Step3.
		String query = "insert into test_board(brd_title, brd_writer, brd_cntns, brd_date)"
				+ " values( ?, ?, ?, now() )";
		PreparedStatement psmt = con.prepareStatement(query);
		psmt.setString(1, title);
		psmt.setString(2, writer);
		psmt.setString(3, contents);

		// Step4.
		int successCount = 0;
		successCount = psmt.executeUpdate();
		System.out.println(successCount + "건이 입력 되었습니다.");

		// Step5.
		psmt.close();
		con.close();
	} // main

} // class
