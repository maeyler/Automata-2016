package animate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.util.Random;

public class mahmut implements Animator {
    private static int DELAY = 90;
Insets insets;
 
  Color colors[] = { Color.PINK, Color.YELLOW, Color.GREEN, Color.RED,
      Color.BLUE, Color.CYAN };
  final Container pan = new Panel();
    
    public int doTick() {
        
        Color color = colors[0];
        synchronized (colors) {
          System.arraycopy(colors, 1, colors, 0, colors.length - 1);
          colors[colors.length - 1] = color;
        }
        pan.repaint();        
        return 100;
    }
    public Container container() {
        pan.setBackground(Color.WHITE);
        return pan;
    }
    public String description() {
        return "Renkli Görüntüler";
    }
    public String author() {
        return "Mahmut Kasým";
    }
    
   class Panel extends javax.swing.JPanel { //drawing
       public void paint(Graphics graphics) {
    super.paint(graphics);
    if (insets == null) {
      insets = getInsets();
    }
  int steps=colors.length;
    int x = insets.left;
    int y = insets.top;
    int width = getWidth() - insets.left - insets.right;
    int height = getHeight() - insets.top - insets.bottom;
   
    synchronized (colors) {
      for (int i = 0; i < steps; i++) {
        graphics.setColor(colors[i]);
        graphics.fillRect(x, y, width, height);
      }
    }
  }
   
   }
}
