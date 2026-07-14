import java.io.*;

class Main{
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void output(String s, char c, boolean b)throws IOException{
		bw.write(s);
		bw.write("('");
		bw.write(c);
		bw.write("') = ");
		bw.write(b ? "cert" : "fals");
		bw.write('\n');
	}

	public static void main(String[] args)throws IOException{
		int n;
		while((n = System.in.read()) <= ' ' && n != -1);
		if(n == -1) return;
		boolean ll = false, vo = false, con = false, maj = false, min = false, di = false;
		char c = (char) n;
		if(n >= '0' && n <= '9') di = true;
		else if(n >= 'A' && n <= 'Z'){
			ll = true;
			maj = true;
			if(n == 'A' || n == 'E' || n == 'I' || n == 'O' || n == 'U') vo = true;
			else con = true;
		}
		else if(n >= 'a' && n <= 'z'){
			ll = true;
			min = true;
			if(n == 'a' || n == 'e' || n == 'i' || n == 'o' || n == 'u') vo = true;
			else con = true;
		}
		output("lletra", c, ll);
		output("vocal", c, vo);
		output("consonant", c, con);
		output("majuscula", c, maj);
		output("minuscula", c, min);
		output("digit", c, di);
		bw.flush();
		bw.close();
	}
}

