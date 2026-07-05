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
		int n, iter = 0;
		while((n = readInt())!= -1){
			char[] map = new char[2 * (2 * n - 1) * (2 * n - 1)];
			for(int i = 0; i < 3 * n - 2; ++i){
				if(i < n){
					for(int j = 0; j < n - 1 - i; ++j) map[iter++] = ' ';
					for(int j = 0; j <= i; ++j) map[iter ++] = 'X';
					for(int j = 0; j < n - 2; ++j) map[iter++] = 'X';
					for(int j = 0; j <= i; ++j) map[iter++] = 'X';
				}
				else if(i >= n && i < 2 * n - 2){
					for(int j = 0; j < 3 * n - 2; ++j) map[iter++] = 'X';
				}
				else{
					for(int j = 0; j < i - 2 * n + 2; ++j) map[iter++] = ' ';
					for(int j = 0; j < 3 * n - 2 - i; ++j) map[iter++] = 'X';
					for(int j = 0; j < n - 2; ++j) map[iter++] = 'X';
					for(int j = 0; j < 3 * n - 2 - i; ++j) map[iter++] = 'X';
				}
				map[iter++] = '\n';
			}
			System.out.println(map);
			iter = 0;

		}
	}
}
