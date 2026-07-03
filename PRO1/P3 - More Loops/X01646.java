import java.io.*;
import java.util.*;

class Main{
	public static int calculate(int number, int base){
		int total = 0;
		while(number > 0){
			total += number%base;
			number /= base;
		}
		return total;
	}

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int number, base;
		if(input.hasNextInt()){
			base = input.nextInt();
			while(input.hasNextInt()){
				number = input.nextInt();
				System.out.println(number + ": " + calculate(number, base));
			}
		}
	}
}
