package animate;

import java.awt.Container;
import java.awt.Graphics;

public class Sandglass_ECG implements Animator {

    static int i = 0, j = 20;
    final Container pan = new Panel();

    public int doTick() {
        pan.repaint();
        return 50;
    }

    public Container container() {
        return pan;
    }

    public String description() {
        return "A simple sandglass";
    }

    public String author() {
        return "Erdem Cagri GORUCU";
    }

    class Panel extends javax.swing.JPanel { 
  
        public void paint(Graphics g) {
            g.clearRect(0, 0, 2 * MX, 2 * MY);
            int a = 20, n = a * 10 * 2;
            if (i < 20) {
                
                g.drawLine(10 * i, 10 + 10 * i, n - 10 * i, 10 + 10 * i);
                i++;
            }
            else if (j>=0) {
                j--;
                g.drawLine(10 + 10 * j, n - 10 * j, n - 10 * j, n - 10 * j);
                
                if(j == 0){
                    i=0;
                    j=20;
                }
            }

        }
    }

}
