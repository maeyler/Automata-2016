package animate;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;
import java.applet.Applet;
import java.awt.*;

public class MovingSquare implements Animator {
    final Container pan = new Panel();
    double angle = 0;
    double x = 0;
    double y = 0;
    
    public int doTick() {
	   pan.repaint(); 
        return 100;
    }
    public Container container() {
        return pan;
    }
    public String description() {
        return "Moving Square";
    }
    public String author() {
        return "Ismail AKICI";
    }

    
   class Panel extends Applet {
	   boolean right = true;
	   boolean bottom = true;
	   double width = 20;
	   double height = 20;
      public void paint(Graphics g) {          
          if(x >= 0 && x < 360 && right) {
        	  x = x + 40;
        	  width = width + 10;
        	  height = height + 10;
        	  
        	  bottom = true;
          } else if(y >= 0 && y < 360 && bottom) {
        	  y = y + 40;
        	  right = false;
        	  
        	  width = width - 10;
        	  height = height - 10;
          } else if(x > 0 && x <= 360 && !right) {
        	  x = x - 40;
        	  bottom = false;
        	  
        	  width = width + 10;
        	  height = height + 10;
          } else if(y > 0 && y <= 360 && !bottom) {
        	  y = y - 40;
        	  
        	  if(y == 0)
        		  right = true;
        	  
        	  width = width - 10;
        	  height = height - 10;
          }
          
          g.setColor(Color.BLUE);
          g.fillRect((int)x, (int)y, (int)width, (int)height);
          
      }
   } 
}