import java.io.*;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

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

	public static double readDouble()throws IOException{
		int n;
		while((n = System.in.read()) <= ' ' && n != -1);
		if(n == -1) return Double.NaN;
		boolean neg = (n == '-');
		if(neg) n = System.in.read();
		double total = 0;
		while(n >= '0' && n <= '9'){
			total = total * 10 + (n - '0');
			n = System.in.read();
		}
		if(n == '.'){
			double div = 1.0;
			n = System.in.read();
			while(n >= '0' && n <= '9'){
				total = total * 10 + (n - '0');
				div *= 10;
				n = System.in.read();
			}
			total /= div;
		}
		return neg ? -total : total;
	}

	public static void main(String[] args)throws IOException{
		int n1, n2;
		if((n1 = readInt()) == -1) return;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		DecimalFormat df = new DecimalFormat("0.0000");
		for(int i = 0; i < n1; ++i){
			if((n2 = readInt()) == -1) return;
			double aux, total = 0.0, min = Double.NaN, max = Double.NaN;
			for(int j = 0; j < n2; ++j){
				if(Double.isNaN(aux = readDouble())) return;
				if(Double.isNaN(min)) min = aux;
				if(Double.isNaN(max)) max = aux;
				if(aux < min) min = aux;
				if(aux > max) max = aux;
				total += aux;
			}
			bw.write(df.format(min));
			bw.write(' ');
			bw.write(df.format(max));
			bw.write(' ');
			bw.write(df.format(total/n2));
			bw.write('\n');
		}
		bw.flush();
	}
}
