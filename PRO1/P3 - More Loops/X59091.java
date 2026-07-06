import java.io.*;

class Main{
	public static int readInt() throws IOException{
		int n = System.in.read();
		while(n <= ' ' && n != -1) n = System.in.read();
		if(n == -1) return -1;
		int total = 0;
		while(n >= '0' && n <= '9'){
			total = total * 10 + (n - '0');
			n = System.in.read();
		}
		return total;
	}

	public static void rectangle(int rows, int cols){
		char[] map = new char[rows * (cols + 1)];
		int index = 0;
		char aux = '9';
		for(int i = 0; i < rows; ++i){
			for(int j = 0; j < cols; ++j){
				map[index++] = aux;
				if((--aux) < '0') aux = '9';
			}
			map[index++] = '\n';
		}
		System.out.print(map);
	}

	public static void main(String[] args)throws IOException{
		int rows, cols;
		boolean first = true;
		while((rows = readInt()) != -1){
			if(!first) System.out.println();
			else first = false;
			cols = readInt(); if(cols == -1) return;
			rectangle(rows, cols);
		}
	}
}
