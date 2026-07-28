import java.io.*;

class Main{
    private static BufferedInputStream bis = new BufferedInputStream(System.in);
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static int compara(int d1, int m1, int a1, int d2, int m2, int a2){
        if(a1 == a2){
            if(m1 == m2){
                if(d1 == d2) return 0;
                else if(d1 < d2) return -1;
                else return 1;
            }
            else if(m1 < m2) return -1;
            else return 1;
        }
        else if(a1 < a2) return -1;
        else return 1;
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
        int d1, m1, a1, d2, m2, a2;
        int aux;
        while((d1 = readNat()) > 0){
            m1 = readNat();
            a1 = readNat();
            d2 = readNat();
            m2 = readNat();
            a2 = readNat();
            aux = compara(d1, m1, a1, d2, m2, a2);
            if(aux < 0) bw.write("anterior\n");
            else if( aux == 0) bw.write("iguals\n");
            else bw.write("posterior\n");
        }
        bw.close();
    }
}
