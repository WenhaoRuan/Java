import java.io.*;
import java.util.*;

class Main{
	private static final char[][] MAT ={
		{'-', '1', '2'},
		{'2', '-', '1'},
		{'1', '2', '-'}
	};

	public static int index(char a){
		return switch(a){
			case 'A' -> 0;
			case 'P' -> 1;
			case 'V' -> 2;
			default -> -1;
		};
	}

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		char l1 = input.next().charAt(0), l2 = input.next().charAt(0);
		int p1 = index(l1), p2 = index(l2);
		System.out.println(MAT[p1][p2]);
		input.close();
	}
}

				
