package animate;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JLabel;

public class Burhan_Emanetoglu implements Animator {

    final JLabel lab = new JLabel();
    int counter = 0;

    Burhan_Emanetoglu() {
        lab.setForeground(Color.DARK_GRAY);
         lab.setLocation(80,80);
        lab.setFont(new Font("Serif", Font.BOLD, 100));
        doTick(); //initial call fills the label
    }

    public int doTick() {
        lab.setText(".");
        if (counter < 40) {
            lab.setLocation(lab.getX() + 5, lab.getY() + 5);
            counter++;
        } else if (counter < 80) {
            lab.setLocation(lab.getX() + 5, lab.getY() - 5);
            counter++;
        } else if (counter < 120) {
            lab.setLocation(lab.getX() - 5, lab.getY() - 5);
            counter++;
        } else if (counter < 160) {
            lab.setLocation(lab.getX() - 5, lab.getY() + 5);
            counter++;
        } else {
            counter = 0;
        }
        return 10;
    }

    public Container container() {
        return lab;
    }

    public String description() {
        return "Rectangle Moves";
    }

    public String author() {
        return "Burhan Emanetoglu";
    }
}
