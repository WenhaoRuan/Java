import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		if(a < b){
			if(b < c) System.out.println(c);
			else System.out.println(b);
		}
		else{
			if(a < c) System.out.println(c);
			else System.out.println(a);
		}
		input.close();
	}
}
