import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

class Main{
	public static void main(String[] args)throws IOException{
		double total = 0.0, aux, z = 0, exponent = 1;
		DecimalFormat df = new DecimalFormat("0.0000");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		if((input = br.readLine()) != null) z = Double.parseDouble(input.trim());
		if((input = br.readLine()) != null){
			StringTokenizer st = new StringTokenizer(input);
			while(st.hasMoreTokens()){
				String token = st.nextToken();
				double value = Double.parseDouble(token);
				total += value * exponent;
				exponent *= z;
			}
		}
		System.out.println(df.format(total));
	}
}
