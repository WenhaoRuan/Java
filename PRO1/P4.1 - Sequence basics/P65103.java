import java.io.*;

class Main{
	public static int readInt()throws IOException{
		int n;
		while((n = System.in.read()) <= ' ' && n != -1);
		if(n == -1) return -1;
		int total = 0;
		while(n >= '0' && n <= '9'){
			total = total * 10 + (n - '0');
			n = System.in.read();
		}
		return total;
	}

	public static void main(String[] args)throws IOException{
		int n = readInt();
		boolean posInco = false;
		if(n < 1) posInco = true;
		int aux = readInt(); if(aux == -1) posInco = true;
		for(int i = 1; i < n && !posInco; ++i){
			aux = readInt();
			if(aux == -1) posInco = true;
		}
		if(!posInco) System.out.println("A la posicio " + n + " hi ha un " + aux + '.');
		else System.out.println("Posicio incorrecta.");
	}
}
