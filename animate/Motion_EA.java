package animate;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.Rectangle;
import java.util.Random;
import javafx.scene.layout.Background;
import java.awt.Color;

public class Motion_EA implements Animator {
    final static double DELTA = Math.PI/50; //one turn = 100 ticks 
    final static int A = MX-50, B = MY-50, D = 50;
    final Container pan = new Panel();
    double angle = 0; //in radians

    int x=0,y=250;

    public int doTick() {
        pan.repaint(); 
         
        return 80;
       
    }
    public Container container() {
        return pan;
    }
    public String description() {
        return " Renkli Kayan Yazi";
    }
    public String author() {
        return "Emre Aydin";
    }
   
   class Panel extends javax.swing.JPanel { //drawing
      public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2=(Graphics2D)g;
        Font font = new Font("Tahoma",Font.BOLD+Font.PLAIN,27);
          g2.setFont(font);
          g.clearRect(0, 0, 2*MX, 2*MY);
        if(x<100){  
        g2.setColor(Color.red);
        
        }
        else if(x<200){
        g2.setColor(Color.orange);
        
        }
        else if(x<300){
        g2.setColor(Color.blue);
        
         
        
        }
        else if(x<400){
        g2.setColor(Color.black);
        }
        else{
        g2.setColor(Color.yellow);
        }
        
        g2.drawString("Fatih Sultan Mehmet Vakif Universitesi",x,y);
        
      
        
        x+=10;
        if(x>this.getWidth()-200)
        {
        x=0;
        }
         
        
        
       
        
        
        
      }
      
   } 
}
