import java.io.*;

class Solution{
    public static class IO{
        private static final BufferedInputStream bis = new BufferedInputStream(System.in);
        private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        private static final char[] buff = new char[7];

        public static int readNat()throws IOException{
            int n;
            while((n = bis.read()) <= ' ' && n != -1);
            if(n == -1) return n;
            int total = 0;
            while(n > ' '){
                total = total * 10 + (n - '0');
                n = bis.read();
            }
            return total;
        }

        public static void printInt(int n)throws IOException{
            if(n == 0){
                bw.write('0');
                return;
            }
            int len = buff.length;
            while(n > 0){
                buff[--len] = (char)('0' + (n % 10));
                n /= 10;
            }
            bw.write(buff, len, buff.length - len);
        }

        public static void printRes(int n, boolean primer)throws IOException{
            printInt(n);
            if(!primer) bw.write(" no");
            bw.write(" es primer\n");
        }

        public static void end()throws IOException{
            bw.close();
        }
    }

    public static class Game{
        private static final boolean[] noPrimer = new boolean[1000001];

        public static void initGarbell(int n){
            noPrimer[0] = noPrimer[1] = true;
            for(int p = 2; p * p <= n; ++p){
                if(!noPrimer[p]){
                    for(int i = p * p; i <= n; i += p){
                        noPrimer[i] = true;
                    }
                }
            }
        }

        public static boolean esPrimer(int n){
            return !noPrimer[n];
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        int primer;
        Solution.Game.initGarbell(1000000);
        while((primer = Solution.IO.readNat()) != -1)
            Solution.IO.printRes(primer, Solution.Game.esPrimer(primer));
        Solution.IO.end();
    }
}
