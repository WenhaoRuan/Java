import java.util.Scanner;

class Solution{
    public static void transposa(int[][] m){
        int n = m.length;
        for(int i = 0; i < n; ++i)
            for(int j = i + 1; j < n; ++j){
                int tmp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = tmp;
            }
    }
}

class Main {

  public static void main(String[] args) {
    final Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()) {
      int n = sc.nextInt();
      int[][] m = new int[n][n];
      for (int i = 0; i < n; ++i) 
        for (int j = 0; j < n; ++j) 
          m[i][j] = sc.nextInt();
      Solution.transposa(m);
      for (int i=0; i<n; ++i) {
        for (int j=0; j<n; ++j) 
          System.out.print(Integer.toString(m[i][j]) + ' ');
        System.out.println();
      }   
      System.out.println();
    }
  }

}

