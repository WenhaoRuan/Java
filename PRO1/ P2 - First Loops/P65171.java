import java.io.*;
import java.util.*;

class Main{	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int count = input.nextInt();
		double total1 = 0, total2 = 0, n;
		for(int i = 0; i < count; ++i){
			n = input.nextDouble();
			total1 += n * n;
			total2 += n;		
		}
		System.out.println(String.format("%.2f",total1/(count-1) - total2*total2/(count*(count - 1))));
	}
}
