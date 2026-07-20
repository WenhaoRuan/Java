import java.util.Scanner;
import java.text.DecimalFormat;
import java.math.RoundingMode;

class Solution{
    public static double producteEscalar(double[] u, double[] v){
        int size = u.length;
        double total = 0;;
        if(size == 0) return total;
        for(int i = 0; i < size; ++i){
            total += u[i] * v[i];
        }
        return total;
    }
}

class Main {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final DecimalFormat df = new DecimalFormat("0.0000");
        df.setRoundingMode(RoundingMode.HALF_EVEN);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            double[] u = new double[n];
            double[] v = new double[n];
            for (int i = 0; i < n; ++i) u[i] = sc.nextDouble();
            for (int i = 0; i < n; ++i) v[i] = sc.nextDouble();
            System.out.println(df.format(Solution.producteEscalar(u, v)));
        }
    }

}

