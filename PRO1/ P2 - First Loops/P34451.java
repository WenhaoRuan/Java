import java.io.*;
import java.util.*;

class Main{	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int x, n, count = 0;
		x = input.nextInt();
		while(input.hasNextInt()){
			n = input.nextInt();
			if(n%x == 0) ++count;
		}
		System.out.println(count);
	}
}
