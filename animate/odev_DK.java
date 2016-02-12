package animate;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;

public class odev_DK implements Animator {
    final static double DELTA = Math.PI/30; //one turn = 100 ticks 
    final static int A = MX-50, B = MY-50, D = 30;
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
        return "Three balls colliding ";
    }
    public String author() {
        return "Derya Kopsen";
    }
   
   class Panel extends javax.swing.JPanel { //drawing
      public void paint(Graphics g) {
          g.clearRect(0, 0, 2*MX, 2*MY);
          double x = MX + A * Math.sin(angle);
          double y = MY + B * Math.cos(angle);
          
          double k=  MX + A * Math.cos(angle);
          double m=  MY + B * Math.sin(angle);
          
          double z=  MX + A * Math.sin(angle);
          double t=  MY + B * Math.sin(angle);
          
          
          
          g.fillOval((int)x, (int)y, D, D);
          g.fillOval((int)k, (int)m, D, D);
          g.fillOval((int)z, (int)t, D, D);
         
      }
   } 
}
