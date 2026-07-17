import java.io.*;

class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int readAndWrite(int n)throws IOException{
		String line = br.readLine();
		if(line == null) return 0;
		int aux = 1 + readAndWrite(n);
		if(aux <= n){
			bw.write(line);
			bw.write('\n');
		}
		return aux;		
	}
	
	public static void main(String[] args)throws IOException{
		String firstLine = br.readLine();
		if(firstLine != null){
			int n = Integer.parseInt(firstLine.trim());
			readAndWrite(n);
		}
		bw.close();
	}
}
