import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String tipusA = "majuscula", tipusB = "consonant";
		char a = input.next().charAt(0);
		if(a >= 'a' && a <= 'z') tipusA = "minuscula";
		if(a == 'a' ||a == 'e' ||a == 'i' ||a == 'o' ||a == 'u' ||
		a == 'A' ||a == 'E' ||a == 'I' ||a == 'O' ||a == 'U') tipusB = "vocal";
		System.out.println(tipusA);
		System.out.println(tipusB);
		input.close();
	}
}
