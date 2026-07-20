import java.io.*;

class Main{
    private static BufferedInputStream bis = new BufferedInputStream(System.in);
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static boolean EOF = false;

    public static int readInt()throws IOException{
        int n;
        while((n = bis.read()) <= ' ' && n != -1);
        if(n == -1){ EOF = true; return n;}
        boolean neg = (n == '-');
        if(neg) n = bis.read();
        int total = 0;
        while(n >= '0' && n <= '9'){
            total = total * 10 + (n - '0');
            n = bis.read();
        }
        return neg ? - total : total;
    }

    public static void readVec(int[] v)throws IOException{
        for(int i = 0; i < v.length; ++i) v[i] = readInt();
    }

    public static boolean sumaAltres(int[]v){
        boolean found = false;
        int total = 0;
        for(int i = 0; i < v.length; ++i) total += v[i];
        for(int i = 0; i < v.length && !found; ++i)if(v[i] == total - v[i]) found = true;
        return found;
    }

    public static void main(String[] args)throws IOException{
        int size;
        while((size = readInt()) > 0){
            if(EOF) break;
            int[] v = new int[size];
            readVec(v);
            if(sumaAltres(v)) bw.write("YES");
            else bw.write("NO");
            bw.write('\n');
        }
        bw.close();
    }
}
