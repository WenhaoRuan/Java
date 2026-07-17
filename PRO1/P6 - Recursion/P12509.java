import java.util.Scanner;

class Solution{
	public static int factorial(int n){
		if(n == 0) return 1;
		if(n == 1) return 1;
		else return n * factorial(n -1);
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

