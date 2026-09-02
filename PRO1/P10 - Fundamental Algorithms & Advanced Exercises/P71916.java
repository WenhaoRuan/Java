import java.io.*;
import java.util.*;

class Solution{
    private static final BufferedInputStream bis = new BufferedInputStream(System.in);
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int readNat()throws IOException{
        int n;
        while((n = bis.read()) <= ' ' && n != -1);
        if(n == -1) return -1;
        int total = 0;
        while(n > ' '){
            total = total * 10 + (n - '0');
            n = bis.read();
        }
        return total;
    } 

    public static int readAndCount(int[] counter)throws IOException{
        int n;
        while((n = bis.read()) <= ' ' && n != -1);
        if(n == -1) return -1;
        int total = 0;
        while(n != '.' && n != -1){
            if(n >= 'A' && n <= 'Z'){
                ++counter[n - 'A'];
                ++total;
            }
            n = bis.read();
        }
        return total;
    }

    public static int readAndDiscount(int[] counter, int len)throws IOException{
        int n;
        while((n = bis.read()) <= ' ' && n != -1);
        if(n == -1) return -1;
        int total = 0;
        boolean ok = true;
        while(n != '.' && n != -1){
            if(n >= 'A' && n <= 'Z'){
                ++total;
                if(--counter[n - 'A'] < 0) ok = false;
            }
            n = bis.read();
        }
        return ok ? total : -2;
    }

    public static void printRes(boolean res)throws IOException{
        if(res){
            bw.write("SI\n");
            return;
        }
        bw.write("NO\n");
    }

    public static void end()throws IOException{
        bw.close();
    }
}            

class Main{
    public static void main(String[] args)throws IOException{
        int cases = Solution.readNat();
        if(cases <= 0) return;
        int[] counter = new int[26];
        for(int i = 0; i < cases; ++i){
            int len = Solution.readAndCount(counter);
            if(len == -1) break;
            int len2 = Solution.readAndDiscount(counter, len);
            if(len2 == -1) break;
            if(len == len2) Solution.printRes(true);
            else{
                Solution.printRes(false);
                Arrays.fill(counter, 0);
            }
        }
        Solution.end();
    }
}
