import java.io.*;

class Main{
	//they want us to implement a func that recieves the res on two int parameters
	//passed by reference but theres no such thing as manual referencing ints
	//on java since its all done internally and automatically, therefore a way to 
	//replace that method and still mantain the essence is creating global variables
	//and updating these in my opinion whilst keeping the method void as asked.
	static int suma = -1, ultim = -1;
	
	static BufferedInputStream bis = new BufferedInputStream(System.in);

	public static int readNat()throws IOException{
		int n;
		while((n = bis.read()) <= ' ' && n != -1);
		if(n == -1) return -1;
		int total = 0;
		while(n >= '0' && n <= '9'){
			total = total * 10 + (n - '0');
			n = bis.read();
		}
		return total;
	}

	public static void info_sequencia()throws IOException{
		int n;
		suma = 0;
		ultim = 0;
		while((n = readNat()) != 0){
			suma += n;
			ultim = n;
		}
	}

	public static void main(String[] args)throws IOException{
		int total = 1, sumaf = -1, ultimf = -1;
		while(true){
			info_sequencia();
			if(suma == 0) break;
			if(sumaf == -1){ sumaf = suma; ultimf = ultim;}
			else if(suma == sumaf && ultim == ultimf) ++total;
		}
		System.out.println(total);
	}
}
