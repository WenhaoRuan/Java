import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		if((a+b) % 2 == 0) System.out.println((a + b)/2);
		else System.out.println((a + b)/2.0f);
	}
}
