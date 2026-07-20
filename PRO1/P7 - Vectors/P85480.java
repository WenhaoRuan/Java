import java.io.*;

class Main{
    private static BufferedInputStream bis = new BufferedInputStream(System.in);
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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
    
    public static void readVec(int[] v)throws IOException{
        for(int i = 0; i < v.length; ++i) v[i] = readNat();
    }

    public static boolean prime(int n){
        if(n <= 1) return false;
        if(n <= 3) return true;
        if((n & 1) == 0) return false;
        if(n%3 == 0) return false;
        for(int i = 5; i * i <= n; i += 6)
            if(n % i == 0 || n % (i + 2) == 0) return false;
        return true;
    }
    
    public static boolean pairPrime(int[]v){
        for(int i = 0; i < v.length; ++i){
            for(int j = i + 1; j < v.length; ++j){
                if(prime(v[i] + v[j])) return true;
            }
        }
        return false;
    }

    public static void main(String[] args)throws IOException{
        int size;
        while((size = readNat()) != -1){
            int[] v = new int[size];
            readVec(v);
            if(pairPrime(v)) bw.write("yes");
            else bw.write("no");
            bw.write('\n');
        }
        bw.close();
    }
}
