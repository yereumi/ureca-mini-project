package m1jdbc.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * DatabaseMetaData
 * - DBMS로부터 전달 받는 Database 정보 객체
 * - getCatalogs : DBMS 저장 scheme 정보 // mysql> show databases;
 * - getTables : DBMS 저장 Table 정보 // mysql> show tables;
 */
public class DBMD2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Step1.
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step2.
		String url = "jdbc:mysql://127.0.0.1:3306/ureca";
		String user = "ureca";
		String password = "ureca";
		Connection con = DriverManager.getConnection(url, user, password);

		DatabaseMetaData dbmd = con.getMetaData();

		ResultSet rs1 = dbmd.getCatalogs(); // mysql> show databases;
		while(rs1.next()) {
			System.out.println( rs1.getString(1) );
		} // while
		rs1.close();

		System.out.println("==============================");

		/*
		 * getTables(String catalog, String schemaPattern, String tableNamePattern, String[] types)
		 * - mysql> show tables;
		 * - types : "TABLE", "VIEW", "SYSTEM TABLE", "GLOBAL TEMPORARY", "LOCAL TEMPORARY", "ALIAS", "SYNONYM".
		 */
		ResultSet rs2 = dbmd.getTables("ureca", "ureca", "%", null);
		while(rs2.next()) {
			System.out.print( rs2.getString(1) + "\t"); // catalog
			System.out.print( rs2.getString(2) + "\t"); // schema
			System.out.print( rs2.getString(3) + "\t"); // db object name
			System.out.print( rs2.getString(4) + "\t"); // db object type
			System.out.print( rs2.getString(5) + "\t"); // db object comment
			System.out.print( rs2.getString(6) + "\t");
			System.out.print( rs2.getString(7) + "\t");
			System.out.print( rs2.getString(8) + "\t");
			System.out.print( rs2.getString(9) + "\t");
			System.out.println( rs2.getString(10));
		} // while
		rs2.close();

		// Step5.
		con.close();
	} // main

} // class
