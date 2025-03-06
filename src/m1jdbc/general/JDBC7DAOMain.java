package m1jdbc.general;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JDBC7DAOMain {

	public static void main(String[] args) {

		JDBC7DAO dao = null;

		try {
			dao = new JDBC7DAO();
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("커넥션이 연결되지 않았습니다.");
		}

		try {
			List<EmpDTO> list = dao.selectAll();
			for (EmpDTO dto : list) {
				System.out.print(dto.getEmpno() + "\t");
				System.out.print(dto.getEname() + "\t");
				System.out.print(dto.getJob() + "\t");
				System.out.print(dto.getMgr() + "\t");
				System.out.print(dto.getHiredate() + "\t");
				System.out.print(dto.getSal() + "\t");
				System.out.print(dto.getComm() + "\t");
				System.out.println(dto.getDeptno());
			} // for
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("조회 중에 오류가 발생 하였습니다.");
		}

		try {
			dao.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("연결 해제 시에 오류가 발생 하였습니다.");
		}

	} // main

} // class
