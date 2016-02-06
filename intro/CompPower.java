import java.io.*;
import java.util.Scanner;

class CompPower {
   static double power(double a, int n) {
      if (n == 0)
         return 1;
      else if (n < 0)
         return power(1/a, -n);
      else if (n%2 == 0)
         return power(a*a, n/2);
      else
         return a*power(a, n-1);
   }
   final static Scanner sc = new Scanner(System.in);
   public static void main(String[] args) {
      int x, n;
      System.out.println("Power");
      System.out.print("x: ");
      x = sc.nextInt();
      while (x > 0) {
         System.out.print("n: ");
         n = sc.nextInt();
         if (Math.round(n) != n)
            System.out.println(n+" invalid");
         else {
            System.out.print(x+"^"+n+" = "+power(x, n)+"  ");
            System.out.println(Math.exp(n*Math.log(x)));
            System.out.print("x: ");
            x = sc.nextInt();
         }
      }
   }
}
