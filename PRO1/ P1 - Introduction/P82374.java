import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int x = input.nextInt(), a = input.nextInt(),
		b = input.nextInt(), c = input.nextInt(),
	    	d = input.nextInt();
		String res = "no";
		if(x >= a && x <= b || x >= c && x <= d) res = "si";
		System.out.println(res);
	}
}
