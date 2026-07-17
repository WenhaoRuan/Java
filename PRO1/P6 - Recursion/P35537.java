import java.util.Scanner;

class Solution{
	public static boolean esCreixent(int n){
		if(n < 10) return true;
		else{
			int aux = n/10;
		       	if(aux%10 <= n%10) return esCreixent(aux);
			else return false;
		}
	}
}

class Main {

public static void main(String[] args) {
	final Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			System.out.println(Solution.esCreixent(n) ? "true" : "false");
		}
	}

}

