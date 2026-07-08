import java.io.*;

class Main{
	public static int readInt()throws IOException{
		int n;
		while((n = System.in.read()) <= ' ' && n != -1);
		if(n == -1) return n;
		int total = 0;
		while(n >= '0' && n <= '9'){
			total = total * 10 + (n -'0');
			n = System.in.read();
		}
		return total;
	}
	
	public static void main(String[] args)throws IOException{
		int n, aux;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while((n = readInt()) != -1){
			for(int i = n/7; i >= 0; --i){
				if(((aux =n - 7 * i)&3) == 0){
					bw.write(i + " " + (aux >> 2) + '\n');
					break;
				}
			}
		}
		bw.flush();
	}
}
