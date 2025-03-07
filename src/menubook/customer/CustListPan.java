package menubook.book;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CustListPan extends JPanel {

    private JPanel pan;
    private JButton btnAdd, btnReadAll;
    private BorderLayout border;
    private JTable table;
    private JScrollPane scrollPane;

    public CustListPan() {
        pan = new JPanel();
        btnAdd = new JButton("고객 추가");
        btnReadAll = new JButton("목록 조회");
        border = new BorderLayout();
        table = new JTable();
        scrollPane = new JScrollPane(table);
        makeGui();
        addEvent();
    }

    public void makeGui() {
        setLayout(border);
        setSize(500, 500);
        add(scrollPane, BorderLayout.CENTER);
        add(pan, BorderLayout.SOUTH);
        pan.add(btnAdd);
        pan.add(btnReadAll);
        setVisible(true);
    }

    public void addEvent() {

    }
}
