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

	public static boolean esDataValida(int d, int m, int a){
		if(m >= 1 && m <= 12){
			if(m == 2){
				if(d >= 1 && d <= 28) return true;
				else if(d == 29 && esAnyDeTraspas(a)) return true;
				return false;
			}
			else if(m < 8){
				if((m & 1) == 0 && d >= 1 && d <= 30) return true;
				else if((m & 1) == 1 && d >= 1 && d <= 31) return true;
				return false;
			}
			else{
				if((m & 1) == 0 && d >= 1 && d <= 31) return true;
				else if((m & 1) == 1 && d >= 1 && d <= 30) return true;
				return false;
			}
		}
		return false;
	}
}


class Main {

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int d = sc.nextInt();
			int m = sc.nextInt();
			int a = sc.nextInt();
			System.out.println(Solution.esDataValida(d, m, a) ? "true" : "false");
		}

	}

}

