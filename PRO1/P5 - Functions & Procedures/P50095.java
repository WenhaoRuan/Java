import java.io.*;

class Main{
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

	public static boolean isPrime(int n){
		if(n <= 1) return false;
		if(n <= 3) return true;
		if((n & 1) == 0) return false;
		for(int i = 5; i * i <= n; i += 6) if(n%i == 0 || n%(i + 2) == 0) return false;
		return true;
	}

	public static int nextPrime(int n){
		if(n == 2) return 3;
		if(n == 3) return 5;
	       	int i = ((n + 1) % 6 == 0) ? (n + 1) : (n + 5);
		while(true){
			if((i - 1) > n && isPrime(i - 1)) return i - 1;
			if((i + 1) > n && isPrime(i + 1)) return i + 1;
			i += 6;
		}
	}

	public static void main(String[] args)throws IOException{
		int n;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while((n = readNat()) != -1 && isPrime(n)){
			bw.write(String.valueOf(nextPrime(n)));
			bw.write('\n');
		}
		bw.flush();
		bw.close();
	}
}
