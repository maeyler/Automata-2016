import java.io.*;

class Copier {
    public Copier(String dir, String name) throws IOException {
        File f = new File(dir, name); 
        InputStream in = new FileInputStream(f);
        int n = in.available();
        byte[] ba = new byte[n];
        in.read(ba); 
        in.close(); 
        File g = new File(dir, "Copy of "+name);
        OutputStream out = new FileOutputStream(g);
        out.write(ba);
        out.close();
        System.out.println(f);
        System.out.println(n+" bytes copied");
    }
    public static void main(String[] args) throws IOException {
        new Copier(System.getProperty("user.dir"), "README.md");
    }
}
