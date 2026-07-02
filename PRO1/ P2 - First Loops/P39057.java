import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int shapes = input.nextInt();
		String item;
		double mesure1, mesure2;
		for(int i = 0; i < shapes; ++i){
			item = input.next();
			mesure1 = input.nextDouble();
			if(item.equals("rectangle")) {				
				mesure2 = input.nextDouble();
				System.out.println(String.format("%.6f", mesure1 * mesure2));
			}
			else System.out.println(String.format("%.6f", Math.PI * mesure1 * mesure1));
		}
	}
}
