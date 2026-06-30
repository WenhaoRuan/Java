import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int a1 = input.nextInt(), b1 = input.nextInt(),
		a2 = input.nextInt(), b2 = input.nextInt();
		char type = '?';
		if(a1 == a2){
			if(b1 == b2) type = '=';
			else if(b1 < b2) type = '1';
			else type = '2';
		}
		else if(a1 < a2 && b2 < b1) type = '2';
		else if(a2 < a1 && b1 < b2) type = '1';
		else if(b1 == b2){
			if(a1 < a2) type = '2';
			else type = '1';
		}
		System.out.println(type);
		input.close();
	}
}
