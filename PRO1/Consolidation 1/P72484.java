import java.io.*;

class Main{
	public static void main(String[] args)throws IOException{
		int n;
		while((n = System.in.read()) <= ' ' && n != -1);
		if(n == -1) return;
		int total = 0;
		while(n >= '0' && n <= '9'){
			total = total = total * 10 + (n - '0');
			n = System.in.read();
		}
		char[] map = new char[3 * total * total - total];
		int index = 0, i, j, dist, size = (total << 1) - 1;
		for(i = 0; i < size; ++i){
			dist = Math.abs(total - 1 - i);
			for(j = 0; j < dist; ++j) map[index++] = ' ';
			for(j = 0; j < size - (dist<<1); ++j) map[index++] = '*';
			map[index++] = '\n';
		}
		System.out.print(map);
	}
}
