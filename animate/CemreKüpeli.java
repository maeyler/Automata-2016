package animate;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;
import java.util.Random;
import java.awt.Font;
import java.awt.Color;

public class CemreKüpeli implements Animator {
    
    int top1=10;
    int top2=250;
    int topHiz1=0;
    int topHiz2=0;
    int golSayisi = 0;
    int autSayisi = 0;
    int direkSayisi = 0;
    
    final Container pan = new Panel();
    
    public int doTick() {
        
        Random r1 = new Random();
        int topHiz1 = r1.nextInt(30);
        int topHiz2 = r1.nextInt(30) - 15;
        
        top1=top1 + topHiz1;
        top2=top2 + topHiz2;
        
        if(top1>=625){
            if(top2 > 180 && top2 < 280){
                golSayisi++;
            }else if(top2 == 180 || top2 == 280){
                direkSayisi++;
            }
            else{
                autSayisi++;
            }
            top1 = 10;
            top2 = 225;
        }
        if(top2>=450){
            autSayisi++;
            top1 = 10;
            top2 = 225;
        }
        if(top2<=0){
            autSayisi++;
            top1 = 10;
            top2 = 225;
        }
        
        pan.repaint();
        return 50;
    }
    public Container container() {
        return pan;
    }
    public String description() {
        return "Football";
    }
    public String author() {
        return "Cemre Mehmet Küpeli";
    }
   
   class Panel extends javax.swing.JPanel { //drawing
      public void paint(Graphics g) {
         
        g.clearRect(0, 0, 2*MX, 2*MY);
        
        super.paintComponent(g);
        Font f = new Font ("Nyala", 1, 15);
        g.setColor(Color.BLUE);
        g.setFont(f);
        g.drawString("Gol Sayýsý = " + golSayisi + "    Aut Sayýsý = " + autSayisi + "    Direk Sayýsý = " + direkSayisi ,10,450);
        g.drawLine(625, 175 , 625 , 275);
        g.fillOval(top1,top2, 20, 20);
          
      }
   } 
}
