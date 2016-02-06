// Author: Eyler -- Oct 2012
// iterates over all files within a given folder

import java.io.File;
import java.io.PrintStream;
import java.io.IOException;

public class FileCrawler implements Runnable {

    public int fil, dir;
    public File path;
    long time;
    Thread T;
   
    public FileCrawler() { this("."); }
    public FileCrawler(String fn) { this(new File(fn)); }
    public FileCrawler(File f) {
	try {
            path = f.getCanonicalFile();
	} catch (IOException e)  {
	    path = f.getAbsoluteFile();;
	}
    }
    public void start()  {
        if (T != null) return;
        fil = 0; dir = 0; 
        T = new Thread(this);
        T.start();
    }
    public void run()  {
        if (Thread.currentThread() != T) 
            throw new Error("do not call directly -- use start()");
	time = System.currentTimeMillis();
        crawl(path);  //may take a long time
        time = System.currentTimeMillis() - time;
        report(); T = null;
    }
    void crawl(File d) {
        if (d.isDirectory()) { //continue recursion
            File[] a = d.listFiles();
            if (a == null || a.length == 0) return;
            doFolder(d, a);
            for (File f: a) crawl(f);
        } else {
            doFile(d);
        }
    }
    void doFile(File f)  {  //override for actual work
        fil++; 
    }
    void doFolder(File d, File[] a)  {
        dir++; 
        if (dir%100 == 0) System.out.print(".");
    }
    public String toString() {
        return path+" "+fil+" files";
    }
    public void report() {
        report(System.out);
    }
    public void report(String fn) throws IOException {
        PrintStream out = new PrintStream(fn);
        int n = report(out);  out.close();
        System.out.println(n+" lines written to "+fn);
    }
    int report(PrintStream out) {
        out.println("Starting folder: "+path);
        out.println(fil+" files in "+dir+" folders");
        long sec = time/1000;
        if (sec == 0) return 2;
	out.println("Elapsed time: "+sec+" seconds");
        return 3;
    }
    public static void main(String[] args) {
        new FileCrawler().start();
    }
}
