import java.io.*;
import java.util.*;

class Main{
    private static BufferedInputStream bis = new BufferedInputStream(System.in);
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();

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

    public static String readString()throws IOException{
        int n;
        while((n = bis.read()) <= ' ' && n != -1);
        if(n == -1) return null;
        sb.setLength(0);
        while(n >= 'a' && n <= 'z'){
            sb.append((char) n);
            n = bis.read();
        }
        return sb.toString();
    }

    public static ArrayList<String> readVec(int size)throws IOException{
        ArrayList<String> res = new ArrayList<> (size);
        for(int i = 0; i < size; ++i) res.add(readString());
        return res;
    }

    public static boolean conte(String s1, String s2){
        int len1 = s1.length(), len2 = s2.length();
        for(int i = 0; i <= len1 - len2; ++i){
            int j = 0;
            while(j < len2 && s1.charAt(i+j) == s2.charAt(j)) ++j;
            if(j == len2) return true;
        }
        return false;
    }

    public static void main(String[] args)throws IOException{
        int size;
        if((size = readNat()) > 0){
            ArrayList<String> bossa = readVec(size);
            for(int i = 0; i < size; ++i){
                bw.write(bossa.get(i));
                bw.write(':');
                for(int j = 0; j < size; ++j){
                    if(i == j){
                        bw.write(' ');
                        bw.write(bossa.get(j));
                    }
                    else if(bossa.get(i).length() >= bossa.get(j).length())
                        if(conte(bossa.get(i), bossa.get(j))){
                            bw.write(' ');
                            bw.write(bossa.get(j));
                        }
                }
                bw.write('\n');
            }
            bw.close();
        }
    }
}
