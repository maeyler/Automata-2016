import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JFrame;

class Canvas extends JPanel {

  public Canvas() {
    JFrame frm = new JFrame();
    frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frm.setContentPane(this); frm.setTitle("Canvas");
    frm.setSize(700, 600); frm.setVisible(true);
  }
  public void paint(Graphics g) {
    Color c1 = new Color(210, 60, 0);
    g.setColor(c1);
    g.fillOval(260, 60, 200, 200);
    Color c2 = new Color(30, 190, 30);
    g.setColor(c2);
    g.fillOval(260, 80, 200, 160);
    g.setColor(Color.CYAN);
    g.fillOval(260, 100, 200, 120);
    Font f = new Font("Serif", 1, 50);
    g.setFont(f); g.setColor(Color.BLACK);
    g.drawString("Colored ovals", 220, 350);
  }
  public static void main(String[] a) {
    new Canvas();
  }
}
