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
		int number;
		if(input.hasNextInt()){
			while(input.hasNextInt()){
				number = input.nextInt();
				System.out.println("La suma dels digits de " + number + " es " + calculate(number, 10) + '.');
			}
		}
	}
}
