import java.util.Scanner;

class Solution{
    public static int sumaDigits(int n){
        if(n < 10) return n;
        else return n%10 + sumaDigits(n/10);
    }

    public static boolean esMultiple3(int n){
        //se que la meva solucio i en concret aquest condicional
        //va mes enlla del que demanen pero crec que esta en 
        //l'esperit del que busquen ja que volen que utilitzem
        //recursio i per tant ho he fet evitant l'us del modul
        //el qual tribialitzaria tot l'exercici perque no faria 
        //falta el pas de sumadigits ni recursivitat ni res
        if(n < 10) return (n == 3 || n == 6 || n == 9);
        else return esMultiple3(sumaDigits(n));
    }
}
class Main {

  public static void main(String[] args) {
    final Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()) {
      int n = sc.nextInt();
      System.out.println(Solution.esMultiple3(n) ? "true" : "false");
    }
  }

}

