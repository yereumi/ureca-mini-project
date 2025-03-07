package m2swing.level2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class CalcActionProcessor implements ActionListener {

    private JTextField tf;
    private int firstNum, secondNum;
    private String giho = "+";

    public CalcActionProcessor() {}
    public CalcActionProcessor(JTextField tf) {
        this.tf = tf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "CLS" -> tf.setText("");
            case "=" -> {
                secondNum = Integer.parseInt(tf.getText());
                switch (giho) {
                    case "+" : tf.setText((firstNum + secondNum) + ""); break;
                    case "-" : tf.setText((firstNum - secondNum) + ""); break;
                    case "*" : tf.setText((firstNum * secondNum) + ""); break;
                    case "/" : tf.setText((firstNum / secondNum) + ""); break;
                }
            }
            case "+", "-", "*", "/" -> {
                firstNum = Integer.parseInt(tf.getText());
                giho = command;
                tf.setText("");
            }
            default ->  // 숫자키
                    tf.setText(tf.getText() + command);
        }
    }
}
