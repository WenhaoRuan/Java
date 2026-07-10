import java.io.*;

class Main{
	static StringBuilder number = new StringBuilder();
	static int digits;

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

	public static boolean readString()throws IOException{
		int n;
		while((n = System.in.read()) <= ' ' && n != -1);
		if(n == -1) return false;
		number.setLength(0);
		digits = 0;
		while(n >= '0' && n <= '9'){
			number.append((char)n);
			++digits;			
			n = System.in.read();
		}
		return true;
	}

	public static void main(String[] args)throws IOException{
		int iter = readNat();
		if(iter == -1) return;
		char middle = ' ';
		boolean lost = false;
		for(int i = 0; i < iter * 2; ++i){
			if(!readString()) return;
			if((digits & 1) == 0) lost = true;
			else if(middle == ' ') middle = number.charAt(digits >> 1);			
			else if(middle != number.charAt(digits >> 1)) lost = true;
			if(lost){
				if((i & 1) == 0) System.out.println('B');
				else System.out.println('A');
				return;
			}		
		}
		System.out.println('=');
	}
}
