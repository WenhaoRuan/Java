import java.io.*;
import java.util.*;

class Main{	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String seq = input.nextLine();
		char aux = seq.charAt(0);
		int count = 0, iter;
		for(int i = 1; i < seq.length() && aux != '.'; ++i){
			if(aux == 'a') ++count;
			aux = seq.charAt(i);
		}
		System.out.println(count);
	}
}
