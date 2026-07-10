import java.io.*;

class Main{
	public static int readNat()throws IOException{
		int n;
		while((n = System.in.read()) <= ' ' && n != -1);
		if(n == -1) return n;
		int total = 0;
		while(n >= '0' && n <= '9'){
			total= total * 10 + (n - '0');
			n = System.in.read();
		}
		return total;
	}

	public static void main(String[] args)throws IOException{
		int iter = readNat();
		if(iter == -1) return;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < iter; ++i){
			int aux, anterior = -1, total = 0;
			while((aux = readNat()) != -1 && aux != 0){
				if(anterior != -1 && aux > anterior) ++total;
				anterior = aux;
			}
			bw.write(String.valueOf(total));
			bw.write('\n');
		}
		bw.flush();
	}
}
