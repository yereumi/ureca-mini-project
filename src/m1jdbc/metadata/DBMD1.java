package m1jdbc.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * DatabaseMetaData
 * - DBMS로부터 전달 받는 Database 정보 객체
 * - DBMS 정보 : getDatabaseProductName, getDatabaseProductVersion,
 *   getDatabaseMajorVersion, getDatabaseMinorVersion
 * - Driver 정보 : getDriverName, getDriverVersion,
 *   getDriverMajorVersion, getDriverMinorVersion
 *   getJDBCMajorVersion, getJDBCMinorVersion
 * - Connection 정보 : getURL, getUserName
 *   isReadOnly, getDefaultTransactionIsolation
 */
public class DBMD1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Step1.
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step2.
		String url = "jdbc:mysql://127.0.0.1:3306/ureca";
		String user = "ureca";
		String password = "ureca";
		Connection con = DriverManager.getConnection(url, user, password);

		DatabaseMetaData dbmd = con.getMetaData();

		System.out.println("getDatabaseProductName : " + dbmd.getDatabaseProductName());
		System.out.println("getDatabaseProductVersion : " + dbmd.getDatabaseProductVersion());
		System.out.println("==============================");
		System.out.println("getDriverName : " + dbmd.getDriverName());
		System.out.println("getDriverVersion : " + dbmd.getDriverVersion());
		System.out.println("==============================");
		System.out.println("getJDBCMajorVersion : " + dbmd.getJDBCMajorVersion());
		System.out.println("getJDBCMinorVersion : " + dbmd.getJDBCMinorVersion());
		System.out.println("==============================");
		System.out.println("getURL : " + dbmd.getURL());
		System.out.println("getUserName : " + dbmd.getUserName());
		System.out.println("isReadOnly : " + dbmd.isReadOnly());
		System.out.println("getDefaultTransactionIsolation : " + dbmd.getDefaultTransactionIsolation());
		System.out.println("==============================");
		System.out.println("TRANSACTION_NONE : " + Connection.TRANSACTION_NONE);
		System.out.println("TRANSACTION_READ_COMMITTED : " + Connection.TRANSACTION_READ_COMMITTED);
		System.out.println("TRANSACTION_READ_UNCOMMITTED : " + Connection.TRANSACTION_READ_UNCOMMITTED);
		System.out.println("TRANSACTION_REPEATABLE_READ : " + Connection.TRANSACTION_REPEATABLE_READ);
		System.out.println("TRANSACTION_SERIALIZABLE : " + Connection.TRANSACTION_SERIALIZABLE);

		// Step5.
		con.close();
	} // main

} // class
