import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int temperature = input.nextInt();
		if(temperature > 30){
			System.out.println("fa calor");
			if(temperature >= 100) System.out.println("l'aigua bulliria");
		}
		else if(temperature >= 10) System.out.println("s'esta be");
		else{
			System.out.println("fa fred");
			if(temperature <= 0) System.out.println("l'aigua es gelaria");
		}			
		input.close();
	}
}
