package m1jdbc.metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * ResultSetMetaData
 * - DBMS가 전달해 주는 ResultSet의 기타 정보.
 * - getColumnCount : 조회한 속성의 갯수.
 * - getColumnName : 조회한 속성의 이름.
 * - getColumnTypeName : 조회한 속성의 Data Type.
 * - isNullable : 널 입력이 가능한 필드인가?
 * - isAutoIncrement : 자동 증가되는 컬럼인가?
 */
public class RSMD {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Step1.
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step2.
		String url = "jdbc:mysql://127.0.0.1:3306/ureca";
		String user = "ureca";
		String password = "ureca";
		Connection con = DriverManager.getConnection(url, user, password);

		String query = "select * from emp";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCnt = rsmd.getColumnCount();
		System.out.println("getColumnCount : " + columnCnt);

		for (int i = 1; i <= columnCnt; i++) {
			System.out.print(rsmd.getColumnName(i) + "\t");
		}
		System.out.println();

		for (int i = 1; i <= columnCnt; i++) {
			System.out.print(rsmd.getColumnTypeName(i) + "\t");
		}
		System.out.println();

		for (int i = 1; i <= columnCnt; i++) {
			System.out.print(rsmd.isNullable(i) + "\t");
		}
		System.out.println();

		for (int i = 1; i <= columnCnt; i++) {
			System.out.print(rsmd.isAutoIncrement(i) + "\t");
		}
		System.out.println();

		while(rs.next()) {
			for(int i = 1; i <= columnCnt; i++) {
				System.out.print( rs.getString(i) + "\t" );
			}
			System.out.println();
		} // while

		//Step5.
		rs.close();
		stmt.close();
		con.close();
	} // main

} // class
