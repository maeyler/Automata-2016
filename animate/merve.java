package animate;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;

public class merve implements Animator {
    final static double DELTA = Math.PI/50; //one turn = 100 ticks 
    final static int A = MX-50, B = MY-50, D = 10, M=15,N=30,K=60;
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
        return "draw rectangle";
    }
    public String author() {
        return "Merve Kaplan";
    }
   
   class Panel extends javax.swing.JPanel { //drawing
      public void paint(Graphics g) {
          g.clearRect(0, 0, 2*MX, 2*MY);
          double x = MX + A * Math.cos(angle);
          double y = MY + B * Math.sin(angle);
          g.drawRect((int)x, (int)y, 60, 50);
          g.fillRect((int)x, (int)y, 60, 50);
          
          double s = MX + A * Math.cos(angle);
          double t = MY + B * Math.sin(angle);
          g.drawRoundRect((int)s, (int)t, D, M, N, K);
          g.fillRoundRect((int)s, (int)t,D,M,N, K);
      }
   } 
}
