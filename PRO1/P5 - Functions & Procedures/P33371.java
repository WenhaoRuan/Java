import java.io.*;

class Main{
	static BufferedInputStream bis = new BufferedInputStream(System.in);

	public static int readNat()throws IOException{
		int n;
		while((n = bis.read()) <= ' ' && n != -1);
		if(n == -1) return -1;
		int total = 0;
		while(n >= '0' && n <= '9'){
			total = total * 10 + (n - '0');
			n = bis.read();
		}
		return total;
	}

	public static char cesarTrans(int c, int cesar){
		return (char) ((c - 'a' + cesar) % 26 + 'A');
	}

	public static void main(String[] args)throws IOException{
		int cesar, aux;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while((cesar = readNat()) != -1){
			if(cesar > 26) cesar %= 26;
			while((aux = bis.read()) <= ' ' && aux != -1);
			if(aux == -1) break;
			boolean over = false;
			while(aux > ' ' && !over){
				if(aux == '.'){
					bw.write('\n');
					over = true;
				}
				else if(aux == '_') bw.write(' ');
				else if(aux >= 'a' && aux <= 'z') bw.write(cesarTrans(aux, cesar));
				else bw.write((char)aux);
				aux = bis.read();
			}
		}
		bw.close();
	}
}
