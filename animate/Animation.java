package animate;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Animation implements Runnable {

    Animator anim;
    final Map<String, Animator> map = new TreeMap<String, Animator>();
    final JFrame frm = new JFrame("Animator");
    final JPanel pan = new JPanel();
    final JPanel bot = new JPanel();
    final JLabel who = new JLabel("JLabel", SwingConstants.CENTER);
    final JTextField ref = new JTextField("JTextField");
    final JButton stop = new JButton();
    final JComboBox menu;
    Container last;
    Thread T;

    static final int 
        RESOLUTION = Toolkit.getDefaultToolkit().getScreenResolution(); 
    static final float 
        RES_RATIO = RESOLUTION/96f;  //default resolution is 96
    static final int GAP = scaled(10); //uses RES_RATIO
    static final String PACKAGE = "animate";
    static final Color COLOR = Color.CYAN;
    static final Font NORM = new Font("SansSerif", 0, scaled(13));
    static final Font BOLD = new Font("SansSerif", 1, scaled(15));
    static final Font DLOG = new Font("Dialog", 1, scaled(12));
    static final Dimension DIM = new Dimension(2*Animator.MX, 2*Animator.MY);
    
    public Animation() {
        String[] keys = { "no Animator found" };
        if (tryDir(".")) // || tryDir("BLM305") || tryDir("CSE470")) 
            keys = map.keySet().toArray(keys);
        System.out.println(map.size()+" classes loaded");
        menu = new JComboBox(keys);
       
        pan.setLayout(new BorderLayout(GAP, GAP-4));
        pan.setBorder(new javax.swing.border.EmptyBorder(GAP, GAP, GAP, GAP));
        pan.setBackground(COLOR);

        last = new JPanel();
        last.setPreferredSize(DIM);
        pan.add(last, "Center");

        ref.setFont(NORM);
        ref.setEditable(false);
        ref.setColumns(35);
        ref.setDragEnabled(true);
        pan.add(ref, "North");
        
        pan.add(bottomPanel(), "South");

        pan.setToolTipText("A collective project for BLM320");
        menu.setToolTipText("Animator classes");
        who.setToolTipText("author()");
        ref.setToolTipText("description()");
        
        Closer ear = new Closer();
        menu.addActionListener(ear);
        stop.addActionListener(ear);
        frm.addWindowListener(ear);

        if (map.size() > 0) setItem(0);
        frm.setContentPane(pan); 
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frm.setLocation(scaled(120), scaled(90));
        frm.pack(); //setSize() is called here
        frm.setVisible(true); 
        start();
    }
    JPanel bottomPanel() {
        bot.setLayout(new BoxLayout(bot, BoxLayout.X_AXIS));
        bot.setBackground(COLOR);
        
        menu.setFont(DLOG); bot.add(menu);
        bot.add(Box.createHorizontalStrut(scaled(GAP)));
        stop.setFont(DLOG); bot.add(stop);
        bot.add(Box.createHorizontalGlue());
        who.setForeground(Color.black);
        who.setFont(BOLD); bot.add(who);
        
        return bot;
    }
    public void start()  {
        if (T != null) return;
        stop.setText("Stop");
        T = new Thread(this);
        T.start();  //calls run() indirectly
    }
    public void stop()  {
        if (T == null) return;
        stop.setText("Start");
        T = null;
    }
    public void run()  {
        if (Thread.currentThread() != T) 
            throw new Error("do not call directly -- use start()");
        while (T != null) {
             int d = anim.doTick();
             if (d < 50) d = 50;
             if (d > 2000) d = 2000;
             try {
                 Thread.sleep(d);
             } catch (Exception ex) {}
        }
    }
    boolean tryDir(String d) {
        ClassLoader L = getClass().getClassLoader();
        File p = new File(d, PACKAGE);
        System.out.println("Try "+p);
        if (!p.exists() || !p.isDirectory()) return false;
        for (File f : p.listFiles()) {
            String s = f.getName();
            if (!s.endsWith(".class")) continue;
            String name = s.substring(0, s.length()-6);
            try {
                Class<?> c = L.loadClass(PACKAGE+"."+name);
                if (!Animator.class.isAssignableFrom(c)) continue;
                Animator a = (Animator)c.newInstance();
                a.container().setPreferredSize(DIM);
                map.put(name, a);
                System.out.println("  "+name);
            //ClassNotFoundException InstantiationException IllegalAccessException
            } catch(Exception e) { 
                continue;
            }
        }
        return map.size() > 0;
    }
    public String toString() { return who.getText(); }
    public String message() { return anim.description(); }
    void setMessage(Animator a) {
        anim = a; 
        who.setText(a.author()); 
        ref.setText(a.description());
        pan.remove(last); last = a.container();
        pan.add(last, "Center");
        if (T != null) T.interrupt();
    }
    public void setItem(int i) {
        String m = (String)menu.getItemAt(i); 
        System.out.println(m);
        setMessage(map.get(m));
    }
    void setItem() {
        setItem(menu.getSelectedIndex());
    }

    class Closer extends WindowAdapter implements ActionListener {
        public void windowClosing(WindowEvent e) { stop(); } //stops the Thread
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == menu) setItem();
            //else if (e.getSource() == stop) startOrStop();
            else if (T == null) start(); else stop();
        }
    }
    public static int scaled(int k) { return Math.round(k*RES_RATIO); }
    public static void main(String[] args) { new Animation(); }
}
