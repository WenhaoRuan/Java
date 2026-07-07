import java.io.*;

class Main{
	public static String readString()throws IOException{
		int n;
		while((n = System.in.read()) <= ' ' && n != -1);
		if(n == -1) return null;
		StringBuilder sb = new StringBuilder();
		char aux;
		while(n >= 'a' && n <= 'z'){
			aux = (char)n;
			sb.append(aux);
			n = System.in.read();
		}
		return sb.toString();
	}

	public static void main(String[] args)throws IOException{
		String first = null, second = null, aux;
		while((aux = readString()) != null){
			if(first == null) first = aux;
			else if(!aux.equals(first)){
				if(aux.compareTo(first) > 0){
					second = first;
					first = aux;
				}
				else if(second == null || aux.compareTo(second) > 0) second = aux;
			}
		}
		System.out.println(second);
	}
}
