import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int a1 = input.nextInt(), b1 = input.nextInt(),
		a2 = input.nextInt(), b2 = input.nextInt();
		char relation = '?';
		int r1 = a1, r2 = b1;
		boolean disjunct = false;
		if(a1 == a2 && b1 == b2) relation = '=';
		else if(a1 >= a2 && b1 <= b2) relation = '1';
		else if(a2 >= a1 && b2 <= b1){
		       relation = '2';
		       r1 = a2; r2 = b2;
		}
		else if(a1 == b2) r1 = r2 = a1;
		else if(a2 == b1) r1 = r2 = a2;
		else if(!(b1 < a2 ||b2 < a1)){
			if(a1 < a2 && b1 < b2){ r1 = a2; r2 = b1;}
			else if(a2 < a1 && b2 < b1){ r1 = a1; r2 = b2;}
		}
		else disjunct = true;
		if(disjunct) System.out.println(relation + " , []");
		else System.out.println(relation + " , [" + r1 + "," + r2 + "]");
		input.close();
	}
}
