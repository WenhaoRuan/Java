import java.io.*;

class Main{
	static BufferedInputStream bis = new BufferedInputStream(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void screenprint(int n)throws IOException{
		switch(n){
			case 10 -> bw.write('A');
			case 11 -> bw.write('B');
			case 12 -> bw.write('C');
			case 13 -> bw.write('D');
			case 14 -> bw.write('E');
			case 15 -> bw.write('F');
			default ->bw.write((char)(n + '0'));
		}
	}

	public static void hex(int n)throws IOException{
		if(n < 16) screenprint(n);
		else {
			hex(n>>4);
			screenprint(n&15);
		}
	}
	
	public static void octa(int n)throws IOException{
		if(n < 8) screenprint(n);
		else{
			octa(n>>3);
			screenprint(n&7);
		}
	}

	public static void binary(int n)throws IOException{
		if(n < 2) screenprint(n);
		else{
			binary(n>>1);
			screenprint(n&1);
		}
	}

	public static int readNat()throws IOException{
		int n;
		while((n = bis.read()) <= ' ' && n != -1);
		if(n == -1) return n;
		int total = 0;
		while(n >= '0' && n <= '9'){
			total = total * 10 + (n - '0');
			n = bis.read();
		}
		return total;
	}

	public static void main(String[] args)throws IOException{
		int n;
		while((n = readNat()) != -1){
			bw.write(String.valueOf(n));
			bw.write(" = ");
			binary(n);
			bw.write(", ");
			octa(n);
			bw.write(", ");
			hex(n);
			bw.write('\n');
		}
		bw.close();
	}
}
