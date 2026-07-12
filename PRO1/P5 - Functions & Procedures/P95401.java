import java.util.Scanner;

class Solution{
	public static boolean esAnyDeTraspas(int any){
		if((any & 3) == 0){
			if(any % 100 == 0){
				if(((any/100) & 3) == 0) return true;
				else return false;
			}
			return true;
		}
		return false;
	}
}

class Main {
	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int a = sc.nextInt();
			System.out.println(Solution.esAnyDeTraspas(a) ? "true" : "false");
		}
	}
}

