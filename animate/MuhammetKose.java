package animate;

import java.awt.Font;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JLabel;
import java.util.Date;
import java.util.Random;

public class MuhammetKose implements Animator {
    final JLabel lab = new JLabel();
    Random r=new Random();
    int a;
    MuhammetKose() {      
        lab.setForeground(Color.WHITE);
        lab.setHorizontalAlignment(0);
        lab.setFont(new Font("Serif", Font.BOLD, 40));
        doTick(); //initial call fills the label
    }
    public int doTick() {
        a=r.nextInt(214748664);
        lab.setText(String.valueOf(a));
        return 1000;
    }
    public Container container() {
        return lab;
    }
    public String description() {
        return "Getting random number";
    }
    public String author() {
        return "Muhammet Kose";
    }
}
