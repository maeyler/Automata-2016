package animate;

import java.awt.Font;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JLabel;
import java.util.Date;

public class Clock_SSS implements Animator {
    final JLabel lab = new JLabel();
    Clock_SSS() {
        lab.setForeground(Color.BLUE);
        lab.setHorizontalAlignment(0);
        lab.setFont(new Font("Serif", Font.BOLD, 40));
        doTick(); //initial call fills the label
    }
    public int doTick() {
        lab.setText(new Date().toString());
        return 1000;
    }
    public Container container() {
        return lab;
    }
    public String description() {
        return "A simple clock using JLabel";
    }
    public String author() {
        return "Small Simple";
    }
}
