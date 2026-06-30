import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int any = input.nextInt();
		String res = "NO";
		if (any%100 == 0){ if((any/100)%4 == 0) res = "YES";}
		else if(any%4 == 0) res = "YES";
		System.out.println(res);
		input.close();
	}
}
