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

    public static void main(String[] args)throws IOException{
        int iter;
        if((iter = readNat()) > 0){
            int[] counter = new int[1001];
            int aux;
            for(int i = 0; i < iter; ++i){
                aux = readNat();
                ++counter[aux - 1000000000];
            }
            for(int i = 0; i < 1001; ++i){
                if(counter[i] > 0){
                    aux = counter[i];
                    bw.write(String.valueOf(1000000000 + i));
                    bw.write(" : ");
                    bw.write(String.valueOf(aux));
                    bw.write('\n');
                }
            }
        }
        bw.close();
    }

}
