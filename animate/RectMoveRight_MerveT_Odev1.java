package animate;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;

public class RectMoveRight_MerveT_Odev1 implements Animator {
    final Container pan = new Panel();
    int kare_x=0, kare_y=0, r=20;
    
    public int doTick() {
       kare_x+=10; 
       pan.repaint();
       return 100;
    }
    public Container container() {
        return pan;
    }
    public String description() {
        return "Dikdörtgenin saða doðru ilerleme hareketi";
    }
    public String author() {
        return "Merve Týrýs";
    }
   
   class Panel extends javax.swing.JPanel { 
      public void paint(Graphics g) {
          g.clearRect(0,0,this.getSize().width, this.getSize().height);
          g.drawRect(kare_x,kare_y,r,r);
          g.fillRect(kare_x,kare_y,r,r);
      }
   } 
}
