import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String a = input.next(), b = input.next();
		char relation;
		int res = a.compareTo(b);
		if(res < 0) relation = '<';
		else if(res > 0) relation = '>';
		else relation = '=';
		System.out.println(a + ' ' + relation + ' ' + b);
		input.close();
	}
}
