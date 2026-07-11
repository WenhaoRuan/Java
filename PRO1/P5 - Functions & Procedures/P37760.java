import java.io.*;
import java.text.DecimalFormat;

class Main{
	public static double readAngle()throws IOException{
		int n;
		while((n = System.in.read()) <= ' ' && n != -1);
		if(n == -1) return Double.NaN;
		double total = 0.0, decimal = 1.0;
		boolean neg = (n == '-');
		if(neg) n = System.in.read();
		while(n >= '0' && n <= '9'){
			total = total * 10 + (n - '0');
			n = System.in.read();
		}
		if(n == '.'){
			n = System.in.read();
			while(n>= '0' && n <= '9'){
				total = total * 10 + (n - '0');
				n = System.in.read();
				decimal *= 10;
			}
		}
		return neg ? -total/decimal : total/decimal;
	}

	public static void main(String[] args)throws IOException{
		double n;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		DecimalFormat df = new DecimalFormat("0.000000");
		while(!Double.isNaN(n = readAngle())){
			bw.write(df.format(Math.sin(Math.toRadians(n))));
			bw.write(' ');
			bw.write(df.format(Math.cos(Math.toRadians(n))));
			bw.write('\n');
		}
		bw.flush();
		bw.close();
	}
}
