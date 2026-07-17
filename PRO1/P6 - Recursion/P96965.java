import java.util.Scanner;

class Solution{
	public static int sumaDigits(int x){
		if(x < 10) return x;
		else return x%10 + sumaDigits(x/10);
	}

	public static int reduccioDigits(int x){
		int aux = sumaDigits(x);
		if(aux < 10) return aux;
		else return reduccioDigits(aux);
	}
}

class Main {

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			System.out.println(Solution.reduccioDigits(n));
		}
	}

}

