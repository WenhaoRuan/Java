import java.io.*;

class Main{
	public static void main(String[] args)throws IOException{
		int aux;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean first = true;
		while((aux = System.in.read()) != -1){
			if(aux <= ' ') continue;
			int n = aux - '0';
			char number = (char) aux;
			char[] res = new char[n * (n + 1)];
			int index = 0;
			for(int i = 0; i < n; ++i){
				for(int j = 0; j < n; ++j) res[index++] = number;
				res[index++] = '\n';					
			}
			if(!first) bw.write('\n');
			else first = false;
			bw.write(res);
		}
		bw.flush();
		if(aux == -1)return;
	}
}
