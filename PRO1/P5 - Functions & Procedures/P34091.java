import java.util.Scanner;

class Solution{
	public static boolean esPerfecte(int n){
		boolean perf = true;
		int total = 1, aux;
		if(n < 2) return false;
		for(int i = 2; i * i <= n && perf; ++i){
			if(n%i == 0){
				total += i;
				aux = n/i;
				if(i != aux) total += aux;
				if(total > n) perf = false;
			}
		}
		return (total == n) ? true : false;
	}
}

class Main {

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			System.out.println(Solution.esPerfecte(n) ? "true" : "false");
		}
	}

}

