package m2swing.level1;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class CardEventProcess extends MouseAdapter {

    private JFrame frm;
    private CardLayout card;

    public CardEventProcess() {};
    public CardEventProcess(JFrame frm, CardLayout card) {
        this.frm = frm;
        this.card = card;
    }

    public void mouseClicked(MouseEvent e) {
        card.next(frm.getContentPane());
    }
}
