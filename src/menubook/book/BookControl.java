package menubook.book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BookControl implements ActionListener {

    private JTable table;
    private BookDAO dao;
    private Vector<String> colNames;
    private JDialog dialog;
    private JLabel dialogLabel;

    public BookControl(BookListPan bookListPan, JDialog dialog, JLabel dialogLabel) {
        this.table = bookListPan.table;
        this.dialog = dialog;
        this.dialogLabel = dialogLabel;
        try {
            dao = new BookDAO();
        } catch( ClassNotFoundException | SQLException e ) {
//			e.printStackTrace();
            dialogOpen("도서 관리를 위한 커넥션 연결에 실패 하였습니다.");
        }
        colNames = new Vector<String>();
        colNames.add("BookID");		colNames.add("BookName");
        colNames.add("Publisher");	colNames.add("Price");
    }

    private void dialogOpen( String message ) {
        this.dialogLabel.setText(message);
        this.dialog.setVisible(true);
    }

    private void readAll() {
        Vector<Vector<String>> readAllData = null;
        try {
            readAllData = dao.readAll();
        } catch (SQLException e) {
//			e.printStackTrace();
            readAllData = new Vector<Vector<String>>();
            dialogOpen("도서 목록 조회에 실패 하였습니다.");
        }
        // BookListPan의 JTABLE에 Data 입력.
        DefaultTableModel model = new DefaultTableModel(readAllData, colNames);
        table.setModel(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if( command.equals("목록 조회") ) {
            this.readAll();
        } else if( command.equals("도서 추가") ) {
        }
    }
}
