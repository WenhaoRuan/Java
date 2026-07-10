import java.io.*;

class Main{
	public static boolean isEOF = false;

	public static int readInt()throws IOException{
		int n;
		while((n = System.in.read()) <= ' ' && n != -1);
		if(n == -1){
			isEOF = true;
		       	return n;
		}
		int total = 0;
		boolean neg = (n == '-');
		if(neg) n = System.in.read();
		while(n >= '0' && n <= '9'){
			total = total * 10 + (n - '0');
			n = System.in.read();
		}
		return neg ? -total : total;
	}

	public static void main(String[] args)throws IOException{
		int iter, max = 0;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true){
			iter = readInt();
			if(isEOF) break;
			boolean initialized = false;
			int aux;
			for(int i = 0; i < iter; ++i){
				aux = readInt();
				if(isEOF) break;
				if(!initialized) {
					max = aux;
					initialized = true;
				}
				else if(aux > max) max = aux;
			}
			bw.write(String.valueOf(max));
			bw.write('\n');
		}
		bw.flush();
	}
}
