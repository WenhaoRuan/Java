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

	public static int cruncher(int n){
		int total = 1, aux;
		if(n == 0) return 0;
		while(n > 0){
			if((aux = n%10) == 0){ total = 0; break;}
			total *= aux;
			n /= 10;
		}
		return total;
	}

	public static void main(String[] args)throws IOException{
		int n;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s1 = "El producte dels digits de ", s2 = " es ", s3 = ".\n";
		String s4 = "----------\n";
		while((n = readInt()) != -1){
			while(true){
				bw.write(s1);
			        bw.write(String.valueOf(n));
				bw.write(s2);
				bw.write(String.valueOf(n = cruncher(n)));
				bw.write(s3);
				if(n < 10) break;
			}
			bw.write(s4);
		}
		bw.flush();
	}

}
