import java.io.*;
import java.util.*;

class Main{
	public static int cifras(int a, int b){
		int res = 1;
		while(b >= a){
			b /= a;
			++res;
		}
		return res;
	}	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		for(int i = 2; i <= 16; ++i){
			System.out.println("Base " + i + ": " + cifras(i, x) + " cifras.");
		}
	}
}
