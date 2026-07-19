import java.io.*;
import java.util.Arrays;

class Main{
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void barres(int n, char[] symbol)throws IOException{
		if(n == 0) return;
		barres(n - 1, symbol);
		barres(n - 1, symbol);
		bw.write(symbol, 0, n);
		bw.write('\n');
	}
	
	public static int readNat()throws IOException{
		int n;
		while((n = System.in.read()) <= ' ' && n != -1);
		if(n == -1) return n;
		int total = 0;
		while(n >= '0' && n <= '9'){
			total = total * 10 + (n - '0');
			n = System.in.read();
		}
		return total;
	}

	public static void main(String[] args)throws IOException{
		int n;
		if((n = readNat()) != -1){
			char[] symbol = new char[n];
			Arrays.fill(symbol, '*');
			barres(n, symbol);
		}
		bw.close();
	}
}
