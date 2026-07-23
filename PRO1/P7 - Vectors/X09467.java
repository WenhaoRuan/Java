import java.io.*;

class Main{
    private static BufferedInputStream bis = new BufferedInputStream(System.in);
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static boolean EOF = false;

    public static int readInt()throws IOException{
        int n;
        while((n = bis.read()) <= ' ' && n != -1);
        if(n == -1) {EOF = true; return n;}
        boolean neg = (n == '-');
        if(neg) n = bis.read();
        int total = 0;
        while(n >= '0' && n <= '9'){
            total = total * 10 + (n - '0');
            n = bis.read();
        }
        return neg ? -total : total;
    }

    public static int[] readVec(int size)throws IOException{
        int[] v = new int[size];
        for(int i = 0; i < size; ++i) v[i] = readInt();
        return v;
    }

    public static boolean[] posRampas(int[] v){
        boolean[] res = new boolean[v.length - 2];
        for(int i = 0; i < v.length - 2; ++i){
            if(v[i] < v[i + 1] && v[i + 1] < v[i + 2]) res[i] = true;
            else if(v[i] > v[i + 1] && v[i + 1] > v[i + 2]) res[i] = true;
        }
        return res;
    }

    public static int potConflictives(boolean[] v){
        int total = 0;
        for(int i = 0; i < v.length -1; ++i) if(v[i] && v[i + 1]) ++total;
        for(int i = 0; i < v.length -2; ++i) if(v[i] && v[i + 2]) ++total;
        return total;
    }

    public static void main(String[] args)throws IOException{
        int size;
        while((size = readInt()) > 0 && !EOF){
            int[] v = readVec(size);
            boolean[] rampes = posRampas(v);
            bw.write("posicions amb rampa:");
            for(int i = 0; i < rampes.length; ++i)
                if(rampes[i]){ bw.write(' '); bw.write(String.valueOf(i));}
            bw.write("\npotencialment conflictives: ");
            bw.write(String.valueOf(potConflictives(rampes)));
            bw.write("\n---\n");
        }
        bw.close();
    }
}
