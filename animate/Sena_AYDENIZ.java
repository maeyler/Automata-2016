package animate;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Container;

public class Sena_AYDENIZ implements Animator {
	final Applet pan = new Panel();
	int x = 150, y = 50, r = 50;
	int dx = 11, dy = 7;
	Thread animator; 
	volatile boolean pleaseStop; 
    public int doTick() {
        pan.repaint();

        return 100;
    }
    public Container container() {
        return pan;
    }
    public String description() {
        return "Bouncing Circle";
    }
    public String author() {
        return "Sena AYDENIZ ";
    }
   
   @SuppressWarnings("serial")
   class Panel extends Applet { //drawing
      public void paint(Graphics g) {
		    Rectangle bounds = getBounds();
		    if ((x - r + dx < 0) || (x + r + dx > bounds.width))
		      dx = -dx;
		    if ((y - r + dy < 0) || (y + r + dy > bounds.height))
		      dy = -dy;

		    x += dx;
		    y += dy;
		    
    	    g.setColor(Color.red);
    	    g.fillOval(x - r, y - r, r * 2, r * 2);
      }
   } 
}
