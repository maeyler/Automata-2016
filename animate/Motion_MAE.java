package animate;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;

public class Motion_MAE implements Animator {
    final static double DELTA = Math.PI/50; //one turn = 100 ticks 
    final static int A = MX-50, B = MY-50, D = 10;
    final Container pan = new Panel();
    double angle = 0; //in radians

    public int doTick() {
        angle += DELTA; pan.repaint(); 
        return 100;
    }
    public Container container() {
        return pan;
    }
    public String description() {
        return "Elliptic orbit of a planet";
    }
    public String author() {
        return "M Akif Eyler";
    }
   
   class Panel extends javax.swing.JPanel { //drawing
      public void paint(Graphics g) {
          g.clearRect(0, 0, 2*MX, 2*MY);
          double x = MX + A * Math.cos(angle);
          double y = MY + B * Math.sin(angle);
          g.fillOval((int)x, (int)y, D, D);
      }
   } 
}
