import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		char a = input.next().charAt(0);
		if(a >= 'A' && a <= 'Z') System.out.println((char)(a - 'A'  + 'a'));
		else System.out.println((char)(a + 'A' - 'a'));
		input.close();
	}
}
