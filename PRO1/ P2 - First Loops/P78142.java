import java.io.*;
import java.util.*;

class Main{	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int count = 0;
	        double total = 0, n;
		while(input.hasNextDouble()){
 			n = input.nextDouble();
			total += n;
			++count;
		}
		System.out.println(String.format("%.2f", total/count));
	}
}
