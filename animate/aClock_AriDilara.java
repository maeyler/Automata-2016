package animate;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;

public class aClock_AriDilara implements Animator {
    final static double DELTA = Math.PI/50; //one turn = 100 ticks 
    final static int A = MX-50, B = MY-50;
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
        return "showing seconds on an analog clock";
    }
    public String author() {
        return "A Dilara ARI";
    }
   
   class Panel extends javax.swing.JPanel { //drawing
 
      public void paint(Graphics g) {
      
          g.clearRect(0, 0, 2*MX, 2*MY);
          g.drawOval(0, 0, 2*MX, 2*MY);
        
          double x = MX + A * Math.cos(angle);
          double y = MY + B * Math.sin(angle);
          
          g.drawString(Integer.toString(9),0,290);
          g.drawString(Integer.toString(3),750,290);
          g.drawString(Integer.toString(12),360,10);
          g.drawString(Integer.toString(6),365,570);
          g.drawLine((int)x, (int)y, 370, 270);
         
      }
   } 
}
