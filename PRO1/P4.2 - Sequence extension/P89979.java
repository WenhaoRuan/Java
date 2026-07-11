import java.io.*;

class Main{
	public static int readStringAndGetNext(StringBuilder sb)throws IOException{
		int n;
		while((n = System.in.read()) <= ' ' && n != -1);
		if(n == -1) return n;
		sb.setLength(0);
		while(n >= 'a' && n <= 'z'){
			sb.append((char)n);
			n = System.in.read();
		}
		return n;
	}

	public static int readNat()throws IOException{
		int n;
		while((n = System.in.read()) <= ' ' && n != -1);
		if(n == -1) return n;
		int total = 0;
		while(n >= '0' && n <= '9'){
			total = total * 10 + (n - '0');
			n = System.in.read();
		}
		return total;
	}

	public static void main(String[] args)throws IOException{
		int iter;
		StringBuilder s1 = new StringBuilder(), s2 = new StringBuilder();
		int loop = 0;
		boolean found = false;
		while((iter = readNat()) != -1 && !found){
			s1.setLength(0); s2.setLength(0);
			++loop;
			if(iter <= 1){ found = true; break;}
			int aux;
			for(int i = 0; i < iter; ++i){
				int nextChar;
				if((nextChar = readStringAndGetNext(s1)) == -1 || s1.isEmpty()) break;
				if(s2.isEmpty()) s2.append(s1);
				else{
					if((s1.compareTo(s2)) < 0){
						if(nextChar != '\n') 
							while((aux = System.in.read()) != '\n' && aux != '\r' && aux != -1);
						break;
					}
					else if(i == iter - 1 && (s1.compareTo(s2)) >= 0) found = true;
					else{
						s2.setLength(0);
						s2.append(s1);
					}
				}
			}	
		}
		if(found) System.out.println("La primera linia ordenada creixentment es la " + loop + '.');
		else System.out.println("No hi ha cap linia ordenada creixentment.");
	}
}
