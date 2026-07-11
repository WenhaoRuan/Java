import java.io.*;
import java.text.DecimalFormat;

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

	public static void main(String[] args)throws IOException{
		int n;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		DecimalFormat df = new DecimalFormat("0.000000");
		while((n = readNat()) != -1){
			bw.write(String.valueOf(n*n));
			bw.write(' ');
			bw.write(df.format(Math.sqrt(n)));
			bw.write('\n');
		}
		bw.flush();
	}
}
