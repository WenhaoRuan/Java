import java.io.*;

class Main{
	public static int readInt()throws IOException{
		int n = System.in.read();
		while(n <= ' ' && n != -1) n = System.in.read();
		if(n == -1) return -1;
		int total = 0;
		while(n >= '0' && n <= '9'){
			total = total * 10 + (n - '0');
			n = System.in.read();
		}
		return total;
	}

	public static int collatz(int n){
		int total = 0;
		while(n != 1){
			if((n&1) == 0) n /= 2;
			else n = n * 3 + 1;
			++total;
		}
		return total;
	}

	public static void main(String[] args) throws IOException{
		int n1;
		while ((n1 = readInt()) !=-1){
			System.out.println(collatz(n1));
		}
	}
}
