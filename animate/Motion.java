import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Motion extends Animation {
   final static int M = 300, A = 200, B = 150, D = 10;
   final static double DELTA = PI/50; //one turn = 100 ticks 
   Panel pan = new Panel();
   double angle = 0; //in radians
   public Motion() {
      pan.setPreferredSize(new Dimension(2*M, 2*M));
      makeGUI(pan);
   }
   String title() {
       return "Motion";
   }
   void doTick() { //called on every tick
      angle += DELTA; pan.repaint();
   }
   
   class Panel extends JPanel { //drawing
      public void paint(Graphics g) {
          //g.clearRect(0, 0, 2*M, 2*M);
          double x = M + A * Math.cos(angle);
          double y = M + B * Math.sin(angle);
          g.fillOval((int)x, (int)y, D, D);
      }
   }   public static void main(String[] args) {
      new Motion().start(100);  
   }
}
