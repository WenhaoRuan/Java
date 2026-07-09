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

	public static void main(String[] args)throws IOException{
		int rows, cols;
		if((rows = readInt()) == -1 ||(cols = readInt()) == -1) return;
		char n1 = '0', n2 = '0';
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int i, j;
		for(i = 0; i < rows; ++i){
			n1 += i%10;
			for(j = 0; j < Math.min(i, cols); ++j){
				bw.write(n1);
				if(--n1 < '0') n1 = '9';
			}
			for(j = 0; j < cols - i; ++j){
				bw.write(n2);
				if(++n2 > '9') n2 = '0';
			}
			bw.write('\n');
			n1 = n2 = '0';
		}
		bw.flush();
	}
}
