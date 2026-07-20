import java.util.Scanner;

class Solution{
    public static boolean esPalindrom(String s){
        int len = s.length(), loopsize = len >> 1;
        for(int i = 0; i < loopsize; ++i)
            if(s.charAt(i) != s.charAt(len - 1 - i)) return false;
        return true;
    }
}


class Main {

  public static void main(String[] args) {
    final Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      String s = sc.next();
      System.out.println(Solution.esPalindrom(s) ? "1" : "0");
      int n = s.length();
      if (n > 100) {
        StringBuilder str = new StringBuilder(s);
        char c = s.charAt(0);
        str.setCharAt(0, 'a');
        String sTmp = str.toString();
        for (int rep = 1000; rep > 0; --rep) System.out.println(Solution.esPalindrom(sTmp) ? "1" : "0");
        str.setCharAt(0, c);
        c = s.charAt(1);
        str.setCharAt(1, 'a');
        sTmp = str.toString();
        for (int rep = 1000; rep > 0; --rep) System.out.println(Solution.esPalindrom(sTmp) ? "1" : "0");
        str.setCharAt(1, c);
        c = s.charAt(3);
        str.setCharAt(3, 'a');
        sTmp = str.toString();
        for (int rep = 1000; rep > 0; --rep) System.out.println(Solution.esPalindrom(sTmp) ? "1" : "0");
        str.setCharAt(3, c);
        c = s.charAt(n - 1);
        str.setCharAt(n - 1, 'a');
        sTmp = str.toString();
        for (int rep = 1000; rep > 0; --rep) System.out.println(Solution.esPalindrom(sTmp) ? "1" : "0");
        str.setCharAt(n - 1, c);
        c = s.charAt(n - 2);
        str.setCharAt(n - 2, 'a');
        sTmp = str.toString();
        for (int rep = 1000; rep > 0; --rep) System.out.println(Solution.esPalindrom(sTmp) ? "1" : "0");
        str.setCharAt(n - 2, c);
        c = s.charAt(n - 7);
        str.setCharAt(n - 7, 'a');
        sTmp = str.toString();
        for (int rep = 1000; rep > 0; --rep) System.out.println(Solution.esPalindrom(sTmp) ? "1" : "0");
        str.setCharAt(n - 7, c);
      }
    }
  }

}

