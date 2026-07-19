import java.io.*;

class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n = 0;

	public static int readAndWrite()throws IOException{
		String line = br.readLine();
		if(line == null) return 0;
		++n;
		int aux = 1 + readAndWrite();
		if(aux > (n - (n >> 1))){
			bw.write(line);
			bw.write('\n');
		}
		return aux;
	}

	public static void main(String[] args)throws IOException{
		readAndWrite();
		bw.close();
	}
}
