package animate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.Font;
import java.util.Random;

public class barbaroskaradag implements Animator {
    int x = 10;
    int[] sayi = {10,10,10,10,10};
    int[] sonuc = {0,0,0,0,0};
    String ad [] = {"Ahmet","Ali","Mehmet","Okan","Mahmut"};
    Random rnd = new Random();
    final Container pan = new Panel();
    String kazanan = "yok";
    
    public int doTick() {
        
        pan.repaint();         
        return 100;
    }
    public Container container() {
        pan.setBackground(Color.WHITE);
        return pan;
    }
    public String description() {
        return "Yaris yapan kutular";
    }
    public String author() {
        return "Barbaros H. KARADAG";
    }
    public void sonuclar(Graphics g,Font f)
    {
        f = new Font ("Arial", 1, 10);
        g.setColor(Color.DARK_GRAY);
        g.setFont(f);
        g.drawString("Sonuclar   :  "+ad[0]+" : "+sonuc[0]+" | "+
                ad[1]+" : "+sonuc[1]+" | "+
                ad[2]+" : "+sonuc[2]+" | "+
                ad[3]+" : "+sonuc[3]+" | "+
                ad[4]+" : "+sonuc[4]
                , 10, pan.getHeight()-20);
    }
   
   class Panel extends javax.swing.JPanel { //drawing
      public void paintComponent(Graphics g)
	    {
		super.paintComponent(g);
                
                
                Font myFont = new Font ("Arial", 1, 15);
                g.setFont(myFont);
                int deger = 0,durum = 20;
                
		g.setColor(Color.cyan);
                deger = rnd.nextInt(durum);
                sayi[0] += deger;
                g.drawString(ad[0], sayi[0]+20, 75);
		g.fillRect(10,40,sayi[0],60);


		g.setColor(Color.red);
                deger = rnd.nextInt(durum);
                sayi[1] += deger;
                g.drawString(ad[1], sayi[1]+20, 145);
		g.fillRect(10,110,sayi[1],60);

		g.setColor(Color.green);
                deger = rnd.nextInt(durum);
                sayi[2] += deger;
                g.drawString(ad[2], sayi[2]+20, 215);
		g.fillRect(10,180,sayi[2],60);

		g.setColor(Color.blue);
                deger = rnd.nextInt(durum);
                sayi[3] += deger;
                g.drawString(ad[3], sayi[3]+20, 285);
		g.fillRect(10,250,sayi[3],60);

		g.setColor(Color.yellow);
                deger = rnd.nextInt(durum);
                sayi[4] += deger;
                g.drawString(ad[4], sayi[4]+20, 355);
		g.fillRect(10,320,sayi[4],60);
                
                sonuclar(g,myFont);
                
                boolean sifirla = false;
                g.setColor(Color.black);
                myFont = new Font ("Arial", 1, 10);
                g.setFont(myFont);
                g.drawString("Kazanan : "+kazanan, pan.getWidth()-150, pan.getHeight()-20);
                for (int i = 0; i < sayi.length; i++) {
                    
                    if(sayi[i] > pan.getWidth()-100)
                    {
                        kazanan = ad[i]; sonuc[i]++;
                        g.drawString("Kazanan : "+kazanan, pan.getWidth()-150, pan.getHeight()-20);
                        sifirla = true;
                        break;
                    }
                    
                }
                if(sifirla)
                {
                    for (int i = 0; i < sayi.length; i++) {
                        sayi[i] = 10;   
                    }
                }

	    }
   } 
}
