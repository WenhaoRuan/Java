import java.util.Scanner;

class Solution{
    public static int[] concatenacio(int[] v1, int[] v2){
        if(v1.length == 0) return v2;
        if(v2.length == 0) return v1;
        int[] res = new int[v1.length + v2.length];
        int size;
        if(v1.length > v2.length){
            for(int i = 0; i < v1.length; ++i){
                res[i] = v1[i];
                if(i < v2.length) res[i + v1.length] = v2[i];
            }
        }
        else{
            for(int i = 0; i < v2.length; ++i){
                if(i < v1.length) res[i] = v1[i];
                res[i + v1.length] = v2[i];
            }
        }
        return res;
    }
}

class Main {

  public static void main(String[] args) {
    final Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()) {
      int n1 = sc.nextInt();
      int[] v1 = new int[n1];
      for (int i = 0; i < n1; ++i) v1[i] = sc.nextInt();
      int n2 = sc.nextInt();
      int[] v2 = new int[n2];
      for (int i = 0; i < n2; ++i) v2[i] = sc.nextInt();
      int[] res = Solution.concatenacio(v1, v2);
      System.out.println(res.length);
      for (int i = 0; i < res.length; ++i) System.out.print(" " + res[i]);
      System.out.println();
    }
  }

}

