import java.io.*;

class Main{
	public static int CalcPref()throws IOException{
		int n;
		while((n = System.in.read()) <= ' ' && n != -1);
		if(n == -1) return 0;
		else if(n >= '0' && n <= '9') return n - '0';
		else{
			int aux1 = CalcPref(), aux2 = CalcPref();
			return switch(n){
				case '*' -> aux1 * aux2;
				case '+' -> aux1 + aux2;
				case '-' -> aux1 - aux2;
				case '/' -> aux1 / aux2;
				default -> 0;
			};
		}
	}

	public static void main(String[] args)throws IOException{
		System.out.println(CalcPref());
	}
}
