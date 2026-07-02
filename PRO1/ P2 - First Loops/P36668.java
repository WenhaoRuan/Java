import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		long x = input.nextInt();
		System.out.println((x*(x + 1)*(2*x + 1))/6);
	}
}
