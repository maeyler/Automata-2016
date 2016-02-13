package animate;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.Color;

public class Serap implements Animator {
    final static double DELTA = Math.PI/50; //one turn = 100 ticks 
    final static int A = MX-50, B = MY-50, C=100,D = 100, ilkAci1=90,ilkAci2=0, supurmeAcisi1=75,supurmeAcisi2=175,z=0;
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
        return "Draw Arc";
    }
    public String author() {
        return "Serap MEMÝSOGLU";
    } 
   
   class Panel extends javax.swing.JPanel { //drawing
      public void paint(Graphics g) {
        g.clearRect(0, 0, 2*MX, 2*MY);
        g.setColor(Color.BLUE);
        double a= MX + A * Math.sin(angle);
        double b = MY + B * Math.sin(angle);
        g.drawArc((int)a, (int)b,C,D,ilkAci1 ,supurmeAcisi1);
        g.fillArc((int)a, (int)b,C,D,ilkAci1 ,supurmeAcisi1);
        
        g.setColor(Color.RED);
        double c= MX + A * Math.cos(angle);
        double d = MY + B * Math.cos(angle);
        g.drawArc((int)c, (int)d,C,D,ilkAci1 ,supurmeAcisi2);
        g.fillArc((int)c, (int)d,C,D,ilkAci1 ,supurmeAcisi2);
        
        g.setColor(Color.GREEN);
        double e= MX + A * Math.sin(angle);
        double f = MY + B * Math.cos(angle);
        g.drawArc((int)e, (int)f,C,D,ilkAci2 ,supurmeAcisi1);
        g.fillArc((int)e, (int)f,C,D,ilkAci2 ,supurmeAcisi1);
        
        g.setColor(Color.YELLOW);
        double k= MX + A * Math.cos(angle);
        double h = MY + B * Math.sin(angle);
        g.drawArc((int)k, (int)h,C,D,ilkAci2 ,supurmeAcisi2);
        g.fillArc((int)k, (int)h,C,D,ilkAci2 ,supurmeAcisi2);
        
        g.setColor(Color.BLACK);
        double l= MX + A * Math.sin(angle);
        double m = MY + B * Math.sin(angle);
        g.drawLine((int)l, (int)m,C,D);
        
        g.setColor(Color.ORANGE);
        double n= MX + A * Math.sin(angle);
        double o = MY + B * Math.sin(angle);
        g.drawLine((int)n, (int)o,z,z);
      }
   } 
}
