import java.io.*;

class Main{
	public static String readString()throws IOException{
		int n;
		while((n = System.in.read()) <= ' ' && n != -1);
		if(n == -1) return null;
		StringBuilder sb = new StringBuilder();
		while(n >= 'A' && n <= 'Z' || n >= 'a' && n <= 'z'){
			sb.append((char)n);
			n = System.in.read();
		}
		return sb.toString();
	}

	public static void main(String[] args)throws IOException{
		String s;
		int total = 0;
		while((s = readString()) != null) if("hola".equals(s)) ++total;
		System.out.println(total);
	}
}
