package menubook.book;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookInsFrm extends JFrame {

    private JPanel panInsert, panButton;
    private JLabel labelBookName, labelPublisher, labelPrice;
    private JTextField tfBookName, tfPublisher, tfPrice;
    private JButton btnSave, btnCancel;

    public BookInsFrm() {
        panInsert = new JPanel();
        panButton = new JPanel();
        labelBookName = new JLabel("BookName");
        labelPublisher = new JLabel("Publisher");
        labelPrice = new JLabel("Price");
        tfBookName = new JTextField();
        tfPublisher = new JTextField();
        tfPrice = new JTextField();
        btnSave = new JButton("도서 저장");
        btnCancel = new JButton("입력 취소");
        makeGui();
        addEvent();
    }

    public void makeGui() {
        setTitle("도서 정보 입력");
        setSize(500, 500);
        //==================================
        add(panInsert, BorderLayout.CENTER);
        panInsert.setLayout(null);
        panInsert.add(labelBookName);	labelBookName.setBounds(10, 10, 100, 35);
        panInsert.add(labelPublisher);	labelBookName.setBounds(10, 50, 100, 35);
        panInsert.add(labelPrice);		labelBookName.setBounds(10, 90, 100, 35);
        panInsert.add(tfBookName);		labelBookName.setBounds(120, 10, 300, 35);
        panInsert.add(tfPublisher);		labelBookName.setBounds(120, 50, 300, 35);
        panInsert.add(tfPrice);			labelBookName.setBounds(120, 90, 300, 35);
        //==================================
        add(panButton, BorderLayout.SOUTH);
        panButton.add(btnSave);
        panButton.add(btnCancel);
    }

    public void addEvent() {

    }

} // class
