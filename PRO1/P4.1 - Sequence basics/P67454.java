import java.io.*;

class Main{
	public static void main(String[] args)throws IOException{
		int total = 0;
		int aux;
		while((aux = System.in.read()) != -1){
			if(aux == '.') break;
			else if(aux == 'a') ++total;
		}
		System.out.println(total);
	}
}
