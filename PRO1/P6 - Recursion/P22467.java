import java.util.Scanner;

class Solution{
	public static boolean primer(int n){
		if(n <= 1) return false;
		if(n <= 3) return true;
		if((n & 1) == 0) return false;
		if(n%3 == 0) return false;
		for(int i = 5; i * i <= n; i+= 6)
			if((n%i) == 0 || n%(i + 2) == 0) return false;
		return true;
	}

	public static int sumaDigits(int n){
		if(n < 10) return n;
		else return n%10 + sumaDigits(n/10);
	}

	public static boolean esPrimerPerfecte(int n){
		if(primer(n)){
			if(n < 10) return true;
			else return esPrimerPerfecte(sumaDigits(n));
		}
		return false;
	}
}

class Main {

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			System.out.println(Solution.esPrimerPerfecte(n) ? "true" : "false");
		}
	}

}

