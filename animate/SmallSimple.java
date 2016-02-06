package animate;

import java.awt.Font;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JLabel;
import java.util.Date;

public class SmallSimple implements Animator {
    final JLabel lab = new JLabel();
    SmallSimple() {
        lab.setForeground(Color.BLUE);
        lab.setFont(new Font("Serif", Font.BOLD, 24));
        doTick(); //initial call fills the label
    }
    public int doTick() {
        lab.setText(new Date().toString());
        return 1000;
    }
    public Container container() {
        return lab;
    }
    public String description(String source) {
        return "A simple clock using JLabel";
    }
    public String author() {
        return "Small Simple";
    }
}
