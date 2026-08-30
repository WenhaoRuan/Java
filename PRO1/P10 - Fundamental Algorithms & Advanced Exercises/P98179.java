import java.util.Scanner;
import java.text.DecimalFormat;
import java.math.RoundingMode;

class Solution{
    private static final double EPS = 1e-9;

    public static int dichotomic(final double[] v, final double ins, int esq, int dre){
        if(esq > dre) return esq;
        int mid = esq + ((dre - esq) >> 1);
        if(Math.abs(ins - v[mid]) < EPS) return mid;
        if(ins < v[mid]) return dichotomic(v, ins, esq, mid - 1);
        return dichotomic(v, ins, mid + 1, dre);
    }

    public static void insereix(double[] v){
        double ins = v[v.length - 1];
        int pos = dichotomic(v, ins, 0, v.length - 2);
        for(int i = v.length -1; i > pos; --i)
            v[i] = v[i - 1];
        v[pos] = ins;
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
      Solution.insereix(v);
      for (int i = 0; i < n; ++i) System.out.print(" " + df.format(v[i]));
      System.out.println();
    }
  }

}

