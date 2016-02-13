package animate;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;



public class Motion_EA implements Animator {
    final static double DELTA = Math.PI/50; //one turn = 100 ticks 
    final static int A = MX-50, B = MY-50, D = 50;
    final Container pan = new Panel();
    double angle = 0; //in radians

  Image buffer;

  Dimension oldSize;

  Insets insets;

  Color colors[] = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
      Color.BLUE, Color.MAGENTA };
   
    public int doTick() {
        angle += DELTA; pan.repaint(); 
         
        return 500;
       
    }
    public Container container() {
        return pan;
    }
    public String description() {
        return "wheel of fortune - 180 degree";
    }
    public String author() {
        return "Emre Aydin";
    }
   
   class Panel extends javax.swing.JPanel { //drawing
      public void paint(Graphics g) {
 if ((oldSize == null) || (oldSize != getSize())) {
      oldSize = getSize();
      buffer = new BufferedImage(getWidth(), getHeight(),
          BufferedImage.TYPE_INT_RGB);
    }
    if (insets == null) {
      insets = getInsets();
    }
    // Calculate each time in case of resize
    int x = insets.left;
    int y = insets.top;
    int width = getWidth()- insets.left - insets.right ;
    int height = getHeight() - insets.top - insets.bottom;
    int start = 0;
    int steps = colors.length;
    int stepSize = 180 / steps;
    synchronized (colors) {
      Graphics bufferG = buffer.getGraphics();
      bufferG.setColor(Color.WHITE);
      bufferG.fillRect(x, y, width, height);
      for (int i = 0; i < steps; i++) {
        bufferG.setColor(colors[i]);
        bufferG.fillArc(x, y, width, height, start, stepSize);
        start += stepSize;
      }
    }
   
   
    g.drawImage(buffer, 0, 0, this);
    
    Color c = colors[0];
        synchronized (colors) {
          System.arraycopy(colors, 1, colors, 0, colors.length - 1);
          colors[colors.length - 1] = c;
        }
      }   
      
   } 
}
