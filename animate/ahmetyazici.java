package animate;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.Color;
import java.awt.Insets;

public class ahmetyazici implements Animator {
   Insets insets;
    Color colors[] = { Color.RED, Color.ORANGE, Color.BLACK, Color.GREEN,
      Color.BLUE, Color.MAGENTA };
          final Container pan = new Panel();
  

    public int doTick() {
        
        Color c = colors[0];
        synchronized (colors) {
          System.arraycopy(colors, 1, colors, 0, colors.length - 1);
          colors[colors.length - 1] = c;
        }
        pan.repaint();
        
        
        
        return 500;
    }
    public Container container() {
        return pan;
    }
    public String description() {
        return "Renkli Çarkıfelek";
    }
    public String author() {
        return "Ahmet YAZICI";
    }
   
   class Panel extends javax.swing.JPanel { //drawing
      public void paint(Graphics g) {
    super.paint(g);
    if (insets == null) {
      insets = getInsets();
    }
    // Calculate each time in case of resize
    int x = insets.left;
    int y = insets.top;
    int width = getWidth() - insets.left - insets.right;
    int height = getHeight() - insets.top - insets.bottom;
    int start = 0;
    int steps = colors.length;
    int stepSize = 360 / steps;
    synchronized (colors) {
      for (int i = 0; i < steps; i++) {
        g.setColor(colors[i]);
        g.fillArc(x, y, width, height, start, stepSize);
        start += stepSize;
      }
    }
  }
   } 
}
