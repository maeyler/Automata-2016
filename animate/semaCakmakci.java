package animate;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.Color;

public class semaCakmakci implements Animator {
    final static double DELTA = Math.PI/15; //one turn = 100 ticks 
    final static int A = MX-50, B = MY-50, D = 50, Y=100, S=50;
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
        return "No Description";
    }
    public String author() {
        return "Sema Cakmakci";
    }
   
   class Panel extends javax.swing.JPanel { //drawing
      public void paint(Graphics g) {
        g.clearRect(0, 0, 2*MX, 2*MY);
        g.setColor(Color.BLUE);
        double x = MX + A * Math.sin(angle);
        double y = MY + B * Math.sin(angle);
        g.fillRect((int)x, (int)y, D, D);
        double a = MX + A * Math.cos(angle);
        double b = MY + Math.sin(angle);
        g.drawOval((int)a, (int)b, Y, Y);
        double c = MX + Math.cos(angle);
        double d = MY + B * Math.sin(angle);
        g.fillOval((int)c, (int)d, S, S);
           
      }
   } 
}
