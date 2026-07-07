import java.io.*;

class Main{
	public static void main(String[] args)throws IOException{
		int left = 0, right = 0, par;
		boolean correct = true;
		while((par = System.in.read()) != -1 && par != '\n'&& par != '\r' && correct){
			if(par == '(') ++left;
			if(par == ')') ++right;
			if(right > left) correct = false;
		}
		if(left != right) correct = false;
		if(correct) System.out.println("si");
		else System.out.println("no");
	}
}
