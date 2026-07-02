import java.io.*;
import java.util.*;

class Main{
	public static char intToHex(int a){
		return switch(a){
			case 10 -> 'A';
			case 11 -> 'B';
			case 12 -> 'C';
			case 13 -> 'D';
			case 14 -> 'E';
			case 15 -> 'F';
			default -> (char)(a + '0');
		};
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		if(x == 0) System.out.println(0);
		else {
			int size = 32 - Integer.numberOfLeadingZeros(x);
			size = (size + 3) >> 2;
			char[] res = new char[size];
			int aux;
			for(int i = 0 ; x > 0; ++i){
				res[i] = intToHex(x & 0xF);
				x >>= 4;
			}
			System.out.println(res);
		}
	}
}
