import java.io.*;

class Main{
	public static void main(String[] args)throws IOException{
		int aux;
		int x = 0, y = 0;
		while((aux = System.in.read()) != -1 ){
			switch(aux) {
				case 'n':
					--y; break;
				case 's':
					++y; break;
				case 'e':
					++x; break;
				case 'o':
					--x; break;
			}			
		}
		System.out.println("(" + x + ", " + y + ')');
	}
}
