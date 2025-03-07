package m2swing.level2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CalcWindowEventProcessor extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent event) {
        System.exit(0);
    }
}
