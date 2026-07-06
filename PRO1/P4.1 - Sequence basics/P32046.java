import java.io.*;

class Main{
	public static int readInt()throws IOException{
		int n;
		while((n = System.in.read()) <= ' ' && n != -1);
		if(n == -1) return -1;
		int total = 0;
		while(n >= '0' && n <= '9'){
			total = total * 10 + (n - '0');
			n = System.in.read();
		}
		return total;
	}

	public static void main(String[] args)throws IOException{
		int n = readInt();
		int aux, total = 0;
		System.out.println("nombres que acaben igual que " + n + ':');
		n = n%1000;
		while((aux = readInt()) != -1){
			if(aux%1000 == n){
			System.out.println(aux);
			++total;
			}
		}
		System.out.println("total: " + total);
	}
}
