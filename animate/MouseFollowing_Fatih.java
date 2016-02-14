package animate;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;

public class MouseFollowing_Fatih implements Animator {

Point p = new Point(100,100);
final Container pan = new Panel();

    @Override
    public int doTick() {
        p = MouseInfo.getPointerInfo().getLocation();
        pan.repaint();
        return 50;
    }

    @Override
    public Container container() {
        return pan;
    }

    @Override
    public String description() {
        return "A circle following mouse pointer";
    }

    @Override
    public String author() {
        return "Fatih Barmanbay";
    }
    
    
   class Panel extends javax.swing.JPanel { //drawing
      public void paint(Graphics g) {
            g.clearRect(0, 0, 2*MX, 2*MY);
            g.setColor(Color.RED);
            g.fillOval(p.x-150, p.y-150, 30, 30);
            g.dispose();
      }
   } 
}
