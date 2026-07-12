import java.util.Scanner;

class Solution{
	public static int factorial(int n){
		int res = 1;
		if(n < 2) return res;
		else{
			for(int i = 2; i <= n; ++i){
				res *= i;
			}
		}
		return res;
	}
}

class Main {

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			System.out.println(Solution.factorial(n));
		}
	}

}

