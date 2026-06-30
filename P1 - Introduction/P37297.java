import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int numero = input.nextInt();
		int aux = numero%1000;
		System.out.println(aux/100 + (aux%100)/10 + aux%10);
	}
}
