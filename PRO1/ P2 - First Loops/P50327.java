import java.io.*;
import java.util.*;

class Main{	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String x = input.next();
		char[] res = new char[x.length()];
		for(int i = x.length() - 1; i >= 0; --i){
			res[x.length() - 1 - i] = x.charAt(i) ;
		}
		System.out.println(res);
	}
}
