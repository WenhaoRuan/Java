import java.io.*;
import java.util.*;

class Main{	
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		int start, end, aux;
		long total = 0;
		while(input.hasNextInt()){
			start = input.nextInt();
			end = input.nextInt();			
			for(aux = start; aux <= end; ++aux) total += (aux*aux*aux);
			System.out.println("suma dels cubs entre " + start + " i " + end + ": " + total);
			total = 0;
		}
	}
}
