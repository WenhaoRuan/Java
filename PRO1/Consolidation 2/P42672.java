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

    public static int countBits(int n){
        if(n == 0) return 1;
        return 32 - Integer.numberOfLeadingZeros(n);
    }

    public static char[] bitMixer(int n1, int n2){
        int size = countBits(n1) * 2;
        char[] barreja = new char[size];
        for(int i = size - 1; i >= 0; --i){
            if((i & 1) == 0){
                barreja[i] = (char)((n1 & 1) + '0');
                n1 >>= 1;
            }
            else{
                barreja[i] = (char)((n2 & 1) + '0');
                n2 >>= 1;
            }
        }
        return barreja;
    }
    public static void main(String[] args)throws IOException{
        int n1, n2;
        while((n1 = readNat()) != -1 && (n2 = readNat()) != -1){
            bw.write(bitMixer(n1, n2));
            bw.write('\n');
        }
        bw.close();
    }
}
