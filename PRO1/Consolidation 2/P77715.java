import java.io.*;
import java.util.*;

class Main{
    private static BufferedInputStream bis = new BufferedInputStream(System.in);
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int readChar()throws IOException{
        int n;
        while((n = bis.read()) <= ' ' && n != -1);
        if(n == -1) return -1;
        if(n == '.') return n;
        else if(n >= 'A' && n <= 'Z') return n - 'A';
        else return n - 'a';
    }

    public static int compute(boolean[] alphabet)throws IOException{
        int aux, counter = 0;
        while((aux = readChar()) != '.'){
            if(aux == -1) return -1;
            if(aux >= 0 && aux <= 25 && !alphabet[aux]){
                ++counter;
                alphabet[aux] = true;
            }
        }
        return counter;
    }

    public static void main(String[] args)throws IOException{
        boolean[] alphabet = new boolean[26];
        int res;
        while((res = compute(alphabet)) != -1){
            if(res == 26) bw.write("SI\n");
            else bw.write("NO\n");
            Arrays.fill(alphabet, false);
        }
        bw.close();
    }
}    


