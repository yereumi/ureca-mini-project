package menubook.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class BookDAO {

    private Connection con;
    private String url = "jdbc:mysql://127.0.0.1:3306/madangdb"; // 연결 명령, ip, port.
    private String user = "madang";
    private String password = "madang1234";

    public BookDAO() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, user, password);
    }

    public void close() throws SQLException {
        con.close();
    } // close

    public Vector<Vector<String>> readAll() throws SQLException {
        String sqlSelectAll = "select * from book";

        Vector<Vector<String>> list = new Vector<Vector<String>>();

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sqlSelectAll);
        while(rs.next()) {
            Vector<String> obj = new Vector<String>();
            obj.add(rs.getString("bookid"));
            obj.add(rs.getString("bookname"));
            obj.add(rs.getString("publisher"));
            obj.add(rs.getString("price"));
            list.add(obj);
        } // while

        rs.close();
        stmt.close();

        return list;
    } // readAll
}