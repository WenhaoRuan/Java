import java.io.*;

class Main{
	public static int readInt()throws IOException{
		int n;
		while((n = System.in.read()) <= ' ' && n != -1);
		if(n == -1) return 101;
		int total = 0;
		while(n >= '0' && n <= '9'){
			total = total * 10 + (n - '0');
			n = System.in.read();
		}
		return total;
	}

	public static void main(String[] args)throws IOException{
		int first = 101, second = 101, third = 101, aux;
		for(int i = 0; i < 3; ++i){
			aux = readInt();
			if(aux < first){ third = second; second = first; first = aux;}
			else if(aux < second) { third = second; second = aux;}
			else if(aux < third) third = aux;
		}
		StringBuilder sb = new StringBuilder();		
		for(int i = 0; i < 3; ++i){
			aux = System.in.read();
			switch(aux){
				case 'A':
					sb.append(first); break;
				case 'B':
					sb.append(second); break;
				case 'C':
					sb.append(third); break;

				default:
					break;
			}
			if(i < 2) sb.append(' ');
			else sb.append('\n');
		}
		System.out.print(sb);
	}

}

