// Eyler 13.4.2002
// 14.3.2003  implement Set
// 26.1.2016  use HashSet

import java.util.HashSet;

class Prime {
   static void primes(int M) {
      long time = System.currentTimeMillis();
//      SimpleSet s = new SimpleSet(M);
      HashSet<Number> s = new HashSet<Number>(M);
      for (int k=2; k<M; k++) s.add(k);
      for (int p=2; p*p<M; p++) 
         if (s.contains(p)) { //p is next prime
            System.out.print(p+"  ");
            for (int k=2*p; k<M; k=k+p)
               s.remove(k);
         }
      System.out.println(); 
      long t = System.currentTimeMillis() - time;
      System.out.println(t+" msec calculation");
      System.out.println(s);
      t = System.currentTimeMillis() - time;
      System.out.println(t+" msec total");
   }
   public static void main(String args[]) {
      primes(1000);
   }
}

/*
{ 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 101 103
 107 109 113 127 131 137 139 149 151 157 163 167 173 179 181 191 193 197 199 211
 223 227 229 233 239 241 251 257 263 269 271 277 281 283 293 307 311 313 317 331
 337 347 349 353 359 367 373 379 383 389 397 401 409 419 421 431 433 439 443 449
 457 461 463 467 479 487 491 499 503 509 521 523 541 547 557 563 569 571 577 587
 593 599 601 607 613 617 619 631 641 643 647 653 659 661 673 677 683 691 701 709
 719 727 733 739 743 751 757 761 769 773 787 797 809 811 821 823 827 829 839 853
 857 859 863 877 881 883 887 907 911 919 929 937 941 947 953 967 971 977 983 991
 997 }
4 msec total


class SimpleSet {
   boolean[] x;
   int size;
   public SimpleSet(int maxValue) {
      x = new boolean[maxValue];
   }
   public int size() {
      return size;
   }
   public boolean contains(int k) {
      return 0<=k && k<x.length && x[k];
   }
   public boolean remove(int k) {
      if (!contains(k)) return false;
      x[k] = false; size--;
      return true;
   }
   public boolean add(int k) {
      if (contains(k)) return false;
      x[k] = true; size++;
      return true;
   }
   public String toString() {
      String s = "<";
      for (int k=0; k<x.length; k++)
         if (x[k]) s = s + k +", ";
      int n = s.length();
      if (n > 2) s = s.substring(0, n-2);
      return s + ">";
   }
}
*/
