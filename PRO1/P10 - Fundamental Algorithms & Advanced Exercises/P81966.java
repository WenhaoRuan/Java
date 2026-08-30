import java.util.Scanner;

class Solution{
    private static final double EPS = 1e-9;

    public static int posicio(double x, double[] v, int esq, int dre){
        if(esq > dre) return -1;
        int mid = esq + ((dre - esq) >> 1);
        if(Math.abs(v[mid] - x) < EPS) return mid;
        if(x > v[mid]) return posicio(x, v, mid + 1, dre);
        return posicio(x, v, esq, mid - 1);
    }
}

class Main {

  public static void main(String[] args) {
    final Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()) {
      int n = sc.nextInt();
      double[] v = new double[n];
      for (int i = 0; i < n; ++i)
        v[i] = sc.nextDouble();
      int t = sc.nextInt();
      while (t != 0) {
        --t;
        double x = sc.nextDouble();
        int esq = sc.nextInt();
        int dre = sc.nextInt();
        System.out.println(Solution.posicio(x, v, esq, dre));
      }
    }
  }

}
