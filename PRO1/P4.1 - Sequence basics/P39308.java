import java.io.*;

class Main{
	public static int readInt()throws IOException{
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

	public static String Factoritza(int n){
		StringBuilder sbL = new StringBuilder(), sbR = new StringBuilder();
		for(int i = 1; i * i <= n; i++){
			if(n%i == 0){
				sbL.append(i).append(' ');
				if(i != n/i) sbR.insert(0, (n/i) + " ");
			}
		}
		sbL.append(sbR);
		if(sbL.length() > 0) sbL.setLength(sbL.length() - 1);
		return sbL.toString();
	}

	public static void main(String[] args)throws IOException{
		int n;
		while((n = readInt()) != -1){
			System.out.print("divisors de " + n + ": ");
			System.out.println(Factoritza(n));
		}
	}
}
