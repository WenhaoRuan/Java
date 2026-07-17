import java.util.Scanner;

class Solution{
	public static int nombreDigits(int n){
		if(n / 10 == 0) return 1;
		else return 1 + nombreDigits(n / 10);
	}
}

class Main {

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			System.out.println(Solution.nombreDigits(n));
		}
	}

}

