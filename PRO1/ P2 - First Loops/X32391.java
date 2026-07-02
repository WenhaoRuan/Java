import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int despesesFixes = input.nextInt(), estalvis = input.nextInt(),
		setmanes = input.nextInt(), legal = 0, saldoSetmanal;
		boolean bancarrota = false;
		while(legal < setmanes && !bancarrota){
			saldoSetmanal = input.nextInt();
			estalvis += (saldoSetmanal - despesesFixes);
			if(estalvis <= 0) bancarrota = true;
			else ++legal;
		}
		System.out.println(legal);
	}
}
