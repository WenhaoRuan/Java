import java.io.*;
import java.util.*;

class Main{	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		if(x == 0) System.out.println(0);
		else {
			int size = 32 - Integer.numberOfLeadingZeros(x);
			char[] res = new char[size];
			for(int i = 0 ; x > 0; ++i){
				res[i] = (char)((x&1) + '0');
				x >>= 1;
			}
			System.out.println(res);
		}
	}
}
