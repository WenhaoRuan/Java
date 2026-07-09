import java.io.*;

class Main{
	public static int calculate(int n){
		int total = 0;
		while(n > 0){
			total += n%10;
			n /= 10;
		}
		return total;
	}

	public static void main(String[] args)throws IOException{
		int n, count = 0, total = 0, half = 1;
		boolean malfet = false;
		while((n = System.in.read()) <= ' ' && n != -1);
		if(n == -1) malfet = true;
		if(!malfet){
			while(n >= '0' && n <= '9'){
				total = total * 10 + (n -'0');
				n = System.in.read();
				++count;
				if((count & 1) == 0)half = half * 10;
			}
			if((count & 1) != 0) malfet = true;
		}
		if(malfet) System.out.println("res");
		else{
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int left = total/half, right = total - left * half;
			left = calculate(left); right = calculate(right);
			char[] sign = new char[3];
			if(left == right){ sign[0] = ' '; sign[1] = '='; sign[2] = ' ';}
			else if(left < right) { sign[0] = ' '; sign[1] = '<'; sign[2] = ' ';}
			else { sign[0] = ' '; sign[1] = '>'; sign[2] = ' ';}
			bw.write(Integer.toString(left));
			bw.write(sign);
			bw.write(Integer.toString(right));
			bw.newLine();
			bw.flush();
		}
	}
}
