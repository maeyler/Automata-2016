package animate;

import java.awt.Dimension;
import java.awt.Container;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class NurdanAlbas implements Animator {
    final static double DELTA = Math.PI/50; //one turn = 100 ticks 
    final static int A = MX-50, B = MY-50, D = 10;
    final Container pan = new Panel();
    double angle = 0; //in radians
    Color startColor = Color.DARK_GRAY;  
    Color endColor = Color.WHITE;        
    Color currentColor = startColor;
    int animationDuration = 2000;   
    long animStartTime;   


    public int doTick() {
	long currentTime = System.nanoTime() / 1000000;
        long totalTime = currentTime - animStartTime; 
        if (totalTime > animationDuration) {
            animStartTime = currentTime;
        }
        float fraction = (float)totalTime / animationDuration;
        
	fraction = Math.min(1.0f, fraction);
        int red = (int)(fraction * endColor.getRed() + 
                (1 - fraction) * startColor.getRed());
        int green = (int)(fraction * endColor.getGreen() + 
                (1 - fraction) * startColor.getGreen());
        int blue = (int)(fraction * endColor.getBlue() + 
                (1 - fraction) * startColor.getBlue());       
        currentColor = new Color(red, green, blue);      
        pan.repaint(); 
        return 200;
    }
    public Container container() {
        return pan;
    }
    public String description() {
        return "Colour Fading";
    }
    public String author() {
        return "Nurdan Albaş";
    }
   
   class Panel extends javax.swing.JPanel { //drawing
      public void paint(Graphics g) {
          g.clearRect(0, 0, 2*MX, 2*MY);
          g.setColor(getBackground());
          g.fillRect(0, 0, getWidth(), getHeight());
          g.setColor(currentColor);
          g.fillOval(0, 0, getWidth(), getHeight());
      }
   } 
}
