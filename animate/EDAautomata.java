package animate;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.Color;

public class EDAautomata implements Animator {
    final static double DELTA = Math.PI/50;     
    final static int W= MX-40, H= MY-40, P= 15;
    final Container pan = new Panel();
    double angle = 0; //in radians

    public int doTick() {
        angle += DELTA; pan.repaint(); 
        return 100;
    }
    public Container container() {
        return pan;
    }
    public String description() {
        return "odev1";
    }
    public String author() {
        return "Edanur Gur";
    }
   
   class Panel extends javax.swing.JPanel { 
      int counter = 1;
      
	public void paint(Graphics g) {
            if(counter%2 == 1){
		g.setColor(Color.red);
	}

	else{
		g.setColor(Color.black);
	}
          g.clearRect(0, 0, 2*MX, 2*MY);
          double x = MX + W* Math.cos(angle);
          double y = MY + H* Math.sin(angle);
          g.fillRect((int)x, (int)y, P, P);

          double z = MX + W * Math.sin(angle);
          double t= MY + H * Math.sin(angle);
          g.fillRect((int)z, (int)t, P, P);
          
          counter++;
      }
   } 
}
