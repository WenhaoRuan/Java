import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double a = input.nextDouble();
		int bottom = (int)a, top = bottom, closer = bottom;
		double aux;
		aux = a - bottom;
		if(aux != 0){
			++top;
			if(aux >= 0.5) ++closer;
		}
		System.out.println(bottom + " " + top + " " + closer);
		input.close();
	}
}
