package m2swing.level1;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class MenuEventProcessor implements ActionListener {

    private JFrame frm;
    private CardLayout card;

    public MenuEventProcessor() {}
    public MenuEventProcessor(JFrame frm, CardLayout card) {
        this.frm = frm;
        this.card = card;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case("BLUE") : card.show(frm.getContentPane(), command);
            case("GRAY") : card.show(frm.getContentPane(), command);
            case("PINK") : card.show(frm.getContentPane(), command);
            case("GREEN") : card.show(frm.getContentPane(), command);
            case("ORANGE") : card.show(frm.getContentPane(), command);
        }
    }
}
