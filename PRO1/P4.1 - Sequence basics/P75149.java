import java.io.*;

class Main{
	public static void main(String[] args)throws IOException{
		boolean found = false;
		int aux;
		while((aux = System.in.read()) != -1 && !found){
			if(aux == '.') break;
			if(aux == 'a') found = true;
		}
		if(found) System.out.println("si");
		else System.out.println("no");
	}
}
