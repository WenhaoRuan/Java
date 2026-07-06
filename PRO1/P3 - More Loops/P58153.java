import java.io.*;

class Main{
	public static int readInt() throws IOException{
		int n = System.in.read();
		while(n <= ' ' && n != -1) n = System.in.read();
		if(n == -1 ) return -1;
		int ret = 0;
		while(n >= '0' && n <= '9'){
			ret = ret * 10 + (n -'0');
			n = System.in.read();
		}
		return ret;		
	}

	public static double harmonicDoble(int n1, int n2){
		double total = 0;
		for(int i = n2 + 1; i <= n1; ++i){
			total += 1.0/i;
		}
		return total;
	}

	public static void main(String[] args) throws IOException{
		int n1, n2;
		while ((n1 = readInt()) !=-1){
			n2 = readInt(); if(n2 == -1) return;
			System.out.printf("%.10f\n", harmonicDoble(n1, n2));
		}
	}
}
