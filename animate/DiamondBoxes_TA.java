package animate;

import java.awt.Container;
import java.awt.Graphics;

public class DiamondBoxes_TA implements Animator {

    static int a = 0, b = 400;
    final Container pan = new Panel();

    public int doTick() {
        pan.repaint();
        a++;
        return 100;
    }

    public Container container() {
        return pan;
    }

    public String description() {
        return "Diamond Boxes";
    }

    public String author() {
        return "Tugba AY";
    }

    class Panel extends javax.swing.JPanel {

        public void paint(Graphics g) {
            g.clearRect(0, 0, 2 * MX, 2 * MY);
            if (a == 2) {
                g.drawLine(0, 0, b, 0);
                g.drawLine(b, 0, b, b);
                g.drawLine(0, b, b, b);
                g.drawLine(0, 0, 0, b);
            } else if (a == 4) {
                g.drawLine(b / 2, 0, b, b / 2);
                g.drawLine(b, b / 2, b / 2, b);
                g.drawLine(0, b / 2, b / 2, b);
                g.drawLine(b / 2, 0, 0, b / 2);
            } else if (a == 6) {
                g.drawLine(b / 4, b / 4, b / 4 * 3, b / 4);
                g.drawLine(b / 4 * 3, b / 4, b / 4 * 3, b / 4 * 3);
                g.drawLine(b / 4, b / 4 * 3, b / 4 * 3, b / 4 * 3);
                g.drawLine(b / 4, b / 4, b / 4, b / 4 * 3);
            } else if (a == 8) {
                g.drawLine(b / 2, b / 4, b / 4 * 3, b / 2);
                g.drawLine(b / 4 * 3, b / 2, b / 2, b / 4 * 3);
                g.drawLine(b / 4, b / 2, b / 2, b / 4 * 3);
                g.drawLine(b / 4, b / 2, b / 2, b / 4);
            } else if (a == 10) {

                g.drawLine(b / 8 * 3, b / 8 * 3, b / 8 * 5, b / 8 * 3);
                g.drawLine(b / 8 * 5, b / 8 * 3, b / 8 * 5, b / 8 * 5);
                g.drawLine(b / 8 * 3, b / 8 * 5, b / 8 * 5, b / 8 * 5);
                g.drawLine(b / 8 * 3, b / 8 * 3, b / 8 * 3, b / 8 * 5);
                if(a==10){
                    a=1;
                }
            }
        }

    }

}
