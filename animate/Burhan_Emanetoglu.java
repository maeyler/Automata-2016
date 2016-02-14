package animate;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;

public class Burhan_Emanetoglu implements Animator {

	Point lab = new Point(25,255);
	final Container pan = new Panel();
	int counter = 0;

    public int doTick() {
       if (counter < 40) {
            lab.setLocation(lab.getX() + 5, lab.getY() + 5);
            counter++;
        } else if (counter < 80) {
            lab.setLocation(lab.getX() + 5, lab.getY() - 5);
            counter++;
        } else if ( counter < 120) {
            lab.setLocation(lab.getX() - 5, lab.getY() - 5);
            counter++;
        } else if (counter < 160) {
            lab.setLocation(lab.getX() - 5, lab.getY() + 5);
            counter++;
        }else{
            counter = 0;
        }	
        pan.repaint();
        return 10;
    }

    public Container container() {
        return pan;
    }

    public String description() {
        return "Rectangle Moves";
    }

    public String author() {
        return "Burhan Emanetoglu";
    }
    
    
   class Panel extends javax.swing.JPanel { //drawing
      public void paint(Graphics g) {
            g.clearRect(0, 0, 2*MX, 2*MY);
            g.setColor(Color.DARK_GRAY);
            g.fillOval(lab.x,lab.y,10,10);
            }
   } 
}
