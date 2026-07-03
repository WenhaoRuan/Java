import java.io.*;
import java.util.*;

class Main{
	public static int calculate(int number, int power){
		if(power == 0) return 1;
		else if(power == 1) return number;
		else{
			int aux = calculate(number, power/2);
			if((power & 1) == 0) return aux * aux;
			else return aux * aux * number;
		}		
	}

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int number, power;
		while(input.hasNextInt()){
			number = input.nextInt();
			power = input.nextInt();
			System.out.println(calculate(number, power));
		}
	}
}
