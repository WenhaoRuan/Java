import java.io.*;

class Main{
	//they want us to implement a method that recieves the res on two int parameters
	//passed by reference but theres no such thing as manual referencing ints
	//on java since its all done internally and automatically, therefore a way to 
	//replace that method and still mantain the essence is creating global variables
	//and updating these in my opinion whilst keeping the method void as asked.
	static int max = -1, pos = -1, pos2 = '-';
	
	static BufferedInputStream bis = new BufferedInputStream(System.in);

	public static int readNat()throws IOException{
		int n;
		while((n = bis.read()) <= ' ' && n != -1);
		if(n == -1) return n;
		int total = 0;
		while(n >= '0' && n <= '9'){
			total = total * 10 + (n - '0');
			n = bis.read();
		}
		return total;
	}

	public static void infoSequencia()throws IOException{
		int n, iter = 1;
		while((n = readNat()) != 0 && n != -1){
			if(n >= max){
				max = n;
				pos = iter;
			}
			++iter;
		} 
	}
	
	public static void infoSequencia2()throws IOException{
		int n, iter = 1;
		while((n = readNat()) != 0 && n != -1){
			if(pos2 == '-' && n == max){
				pos2 = iter;
			}
			++iter;
		} 
	}

	public static void main(String[] args)throws IOException{
		infoSequencia();
		infoSequencia2();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(max));
		bw.write(' ');
		bw.write(String.valueOf(pos));
		bw.write(' ');
		if(pos2 == '-') bw.write((char)pos2);
		else bw.write(String.valueOf(pos2));
		bw.write('\n');
		bw.close();
	}


}
