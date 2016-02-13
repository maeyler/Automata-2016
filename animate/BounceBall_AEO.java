package animate;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;
import java.util.Timer;
import java.util.TimerTask;

public class BounceBall_AEO implements Animator {
    Timer timer;
    int xball=10;
    int yball=10;
    int v_xball=2;
    int v_yball=2;
    
    final Container pan = new Panel();
    
    public int doTick() {
        xball=xball +v_xball;
        yball=yball + v_yball;
        if(xball>=600){
            v_xball=-v_xball;
        }
        if(xball<=0){
            v_xball=-v_xball;
        }
        if(yball>=450){
            v_yball=-v_yball;
        }
        if(yball<=0){
            v_yball=-v_yball;
        }
        
        pan.repaint();
        return 50;
    }
    public Container container() {
        return pan;
    }
    public String description() {
        return "Bounce Ball";
    }
    public String author() {
        return "Ahmet Emir Ozturk";
    }
   
   class Panel extends javax.swing.JPanel { //drawing
      public void paint(Graphics g) {
          g.clearRect(0, 0, 2*MX, 2*MY);
          g.fillOval((int)xball, (int)yball, 20, 20);
          
      }
   } 
}
