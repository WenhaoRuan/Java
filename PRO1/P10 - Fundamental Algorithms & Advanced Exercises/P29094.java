import java.util.Scanner;

class Solution{
    private static final double EPS = 1e-9;

    public static int posicioMaxim(double[] v, int m){
        int pos = 0;
        double max = v[pos];
        for(int i = 1; i <= m; ++i){
            if(v[i] - max > EPS){
                max = v[i];
                pos = i;
            }
        }
        return pos;
    }
}

class Main {

  public static void main(String[] args) {
    final Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()) {
      int m = sc.nextInt();
      int n = sc.nextInt();
      double[] v = new double[n];
      for (int i = 0; i < n; ++i) v[i] = sc.nextDouble();
      System.out.println(Solution.posicioMaxim(v, m));
    }
  }

}

