package animate;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.Font;
import java.awt.Color;

public class FerdiKiziltoprak implements Animator {
    
    final Container pan = new Panel();
    int counter = 0;

    public int doTick() {
        counter += 1;
        if (counter > author().length()+2) {
            counter = 0;
        }
        pan.repaint();
        return 200;
    }

    public Container container() {
        return pan;
    }

    public String description() {
        return "A signboard that animates author name";
    }

    public String author() {
        return "Ferdi Kızıltoprak";
    }
    
    class Panel extends javax.swing.JPanel { //drawing
        @Override
        public void paint(Graphics g) {
            g.clearRect(0, 0, 2*MX, 2*MY);
            Font font = new Font("Arial",Font.BOLD,60);
            g.setFont(font);
            int step = counter*5;
            g.setColor(new Color(45+step,131+step,206-step));
            if (counter < author().length()) {
                g.drawString(author().substring(counter, counter+1), (MX-(author().length()/2)*30)+(counter*30), MY);
            } else{
                g.drawString(author(), (MX-(author().length()/2)*30), MY);
            }
            
        }
    }
}
