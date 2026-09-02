import java.io.*;

enum Symbols{
    OPENBRA,
    CLOSEBRA,
    OPENPAR,
    CLOSEPAR;
}

class Solution{
    public static class IO{
        private static final BufferedInputStream bis = new BufferedInputStream(System.in);
        private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        public static int readChain(char[] res)throws IOException{
            int n;
            while((n = bis.read()) < ' ' && n != -1);
            if(n == -1) return n;
            int len = 0;
            while(n > ' '){
                res[len++] = (char) n;
                n = bis.read();
            }
            return len;
        }

        public static void printRes(boolean ok)throws IOException{
            if(ok){
                bw.write("si\n");
                return;
            }
            bw.write("no\n");
        }

        public static void end()throws IOException{
            bw.close();
        }
    }

    public static class Game{
        public static int checkPar(char[] chain, int[] count, 
                int curr, int pos, int len){
            int againstCurr = 0, i = pos, aux;
            while(i < len){
                switch(chain[i]){
                    case ')' -> {
                        ++againstCurr;
                        ++count[Symbols.CLOSEPAR.ordinal()];
                        if(count[Symbols.CLOSEPAR.ordinal()] > 
                                count[Symbols.OPENPAR.ordinal()]) return -1;
                        ++i;
                    }
                    case '(' -> {
                        ++curr;
                        ++count[Symbols.OPENPAR.ordinal()];
                        ++i;
                    }
                    case ']' -> {
                        if(againstCurr == curr) return i;
                        return -1;
                    }
                    case '[' -> {
                        ++count[Symbols.OPENBRA.ordinal()];
                        aux = checkBra(chain, count, 1, i + 1, len);
                        if(aux == -1) return -1;
                        i = aux;
                    }
                    default -> { return -1; }
                }
            }
            return i;
        }

        public static int checkBra(char[] chain, int[] count, 
                int curr, int pos, int len){
            int againstCurr = 0, i = pos, aux;
             while(i < len){
                switch(chain[i]){
                    case ']' -> {
                        ++againstCurr;
                        ++count[Symbols.CLOSEBRA.ordinal()];
                        if(count[Symbols.CLOSEBRA.ordinal()] >
                                count[Symbols.OPENBRA.ordinal()]) return -1;
                        ++i;
                    }
                    case '[' -> {
                        ++curr;
                        ++count[Symbols.OPENBRA.ordinal()];
                        ++i;
                    }
                    case ')' -> {
                        if(againstCurr == curr) return i;
                        return -1;
                    }
                    case '(' -> {
                        ++count[Symbols.OPENPAR.ordinal()];
                        aux = checkPar(chain, count, 1, i + 1, len);
                        if(aux == -1) return -1;
                        i = aux;
                    }
                    default -> { return -1; }
                }
            }
            return i;
        }

        public static boolean slingshot(char[] chain, int[] count, int len){
            for(int i = 0; i < Symbols.values().length; ++i) count[i] = 0;
            int i = 0;
            while(i < len){
                switch(chain[i]){
                    case '(' -> {
                        int nextPos = checkPar(chain, count, 0, i, len);                            
                        if(nextPos == -1) return false;
                        i = nextPos;
                    }
                    case '[' -> {
                        int nextPos = checkBra(chain, count, 0, i, len);
                        if(nextPos == -1) return false;
                        i = nextPos;
                    }
                    default -> { return false; }
                }
            }
            return(count[Symbols.OPENPAR.ordinal()] ==
                count[Symbols.CLOSEPAR.ordinal()] && 
                count[Symbols.OPENBRA.ordinal()] == 
                count[Symbols.CLOSEBRA.ordinal()]);
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        char[] chain = new char[100005];
        int[] count = new int[Symbols.values().length];
        for(int len; (len = Solution.IO.readChain(chain)) != -1;)
            Solution.IO.printRes(Solution.Game.slingshot(chain, count, len));
        Solution.IO.end();
    }
}
