import java.io.*;
import java.text.DecimalFormat;

class Main{
    private static BufferedInputStream bis = new BufferedInputStream(System.in);
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static double eApprox(int n){
        double total = 0 , aux = 1;
        for(int i = 0; i < n; ++i){
            if(i > 0) aux /= i;
            total += aux;
        }
        return total;
    }

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
    
    public static void main(String[] args)throws IOException{
        int n;
        DecimalFormat df = new DecimalFormat("0.0000000000");
        while((n = readNat()) != -1){
            bw.write("Amb ");
            bw.write(String.valueOf(n));
            bw.write(" terme(s) s'obte ");
            bw.write(df.format(eApprox(n)));
            bw.write('.');
            bw.write('\n');
        }
        bw.close();
    }
}

