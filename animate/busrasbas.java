package animate;

import java.awt.Font;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JPanel;
import java.util.Date;
import java.awt.Graphics;
import java.applet.Applet;

public class busrasbas extends Applet implements Animator {
    private String msg = "123456789";
    final JPanel lab = new Panel();
    Date date = new Date();
    busrasbas() {
        lab.setForeground(Color.BLUE);
        lab.setFont(new Font("Serif", Font.BOLD, 40));
        doTick(); //initial call fills the label
    }
    public int doTick() {
	msg +=msg.charAt(0);
        msg = msg.substring(1,msg.length());
          
           
            lab.repaint();
            return 1000;
    }
    public Container container() {
        return lab;
    }
    public String description() {
        return "1'den 9'a kadar sayilarin kombinasyonu";
    }
    public String author() {
        return "Busra Bas";
    }

	class Panel extends javax.swing.JPanel { //drawing
      public void paint(Graphics g) {
      g.clearRect(0,0,2*MX,2*MY);
      setBackground(Color.CYAN);
        Font currentFont = new Font("Impact", Font.BOLD, 22);
        g.setFont(currentFont);
        g.drawString(msg, MX, MY);

      }
   } 
}
