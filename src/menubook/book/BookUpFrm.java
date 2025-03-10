package menubook.book;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookUpFrm extends JFrame {

	private JPanel panInsert, panButton;
	private JLabel labelBookName, labelPublisher, labelPrice;
	protected JTextField tfBookName, tfPublisher, tfPrice;
	private JButton btnUpdate, btnDelete, btnCancel;

	public BookUpFrm() {
		panInsert = new JPanel();
		panButton = new JPanel();
		labelBookName = new JLabel("BookName");
		labelPublisher = new JLabel("Publisher");
		labelPrice = new JLabel("Price");
		tfBookName = new JTextField();
		tfPublisher = new JTextField();
		tfPrice = new JTextField();
		btnUpdate = new JButton("도서 수정");
		btnDelete = new JButton("도서 삭제");
		btnCancel = new JButton("수정 취소");
		makeGui();
	}

	public void makeGui() {
		setTitle("도서 정보 입력");
		setSize(500, 500);
		//==================================
		add(panInsert, BorderLayout.CENTER);
		panInsert.setLayout(null);
		panInsert.add(labelBookName);	labelBookName.setBounds(10, 10, 100, 35);
		panInsert.add(labelPublisher);	labelPublisher.setBounds(10, 50, 100, 35);
		panInsert.add(labelPrice);		labelPrice.setBounds(10, 90, 100, 35);
		panInsert.add(tfBookName);		tfBookName.setBounds(120, 10, 300, 35);
		panInsert.add(tfPublisher);		tfPublisher.setBounds(120, 50, 300, 35);
		panInsert.add(tfPrice);			tfPrice.setBounds(120, 90, 300, 35);
		//==================================
		add(panButton, BorderLayout.SOUTH);
		panButton.add(btnUpdate);
		panButton.add(btnDelete);
		panButton.add(btnCancel);
	}

	public void addEvent(BookControl bookControl) {
		btnUpdate.addActionListener(bookControl);
		btnDelete.addActionListener(bookControl);
		btnCancel.addActionListener(bookControl);
	}

} // class
