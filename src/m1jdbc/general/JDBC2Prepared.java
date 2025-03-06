package m1jdbc.general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC2Prepared {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner scan = new Scanner(System.in);
		String inData = scan.nextLine();

		Class.forName("com.mysql.cj.jdbc.Driver"); // 1단계.

		String url = "jdbc:mysql://localhost:3306/ureca"; // 연결 명령, ip, port, dbname.
		String user = "ureca";
		String password = "ureca";
		Connection con = DriverManager.getConnection(url, user, password); // 2단계.

		String query = "SELECT e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno"
				+ ", d.dname, d.loc"
				+ "  FROM emp e, dept d"
				+ "  WHERE e.deptno = d.deptno"
				+ "  AND ename = ?";
		PreparedStatement psmt = con.prepareStatement(query); // 3단계.
		psmt.setString(1, inData); // 쿼리의 1번째 물음표를 inData 값으로 교체해라.

		ResultSet rs = psmt.executeQuery();

		while (rs.next()) { // 4단계.
			System.out.print(rs.getString("sal") + "\t");
			System.out.print(rs.getInt("empno") + "\t");
			System.out.print(rs.getString("ename") + "\t\t");
			System.out.print(rs.getString("job") + "\t\t");
			System.out.print(rs.getInt("mgr") + "\t");
			System.out.print(rs.getString("hiredate") + "\t");
			System.out.print(rs.getInt("comm") + "\t");
			System.out.print(rs.getInt("deptno") + "\t");
			System.out.print(rs.getString("dname") + "\t\t");
			System.out.println(rs.getString("loc"));
		} //while

		rs.close();
		psmt.close();
		con.close();
	} // main

} // class





