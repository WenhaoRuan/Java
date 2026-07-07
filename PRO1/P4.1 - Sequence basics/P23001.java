import java.io.*;

class Main{
	public static String readString()throws IOException{
		int n;
		while((n = System.in.read()) <= ' ' && n != -1);
		if(n == -1) return null;
		char aux;
		StringBuilder sb = new StringBuilder();
		while(n >= 'a' && n <= 'z'){
			aux = (char) n;
			sb.append(aux);
			n = System.in.read();
		}
		String res = sb.toString();
		return res;
	}

	public static void main(String[] args)throws IOException{
		int count = 1, max = 1;
		String pClau = readString(), aux;
		while((aux = readString()) != null){
			if(pClau.equals(aux)) ++count;
			else count = 0;
			if(count > max) max = count;
		}
		System.out.println(max);
	}
}
