package animate;

import java.awt.Graphics;
import java.awt.Container;
import java.awt.Font;
import java.awt.Color;
import java.util.Random;

public class HKDanis implements Animator {

    final Container pan = new Panel();
    int counter = 0;

    public int doTick() {
        pan.repaint();
        return 200;
    }

    public Container container() {
        return pan;
    }

    public String description() {
        return "Ekranda random görünen harfler";
    }

    public String author() {
        return "Hatice Kübra Danis";
    }

    class Panel extends javax.swing.JPanel { //drawing

        @Override
        public void paint(Graphics g) {
            g.clearRect(0, 0, 2 * MX, 2 * MY);
            Font font = new Font("Arial", Font.BOLD, 60);
            Random rand = new Random();
            g.setFont(font);
            String s = "HK";
            int a = rand.nextInt(MX);
            int b = rand.nextInt(MY);
            g.setColor(new Color(255));
            g.drawString(s, a, b);

        }
    }
}
