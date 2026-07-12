import java.util.Scanner;

class Solution{
	public static boolean esCapicua(int n){
		int reversed = 0;
		if(n % 10 == 0 && n != 0) return false;
		while(n > reversed){
			reversed = reversed * 10 + (n%10);
			n /= 10;
		}
		return n == reversed || n == reversed/10;
	}
}

class Main {

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			System.out.println(Solution.esCapicua(n) ? "true" : "false");
		}
	}

}

