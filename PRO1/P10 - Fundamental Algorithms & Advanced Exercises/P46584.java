import java.util.Arrays;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.math.RoundingMode;

class Solution{
    private static final double EPS = 1e-9;

    public static double[] diferencia(double[] v1, double[] v2){
        int i = 0, j = 0, k = 0;
        double[] res = new double[v1.length];
        for(; i < v1.length && j < v2.length;){
            if((Math.abs(v1[i] - v2[j]) < EPS)){
                ++i;
            }
            else if(v1[i] < v2[j]){
                if(k == 0 || Math.abs(res[k - 1] - v1[i]) >= EPS)
                    res[k++] = v1[i];
                ++i;
            }
            else ++j;
        }
        for(;i < v1.length;++i) 
            if(k == 0 || Math.abs(res[k - 1] - v1[i]) >= EPS)
                res[k++] = v1[i];
        return Arrays.copyOfRange(res, 0, k);
    }
} 


class Main {

  public static void main(String[] args) {
    final Scanner sc = new Scanner(System.in);
    final DecimalFormat df = new DecimalFormat("0.0000");
    df.setRoundingMode(RoundingMode.HALF_EVEN);
    while (sc.hasNextInt()) {
      int n1 = sc.nextInt();
      double[] v1 = new double[n1];
      for (int i = 0; i < n1; ++i) v1[i] = sc.nextDouble();
      int n2 = sc.nextInt();
      double[] v2 = new double[n2];
      for (int i = 0; i < n2; ++i) v2[i] = sc.nextDouble();
      double[] res = Solution.diferencia(v1, v2);
      int n3 = res.length;
      System.out.println(n3);
      for (int i = 0; i < n3; ++i) System.out.print(" " + df.format(res[i]));
      System.out.println('\n');
      for (int r = 0; r < 200; ++r) {
        double[] res2 = Solution.diferencia(v1, v2);
        if (!Arrays.equals(res2, res)) System.out.println("Resultats diferents amb la mateixa entrada!");
      }
    }
  }

}

