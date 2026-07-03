import java.io.*;
import java.util.*;

class Main{	
	public static void main(String[] args) throws IOException{
		int aux;
		int i = 0, total, total1 = 0, total2 = 0;
		long numbers = 0;
		while((aux = System.in.read()) != '\n' && aux != '\r'&& aux != ' ' && aux!= -1){
			if((i&1) == 0) total1 += aux - '0';
			else  total2 += aux - '0';
			numbers = numbers * 10 + aux - '0';
			++i;
		}
		if((i&1) != 0) total = total1;
		else total = total2;
		System.out.print(numbers);
		if((total&1) != 0) System.out.print(" NO");
		System.out.println(" ES TXATXI");
	}
}
