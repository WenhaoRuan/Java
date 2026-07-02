import java.io.*;
import java.util.*;

class Main{
	public static double harmonic(int n){
		double res = 0, aux = 1;
		for(int i = 1; i <= n; ++i){
			res += aux/i;
		}
		return res;
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		String res = String.format("%.4f", harmonic(x));
		System.out.println(res);
	}
}
