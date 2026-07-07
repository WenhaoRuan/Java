import java.io.*;

class Main{
	public static int readInt()throws IOException{
		int n;
		while((n = System.in.read()) <= ' ' && n != -1);
		if(n == -1) return n;
		int total = 0;
		while(n >= '0' && n <= '9'){
			total = total * 10 + (n -'0');
			n = System.in.read();
		}
		return total;
	}

	public static boolean primer(int n){
		//1 or less isnt considered prime
		if(n <= 1) return false;
		//2 and 3 are considred prime
		if(n <= 3) return true;
		//if its pair or multiple of 3 isnt a prime
		if((n&1) == 0 || n%3 == 0) return false;
		//using trial division and checking around 6k lets us discard
		//numbers that couldnt possibly be prime, 6k is multiple of 6,
		//6k + 2 is a pair, and so is 6k +4, 6k+ 3 is a multiple of 3,
		//that leaves us the possible choices of 6k+5 and 6k+1, which
		//are the choices we check with n%i(checking for 6k + 5 being
		//the first iteration k = 0 meaning i = 5, and 6k+1 in which
		//the first iteration k = 1 as i = 5 and then we add 2, meaning
		//5 + 2 (6(1) + 1), and then so on and so forth.
		//And trial by division just means that we only check sqrt(n) or
		//i * i <= n
		for(int i = 5; i * i <= n; i += 6) if(n%i == 0 || n%(i + 2) == 0) return false;
		return true;
	}

	public static void main(String[] args)throws IOException{
		int n = readInt(), aux;
		for(int i = 0; i < n; ++i){
			aux = readInt();
			System.out.print(aux);
			if(!primer(aux)) System.out.print(" no");
			System.out.println(" es primer");
		}
	}
}
