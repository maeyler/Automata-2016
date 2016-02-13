package animate;

import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Container;

public class BufferedAnimation implements Animator 
{
	private static int DELAY = 100;
    private int x,y,width,height,start,steps,stepSize;
    private Insets insets;
    private Color colors[] = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
        Color.BLUE, Color.MAGENTA };
    
    final Container pan = new Panel();

    public int doTick() 
    {
        Color c = colors[0];
        synchronized (colors) 
        {
          System.arraycopy(colors, 1, colors, 0, colors.length - 1);
          colors[colors.length - 1] = c;
        }
        pan.repaint();
        
        return DELAY;
    }
    
    public Container container() 
    {
        return pan;
    }
    
    public String description() 
    {
        return "Buffered Animation";
    }
    public String author() 
    {
        return "Ismail AKICI";
    }
   
   class Panel extends javax.swing.JPanel //drawing
   { 
      public void paint(Graphics g) 
      {
	    super.paint(g);
	    if (insets == null) {
	      insets = getInsets();
	    }
	    // Calculate each time in case of resize
	    x = insets.left;
	    y = insets.top;
	    width = getWidth() - insets.left - insets.right;
	    height = getHeight() - insets.top - insets.bottom;
	    start = 0;
	    steps = colors.length;
	    stepSize = 360 / steps;
	    synchronized (colors) 
	    {
	      for (int i = 0; i < steps; i++) 
	      {
	        g.setColor(colors[i]);
	        g.fillArc(x, y, width, height, start, stepSize);
	        start += stepSize;
	      }
	    }
      }
   } 
}
