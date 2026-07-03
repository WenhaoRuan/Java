import java.io.*;
import java.util.*;

class Main{
	public static int calculate(int number, int base){
		int total = 0;
		while(number > 0){
			++total;
			number /= base;
		}
		return total;
	}

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int number, base;
		while(input.hasNextInt()){
			base = input.nextInt();
			number = input.nextInt();
			System.out.println(calculate(number, base));
		}
	}
}
