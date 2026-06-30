import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int any = input.nextInt(), dia = input.nextInt(),
		hora = input.nextInt(), minut = input.nextInt(),
		segon = input.nextInt(); 
		System.out.println((((any*365 + dia)*24 + hora)*60 + minut)*60 + segon);
		input.close();
	}
}
