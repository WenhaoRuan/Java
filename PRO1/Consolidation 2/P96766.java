import java.io.*;
import java.util.*;

class Main{
    private static BufferedInputStream bis = new BufferedInputStream(System.in);
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static boolean esPalindrom(String s){
        for(int i = 0; i < s.length() / 2; ++i)
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        return true;
    }

    public static String readString(StringBuilder sb)throws IOException{
        int n;
        while((n = bis.read()) <= ' ' && n != -1);
        if(n == -1) return null;
        sb.setLength(0);
        while(n >= 'A' && n <= 'Z'){
            sb.append((char)n);
            n = bis.read();
        }
        return sb.toString();
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
        int batch;
        StringBuilder sb = new StringBuilder();
        String s;
        bw.write("-----\n");
        while((batch = readNat()) > 0){
            String[] palindroms = new String[batch];
            int pals = 0, maxSize = 0;
            for(int i = 0; i < batch; ++i){
                if((s = readString(sb)) == null) break;
                if(esPalindrom(s)){
                    palindroms[pals++] = s;
                    if(maxSize < s.length()) maxSize = s.length();
                }
            }
            if(pals == 0) bw.write("cap palindrom\n");
            for(int i = 0; i < pals; ++i){
                if(palindroms[i].length() == maxSize){
                    bw.write(palindroms[i]);
                    bw.write('\n');
                }
            }
            bw.write("-----\n");
        }
        bw.close();
    }
}
