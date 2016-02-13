package animate;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.Rectangle;
import java.util.Random;
import javafx.scene.layout.Background;
import java.awt.Color;

public class Muhammet_Emre_Akarsu implements Animator {

    final static double DELTA = Math.PI / 50; //one turn = 100 ticks 
    final static int A = MX - 50, B = MY - 50, D = 10;
    final Container pan = new Panel();
    double angle = 0; //in radians

    public Rectangle rectangle = new Rectangle(25, 50, 25, 50);

    public int doTick() {
        angle += DELTA;
        pan.repaint();

        return 100;
    }

    public Container container() {
        return pan;
    }

    public String description() {
        return "Rectangle orbit of a planet";
    }

    public String author() {
        return "Muhammet Emre Akarsu";
    }

    class Panel extends javax.swing.JPanel { //drawing

        public void paint(Graphics g) {
            Random r = new Random();
            Color clr;
            int a = 0;
            a = r.nextInt(255) + 10;
            clr = clr = new Color(a, a - 10, (a + 128) % 255);
            g.clearRect(0, 0, 2 * MX, 2 * MY);
            double x = MX + A * Math.cos(angle);
            double y = MY + B * Math.sin(angle);
            g.fillRect((int) x, (int) y, D + 10, D + 10);
            g.setColor(clr);
            g.drawString("Muhammet Emre Akarsu", (int) x, (int) y);
        }
    }
}
