import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int x = input.nextInt(), y = input.nextInt();
		for(int i = x; i <= y; ++i){
			if(i != x) System.out.print(',');
			System.out.print(i);
		}
		System.out.println();

	}
}
