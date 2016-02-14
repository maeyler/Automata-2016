package animate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.Font;

public class ahmetyazici implements Animator {
    final Container pan = new Panel();
    public int x = 10;
    boolean durum = true;
    int count = -1;
    String yaziisimler [] = {"Ahmet Yazici","I like JAVA","FSMVU - Computer Enginering"};
    Color[] renk = {Color.cyan,Color.RED,Color.blue};
    public int doTick() {
        
          if(durum)
          {
            x+=20;
            if(x > pan.getHeight()-10)
            {
                durum = false;
            }
          }
          else
          {
              x-=20;
            if(x < 10)
            {
                  durum = true;
                  count++;
                    if(count%3 == 0)
                        count = 0;
            }
          }
          pan.repaint();
        return 50;
    }
    public Container container() {
        return pan;
    }
    public String description() {
        return "Yazi Animasyonu";
    }
    public String author() {
        return "Ahmet YAZICI";
    }
   
   class Panel extends javax.swing.JPanel { //drawing
      public void paintComponent(Graphics g) {
          super.paintComponent(g);
                Font f = new Font("Arial Black", 1, 22);
                g.setFont(f);
                g.drawString(yaziisimler[count], 10, (pan.getHeight()-10)/2);
		g.setColor(renk[count]);
		g.fillRect(0,0,pan.getWidth(),pan.getHeight()-x);
                
      }
   } 
}
