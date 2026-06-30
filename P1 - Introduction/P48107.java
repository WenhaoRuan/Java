import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int a = input.nextInt(), b = input.nextInt();
		System.out.println(a/b + " " + a%b);
		input.close();
	}
}

