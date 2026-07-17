import java.io.*;

class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void readAndWrite()throws IOException{
		String line = br.readLine();
		if(line == null || line.equals("fi")) return;
		readAndWrite();
		bw.write(line);
		bw.write('\n');
	}
	
	public static void main(String[] args)throws IOException{
		readAndWrite();
		bw.close();
	}
}
