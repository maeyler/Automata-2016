package animate;

import static animate.Animator.MY;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;


public class Zahid_Coban implements Animator {
    final static double DELTA = Math.PI/50; //one turn = 100 ticks 
    final static int A = MX-50, B = MY-50, D = 10;
    final Container pan = new Panel();
    double angle = 0; //in radians
    Random r=new Random();
    static int x=0;
    static int y=0;
    int xartis=r.nextInt(30)+5;
    int yartis=r.nextInt(30)+5;
    public int doTick() {
        angle += DELTA; pan.repaint(); 
        return 33;
    }
    public Container container() {
        return pan;
    }
    public String description() {
        return "Bouncing Fabulous Line";
    }
    public String author() {
        return "M Zahid Coban";
    }
   
   class Panel extends javax.swing.JPanel { //drawing
      public void paint(Graphics g) {
          Graphics2D g2 = (Graphics2D) g;
          g2.clearRect(0, 0, 2*MX, 2*MY);

          Color c=new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
          g2.setColor(c);
          g2.setStroke(new BasicStroke(5));
          g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  
          
	  int x2=x+xartis;//r.nextInt(100);
	  int y2=y+yartis;//r.nextInt(100);
          
	  g2.drawLine(x,y,x2,y2);
          if(x2>2*MX){ 
          xartis=-1*(r.nextInt(30)+5);
          }
          else if(y2>2*MY){
          yartis=-1*(r.nextInt(30)+5);
          }
          else if(x2<0){ 
          xartis=(r.nextInt(30)+5);
          }
          else if(y2<0){
          yartis=(r.nextInt(30)+5);
          }
          x=x2;
	  y=y2;
          
          
          
      }
   } 
}
