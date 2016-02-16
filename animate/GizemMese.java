package animate;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.Color;

public class GizemMese implements Animator {
    final static double DELTA = Math.PI/40; //one turn = 100 ticks 
    final static int A = MX-50, B = MY-60, D = 40;
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
        return "Balls Colliding";
    }
    public String author() {
        return "GIZEM NUR MESE";
    }
   
   class Panel extends javax.swing.JPanel { //drawing
      public void paint(Graphics g) { 
          g.setColor(Color.RED);
          g.clearRect(0, 0, 2*MX, 2*MY);
        
          double x = MX + A * Math.sin(angle);
          double y = MY + B * Math.cos(angle);
         
          double Z = MX + A * Math.cos(angle);
          double T = MY + B * Math.sin(angle);
         
          g.fillOval((int)x, (int)y, D, D);
          g.fillOval((int)Z, (int)T, D, D);
      }
   } 
}
