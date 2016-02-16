package animate;

import java.awt.Graphics;
import java.awt.Container;
import java.awt.Color;

public class HuseyinYasasin implements Animator {
    final static double DELTA = Math.PI/15; //one turn = 100 ticks 
    final static int A = MX, B = MY, D = 40, E = 80;
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
        return "Flying Wings";
    }
    public String author() {
        return "Hüseyin Yaþasýn";
    }
   
   class Panel extends javax.swing.JPanel { //drawing
      public void paint(Graphics g) {
        g.setColor(Color.ORANGE);
        g.clearRect(0, 0, 2*MX, 2*MY);
        
        double x = MX + A * Math.cos(angle) / Math.sin(angle);
        double y = MY + B * Math.cos(angle) / Math.sin(angle);
              

        g.fillRoundRect((int)x, (int)y, D, E, D, E);
        g.fillRoundRect((int)x, (int)y, E, D, E, D);
        g.fillRoundRect((int)y, (int)x, D, E, D, E);
        g.fillRoundRect((int)y, (int)x, E, D, E, D);
        g.fillRoundRect((int)x, (int)x, D, E, D, E);
        g.fillRoundRect((int)x, (int)x, E, D, E, D);
        g.fillRoundRect((int)y, (int)y, D, E, D, E);
        g.fillRoundRect((int)y, (int)y, E, D, E, D);
          
      }
   } 
}
