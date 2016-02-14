package animate;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;

public class EbruKanat implements Animator {
    final static double DELTA = Math.PI/30; //one turn = 100 ticks 
    
    final static int widht = MX-50, height = MY-50, period = 10;
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
        return "Ball";
    }
    public String author() {
        return "Ebru Kanat";
    }
   
   class Panel extends javax.swing.JPanel { //drawing
      public void paint(Graphics g) {
          g.clearRect(0, 0, 2*MX, 2*MY);
          double x = MX + widht * Math.cos(angle);
          double y = MY + height * Math.sin(angle);
          g.fillOval((int)x, (int)y, period, period);

          double a = MX + widht * Math.sin(angle);
          double b= MY + height * Math.sin(angle);
          g.fillRect((int)a, (int)b, period, period);
      }
   } 
}
