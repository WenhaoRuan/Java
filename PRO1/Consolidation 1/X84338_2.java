import java.io.*;

class Main{
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		if(input == null) return;
		input = input.trim();
		if(input.isEmpty()) return;
		int len = input.length();
		if((len & 1) == 0){
			int leftSum = 0, rightSum = 0, half = len >> 1;
			StringBuilder sb = new StringBuilder();
			for(int i = 0 ; i < half; ++i){
				leftSum += input.charAt(i) - '0';
				rightSum += input.charAt(i + half) - '0';
			}
			char[] sign = new char[3];
			sign[0] = ' '; sign[1] = '='; sign[2] = ' ';
			if(leftSum < rightSum) sign[1] = '<';
			else if(leftSum > rightSum) sign[1] = '>';
			sb.append(leftSum).append(sign).append(rightSum);
			System.out.println(sb);		
		}
		else System.out.println("res");
	}
}
