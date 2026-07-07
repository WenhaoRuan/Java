import java.io.*;

class Main{
	public static String readString()throws IOException{
		int n;
		while((n = System.in.read()) <= ' ' && n != -1);
		if(n == -1) return null;
		StringBuilder sb = new StringBuilder();
		char aux;
		while(n >= 'a' && n <= 'z'){
			aux = (char) n;
			sb.append(aux);
			n = System.in.read();
		}
		return sb.toString();
	}

	public static void main(String[] args)throws IOException{
		String start = "principi", end = "final", aux;
		boolean started = false, ended = false;
		int total = 0;
		while((aux = readString()) != null && !ended){
			if(started){
				if(aux.equals(end)) ended = true;
				else ++total;
			}
			if(aux.equals(start)) started = true;
		}
		if(ended) System.out.println(total);
		else System.out.println("sequencia incorrecta");
	}
}
