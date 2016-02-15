package animate;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.Color;

public class HeartBeats_AhmetK implements Animator {
    static int counter=0;
    final Container pan = new Panel();

    public int doTick() {
	counter++;
	pan.repaint();
        return 600;
    }
    public Container container() {
        return pan;
    }
    public String description() {
        return "Heart Beats";
    }
    public String author() {
        return "Ahmet Kaymak";
    }
   
   class Panel extends javax.swing.JPanel { //drawing
      public void paint(Graphics g) {
	g.clearRect(0, 0, 2*MX, 2*MY);
        int xcenter = (int) (this.getWidth() / 2);
        int ycenter = (int) (this.getHeight() / 2);
	int mul=counter%2+1;
        g.setColor(Color.red);
        g.fillArc(xcenter-(100*mul), ycenter-(100*mul), 100*mul, 100*mul, 0, 200);
        g.fillArc(xcenter, ycenter-(100*mul), 100*mul, 100*mul, -20, 200);
        int[] x = {xcenter-(50*mul), xcenter-(100*mul-5), xcenter, xcenter+(100*mul),xcenter+(50*mul)};
        int[] y = {ycenter-(50*mul), ycenter-(35*mul), ycenter+(100*mul), ycenter-(35*mul),ycenter-(50*mul)};
        g.fillPolygon(x, y, 5);
      }
   } 
}
