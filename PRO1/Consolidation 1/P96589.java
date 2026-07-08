import java.io.*;

class Main{
	public static void main(String[] args)throws IOException{
		int n;
		while((n = System.in.read()) != -1 && n!= '\n' && n != '\r'){
			if(n >= '0' && n <= '9') System.out.println("digit");
			else if(n >= 'A' && n <= 'Z' || n >= 'a' && n <= 'z') System.out.println("lletra");
			else System.out.println("res");
		}
	}
}
