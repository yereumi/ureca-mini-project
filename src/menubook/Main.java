package menubook;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import menubook.book.BookControl;
import menubook.book.BookListPan;
import menubook.book.CustListPan;
import menubook.book.OrdListPan;

public class Main {

    private JFrame frm;
    private CardLayout card;
    //=======================================================
    private JDialog dialog;
    private JLabel dialogLabel;
    private JButton dialogBtnClose;
    //=======================================================
    private MenuBar menuBar;
    private Menu menu1;
    private MenuItem menuItemBook, menuItemCust, menuItemOrd;
    private MenuControl menuControl;
    //=======================================================
    private BookListPan bookListPan;
    private BookControl bookControl;
    private CustListPan custListPan;
    private OrdListPan ordListPan;

    private Main() {
        frm = new JFrame("도서 판매 시스템");
        card = new CardLayout();
        //=======================================================
        dialog = new JDialog(frm, "알림", true);
        dialogLabel = new JLabel("");
        dialogBtnClose = new JButton("알림 닫기");
        //=======================================================
        menuBar = new MenuBar();
        menu1 = new Menu("선 택");
        menuItemBook = new MenuItem("도서 관리");
        menuItemCust = new MenuItem("고객 관리");
        menuItemOrd = new MenuItem("주문 관리");
        menuControl = new MenuControl(frm, card, dialog);
        //=======================================================
        bookListPan = new BookListPan();
        custListPan = new CustListPan();
        ordListPan = new OrdListPan();
    }

    private void makeGui() {
        frm.setSize(500, 500);
        //=======================================================
        frm.setMenuBar(menuBar);
        menuBar.add(menu1);
        menu1.add(menuItemBook);	menu1.addSeparator();
        menu1.add(menuItemCust);	menu1.addSeparator();
        menu1.add(menuItemOrd);
        //=======================================================
        frm.setLayout(card);
        frm.add(bookListPan, "BookList");
        frm.add(custListPan, "CustList");
        frm.add(ordListPan, "OrdList");
        //=======================================================
        dialog.setSize(300, 100);
        dialog.setLayout( new GridLayout(2,1) );
        dialog.add(dialogLabel);
        dialog.add(dialogBtnClose);
        //=======================================================
        frm.setVisible(true);
    }

    private void addEvent() {
        dialogBtnClose.addActionListener(menuControl);
        menuItemBook.addActionListener(menuControl);
        menuItemCust.addActionListener(menuControl);
        menuItemOrd.addActionListener(menuControl);
        frm.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    } // windowClosing
                }
        );
        //=======================================================
        bookControl = new BookControl(bookListPan, dialog, dialogLabel);
        bookListPan.addEvent(bookControl);
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.makeGui();
        m.addEvent();
    }
}
