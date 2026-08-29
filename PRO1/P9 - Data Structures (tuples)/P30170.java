import java.io.*;
import java.util.*;

class Solution{
    public static class IO{
        private static final BufferedInputStream bis = new BufferedInputStream(System.in);
        private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        private static final char[] buff = new char[256];

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
            int len = 0;
            while(n > ' '){
                buff[len++] = (char) n;
                n = bis.read();
            }
            return new String(buff, 0, len);
        }

        public static HashMap<String, Integer> readMap(int cases)throws IOException{
            if(cases <= 0) return null;
            HashMap<String, Integer> res = new HashMap<>();
            for(int i = 0; i < cases; ++i){
                String word = readString();
                if(word == null) return null;
                res.merge(word, 1, Integer::sum);
            }
            return res;
        }
      
        public static void printNat(int n)throws IOException{
            if(n == 0){
                bw.write('0');
                return;
            }
            int pos = buff.length;
            while(n > 0){
                buff[--pos] = ((char)('0' + (n % 10)));
                n /= 10;
            }
            bw.write(buff, pos, buff.length - pos);
        }

        public static void printRes(final TreeMap<Integer, Integer> m)throws IOException{
            for(Map.Entry<Integer, Integer> entry : m.entrySet()){
                printNat(entry.getKey());
                bw.write(" : ");
                printNat(entry.getValue());
                bw.write('\n');
            }
            bw.write('\n');
        }

        public static void end()throws IOException{
            bw.close();
        }
    }

    public static class Game{
        public static TreeMap<Integer, Integer> counter(final HashMap<String, Integer> bag){
            if(bag == null) return null;
            TreeMap<Integer, Integer> res = new TreeMap<>();
            for(Map.Entry<String, Integer> entry : bag.entrySet())
                res.merge(entry.getValue(), entry.getKey().length(), Integer::sum);            
            return res;
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        int bagSize;
        while((bagSize = Solution.IO.readNat()) > 0)
            Solution.IO.printRes(Solution.Game.counter(Solution.IO.readMap(bagSize)));
        Solution.IO.end();
    }
}
