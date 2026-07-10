import java.io.*;

class Main{
	public static int readInt()throws IOException{
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
		int alt1, alt2, alt3, aux;
		if((alt1 = readInt()) == -1 || (alt2 = readInt()) == -1 || (alt3 = readInt()) == -1) return;
		boolean found = false;
		while((aux = readInt()) != -1 && !found){
			if(alt2 > 3143 && alt2 > alt1 && alt2 > alt3) found = true;
			alt1 = alt2; alt2 = alt3; alt3 = aux;
			if(aux == 0) break;
		}
		if(found) System.out.println("SI");
		else System.out.println("NO");
	}
}
