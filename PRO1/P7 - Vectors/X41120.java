import java.io.*;

class Main{
    private static BufferedInputStream bis = new BufferedInputStream(System.in);
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int Size = 0;

    public static int[] calculaCims(int[] v){
        int[] cims = new int[v.length/2];
        for(int i = 1; i < v.length - 1; ++i){
            if(v[i - 1] < v[i] && v[i] > v[i + 1]) cims[Size++] = v[i];
        }
        return cims;
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

    public static int[] readVec(int size)throws IOException{
       int[] v = new int[size];
       for(int i = 0; i < size; ++i) v[i] = readNat();
       return v;
    }

    public static void main(String[] args)throws IOException{
        int size;
        if((size = readNat()) != -1){
            int[] v = readVec(size);
            int[] cims = calculaCims(v);
            bw.write(String.valueOf(Size));
            bw.write(":");
            for(int i = 0; i < Size; ++i){
                bw.write(' ');
                bw.write(String.valueOf(cims[i]));
            }
            bw.write('\n');
            boolean something = false;
            for(int i = 0; i < Size - 1; ++i){
                if(cims[i] > cims[Size - 1]){
                    if(something) bw.write(' ');
                    else something = true;
                    bw.write(String.valueOf(cims[i]));
                }
            }
            if(!something) bw.write('-');
            bw.write('\n');
        }
        bw.close();
    }
}
