package animate;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.*;

public class ColorfulRect_BK implements Animator {
    final static double DELTA = Math.PI/50; 
    Color [] colorList = {Color.red, Color.green, Color.blue,
                        Color.magenta, Color.cyan, Color.pink,
                        Color.orange};
    int colorIndex = 0; 
    final static int A = MX-50, B = MY-50, D = 30;
    final Container pan = new Panel();
    double angle = 0;

    public int doTick() {
        angle += DELTA; 
	   pan.repaint(); 
        return 100;
    }
    public Container container() {
        return pan;
    }
    public String description() {
        return "Elliptic orbit of a colorful rect";
    }
    public String author() {
        return "Beyza Nur Karabul";
    }
   
   class Panel extends javax.swing.JPanel {
      public void paint(Graphics g) {
          if (colorIndex == colorList.length)
             colorIndex = 0;
          g.clearRect(0, 0, 2*MX, 2*MY);
          double x = MX + A * Math.cos(angle);
          double y = MY + B * Math.sin(angle);
          g.setColor(colorList[colorIndex++]);
          g.fillRect((int)x, (int)y, D, D);
      }
   } 
}

