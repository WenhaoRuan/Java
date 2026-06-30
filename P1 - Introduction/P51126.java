import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int minA = input.nextInt(), maxA = input.nextInt(),
		minB = input.nextInt(), maxB = input.nextInt();
		int minRes = minA, maxRes = maxA;
		if(maxA < minB || maxB < minA) System.out.println("[]");
		else{
			if(minA < minB) minRes = minB;
			else minRes = minA;
			if(maxA > maxB) maxRes = maxB;
			else maxRes = maxA;
			System.out.println("[" + minRes + "," + maxRes + "]");
		}
		input.close();
	}
}
