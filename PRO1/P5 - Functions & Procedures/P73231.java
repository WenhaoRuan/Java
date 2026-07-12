import java.util.Scanner;

class Solution{
	public static int max4(int a, int b, int c, int d){
		return Math.max(Math.max(a, b), Math.max(c, d));
	}
}


class Main {
	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			System.out.println(Solution.max4(a, b, c, d));
		}
	}
}

