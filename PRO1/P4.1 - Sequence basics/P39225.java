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
		int aux = readInt();
		for(int i = 1; i < n; ++i){
			aux = readInt();
		}

		System.out.println("A la posicio " + n + " hi ha un " + aux + '.');
	}
}
