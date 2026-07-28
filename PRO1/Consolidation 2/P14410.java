import java.io.*;

class Main{
    private static BufferedInputStream bis = new BufferedInputStream(System.in);
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void convergeix(int n, int[] k, int[] lluny){
        if(lluny[0] < n) lluny[0] = n;
        if(n == 1) return;
        ++k[0];
        if((n & 1) == 0) convergeix(n >>> 1, k, lluny);
        else convergeix(n * 3 + 1, k, lluny);
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
        int m, p;
        if((m = readNat()) != -1 && (p = readNat()) != -1){
            int[] k = new int[1], lluny = new int[]{0};
            for(int i = 1; i <= m; ++i){
                k[0] = 0;
                convergeix(i, k, lluny);
                if(k[0] >= p){
                    bw.write(String.valueOf(i));
                    bw.write('\n');
                }
            }
            bw.write("S'arriba a ");
            bw.write(String.valueOf(lluny[0]));
            bw.write(".\n");
        }
        bw.close();
    }
}
