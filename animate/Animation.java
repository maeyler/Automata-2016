package animate;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Animation implements ActionListener {

    Animator msg;
    final Map<String, Animator> Q = new TreeMap<String, Animator>();
    final JFrame frm = new JFrame("Animator");
    final JPanel bot = new JPanel();
    final JLabel who = new JLabel("JLabel", SwingConstants.CENTER);
    final JTextArea txt = new JTextArea("JTextArea");
    final JTextField ref = new JTextField("JTextField");
    final JComboBox menu;
    String input = "initial text";
    String source = "";

    static final int 
        RESOLUTION = Toolkit.getDefaultToolkit().getScreenResolution(); 
    static final float 
        RES_RATIO = RESOLUTION/96f;  //default resolution is 96
    static final int GAP = scaled(10); //uses RES_RATIO
    static final String PACKAGE = "animate";
    static final Color COLOR = Color.orange;
    static final Font NORM = new Font("SansSerif", 0, scaled(13));
    static final Font BOLD = new Font("SansSerif", 1, scaled(15));
    static final Font MONO = new Font("Monospaced", 0, scaled(12));
    static final Font DLOG = new Font("Dialog", 1, scaled(12));
    
    public Animation() {
        String[] keys = { "no Animator found" };
        if (tryDir(".") || tryDir("BLM305") || tryDir("CSE470")) 
            keys = Q.keySet().toArray(keys);
        menu = new JComboBox(keys);
        if (Q.size() > 0) setItem(0);
        
        JPanel pan = new JPanel();
        pan.setLayout(new BorderLayout(GAP, GAP-4));
        pan.setBorder(new javax.swing.border.EmptyBorder(GAP, GAP, GAP, GAP));
        pan.setBackground(COLOR);

        txt.setFont(MONO);
        txt.setEditable(false);
        txt.setRows(20);
        txt.setColumns(72);
        txt.setWrapStyleWord(true);
        txt.setLineWrap(true);
        txt.setDragEnabled(true);
        pan.add(new JScrollPane(txt), "Center");

        ref.setFont(NORM);
        ref.setEditable(false);
        ref.setColumns(35);
        ref.setDragEnabled(true);
        pan.add(ref, "North");
        
        pan.add(bottomPanel(), "South");

        pan.setToolTipText("Another collective project");
        menu.setToolTipText("Animator classes");
        who.setToolTipText("author()");
        //txt.setToolTipText("output text");
        ref.setToolTipText("description()");

        frm.setContentPane(pan); 
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frm.setLocation(scaled(120), scaled(90));
        frm.pack(); //setSize() is called here
        frm.setVisible(true);
    }
    void addItem(JComponent a, Font f) {
        a.setFont(f); bot.add(a);
    }
    JPanel bottomPanel() {
        bot.setLayout(new BoxLayout(bot, BoxLayout.X_AXIS));
        bot.setBackground(COLOR);
        
        menu.addActionListener(this);
        addItem(menu, DLOG);
        bot.add(Box.createHorizontalStrut(scaled(GAP)));
        bot.add(Box.createHorizontalGlue());
        who.setForeground(Color.black);
        addItem(who, BOLD);
        
        return bot;
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
                Q.put(name, (Animator)c.newInstance());
                System.out.println("  "+name);
            //ClassNotFoundException InstantiationException IllegalAccessException
            } catch(Exception e) { 
                continue;
            }
        }
        return Q.size() > 0;
    }
    public String toString() { return who.getText(); }
    public String message() { return msg.description(source); }
    void setMessage(Animator q) {
        msg = q; 
        who.setText(q.author()); 
        //txt.setText(q.process(input)); 
        ref.setText(q.description(source)); 
    }
    public void setItem(int i) {
        //String m = menu.getItemAt(i); ** Java 7
        int j = menu.getSelectedIndex();
        String m = (String)menu.getItemAt(j); 
        System.out.println(m);
        setMessage(Q.get(m));
    }
    void setItem() {
        setItem(menu.getSelectedIndex());
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu) setItem();
        else System.out.println(e.getSource());
    }

    public static int scaled(int k) { return Math.round(k*RES_RATIO); }
    public static void main(String[] args) { new Animation(); }
}
