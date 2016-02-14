package animate;

import java.awt.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Date;

public class Clock_Ebrar implements Animator {
    final JPanel pan = new JPanel();
    final JLabel lab = new JLabel();
    
    int r = 0;
    int g = 0;
    int b = 0;
    
    Clock_Ebrar() {
        lab.setHorizontalAlignment(0);
        pan.setPreferredSize(new Dimension(100, 100));
        pan.setSize(400, 400);
        lab.setFont(new Font("Gill Sans", Font.BOLD, 45));
        doTick(); //initial call fills the label
    }
    
    public int doTick() {
    	lab.setForeground(new Color(r, g ,b));
        lab.setText(new Date().toString());
        if(r<255){
        	r+=5;
        	g+=5;
        	b+=5;
        }
        else {
        	r=0;
        	g=0;
        	b=0;
        }
        
        return 1000;
    }
    public Container container() {
        return lab;
    }
    public String description() {
        return "A simple clock that changes color.";
    }
    public String author() {
        return "A.Ebrar Yalcin";
    }
}
