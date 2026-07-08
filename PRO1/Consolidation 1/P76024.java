import java.io.*;
import java.text.DecimalFormat;

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

	public static void main(String[] args)throws IOException{
		int start, end, step;
		DecimalFormat df = new DecimalFormat("0.0000");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while((start = readInt()) != -1){
			end = readInt();
			step = readInt();
			if(end == -1 || step == -1) return;
			double total = 0.0;		
			for(int i = start; i <= end; i += step){
				total += 1.0/i;
			}
			bw.write(df.format(total));
			bw.newLine();
		}
		bw.flush();
	}
}
