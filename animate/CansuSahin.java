package animate;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;
import java.util.Random;
import java.awt.Font;
import java.awt.Color;

public class CansuSahin implements Animator {
    
    int topx=250;
    int topy=250;
    int xhiz=15;
    int yhiz=15;
    int pixelSayisi = 0;
    int topOncekix = 0;
    int topOncekiy = 0;
    int kontrol = 0;
    
    final Container pan = new Panel();
    
    public int doTick() {
        
        topx=topx + xhiz;
        topy=topy + yhiz;
        if(topx>=600){
            xhiz=-xhiz;
        }
        if(topx<=0){
            xhiz=-xhiz;
        }
        if(topy>=450){
            yhiz=-yhiz;
        }
        if(topy<=0){
            yhiz=-yhiz;
        }
        
        pan.repaint();
        return 100;
    }
    public Container container() {
        return pan;
    }
    public String description() {
        return "Ball Distance Meter";
    }
    public String author() {
        return "Cansu Kübra Þahin";
    }
   
   class Panel extends javax.swing.JPanel { //drawing
      public void paint(Graphics g) {
         
        g.clearRect(0, 0, 2*MX, 2*MY);
        super.paintComponent(g);
        Font f = new Font ("Times New Roman", 1, 15);
        g.setColor(Color.BLACK);
        g.setFont(f);
        g.drawString("Topun Kat Ettiði Pixel Sayýsý = " + pixelSayisi,10,450);
        g.fillOval(topx,topy, 20, 20);
        if(kontrol == 0){
            pixelSayisi = pixelSayisi + Math.abs(topx - 250) + Math.abs(topy - 250);
            kontrol = 1;
        }else{
            pixelSayisi = pixelSayisi + Math.abs(topx - topOncekix) + Math.abs(topy - topOncekiy);
        }
        topOncekix = topx;
        topOncekiy = topy;
        
      }
   } 
}
