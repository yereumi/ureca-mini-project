package m2swing.level3;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EmpWindowEventProcessor extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent event) {
        System.exit(0);
    }
}
