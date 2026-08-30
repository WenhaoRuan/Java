import java.util.Scanner;
import java.text.DecimalFormat;
import java.math.RoundingMode;

class Solution{
    private static final double EPS = 1e-9;

    public static void ordenaPerInsercio(double[] v){
        for(int i = 1; i < v.length; ++i){
            double key = v[i];
            int j = i - 1;

            while(j >= 0 && (v[j] - key > EPS))
                v[j + 1] = v[j--];
            v[j + 1] = key;
        }
    }
}

class Main {

  public static void main(String[] args) {
    final Scanner sc = new Scanner(System.in);
    final DecimalFormat df = new DecimalFormat("0.0000");
    df.setRoundingMode(RoundingMode.HALF_EVEN);
    while (sc.hasNextInt()) {
      int n = sc.nextInt();
      double[] v = new double[n];
      for (int i = 0; i < n; ++i) v[i] = sc.nextDouble();
      Solution.ordenaPerInsercio(v);
      for (int i = 0; i < n; ++i) System.out.print(" " + df.format(v[i]));
      System.out.println();
    }
  }

}

