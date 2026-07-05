import java.io.*;

class Main{
	public static int readInt() throws IOException{
		int n = System.in.read();
		while(n <= ' ' && n != -1) n = System.in.read();
		if(n == -1 ) return -1;
		int ret = 0;
		while(n >= '0' && n <= '9'){
			ret = ret * 10 + (n -'0');
			n = System.in.read();
		}
		return ret;		
	}

	public static void main(String[] args) throws IOException{
		int rows = readInt(); if(rows == -1) return;
		int cols = readInt(); if(cols == -1) return;
		int total = 0, iter = 0, n;
		while((n = System.in.read())!= -1 && iter < rows * cols){
			if(n != ' ' && n != '\n' && n != '\r'){
				total += n - '0';
				++iter;
			}
		}
		System.out.println(total);		
	}
}
