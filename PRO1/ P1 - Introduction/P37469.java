import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int segons = input.nextInt();
		System.out.println(segons/3600 + " " + (segons%3600)/60 + " " + segons%60);	
		input.close();
	}
}

