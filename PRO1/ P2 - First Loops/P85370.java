import java.io.*;
import java.util.*;

class Main{	
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		double inicial = input.nextDouble(), interes = input.nextDouble();
		int temps = input.nextInt();
		double total = 0;
		String tipus = input.next();
		if(tipus.equals("simple")) total = inicial + inicial * temps * interes / 100;
		else{
			interes /= 100;
			total = inicial;
			for(int i = 0; i < temps; ++i)total = total * (1 + interes);
		}
		System.out.println(String.format("%.4f", total));
	}
}
