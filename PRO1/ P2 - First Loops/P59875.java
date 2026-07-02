import java.io.*;
import java.util.*;

class Main{
	public static void enumerator(int a, int b){
		for(int i = a; i >= b; --i)System.out.println(i);
	}

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int x = input.nextInt(), y = input.nextInt();
		if(x > y) enumerator(x, y);
		else enumerator(y, x);
	}
}
