import java.io.*;
import java.util.*;

class Main{
    private static BufferedInputStream bis = new BufferedInputStream(System.in);
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static char[] doubleBuf = new char[64];    
    
    public static double readDouble(char[] auxVec)throws IOException{
        int n;
        while((n = bis.read()) <= ' ' && n != -1);
        if(n == -1) return Double.NaN;
        int len = 0;
        while(n > ' '){
            auxVec[len++] = (char) n;
            n = bis.read();
        }
        return Double.parseDouble(new String(auxVec, 0 , len));
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
    
    public static double[] readVec(int size, char[] auxVec)throws IOException{
        double[] v = new double[size];
        double aux;
        for(int i = 0; i < size; ++i) {
            if(Double.isNaN(aux = readDouble(auxVec))) break;
            v[i] = aux;
        }
        return v;
    }

    public static void calculaPosicions(double[] v, int[] p, int[] q){
        p[0] = 0;
        for(int i = 0; i < v.length; ++i){
            if(v[i] > v[p[0]]){
                q[0] = p[0];
                p[0] = i;
            }
        }
    }

    public static void main(String[] args)throws IOException{
        int size;
        int[] p = new int[1], q = new int[1];
        while((size = readNat()) != -1){
            char[] auxVec = new char[64];
            double[] v = readVec(size, auxVec);
            calculaPosicions(v, p, q);
            double total = 0.0;
            int P = p[0], Q = q[0];
            for(int i = Q; i <= P; ++i){
                total += v[i];
            }
            double average = total / (P - Q + 1);
            bw.write(String.format(Locale.US, "%.6f\n", average));
        }
        bw.flush();
        bw.close();
    }
}
