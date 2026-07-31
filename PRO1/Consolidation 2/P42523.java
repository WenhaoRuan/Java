import java.util.Scanner;

class Solution{
    public static int mcd(int a, int b){
        return b == 0 ? a : mcd(b, a%b);
    }
}

class Main {

  public static void main(String[] args) {
    final Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      System.out.println(Solution.mcd(a, b));
    }
  }

}

