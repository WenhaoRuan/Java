import java.io.*;

class Coord{
    int x, y;
    
    Coord(){
        this(0, 0);
    }

    Coord(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution{
    public static class IO{
        private static final BufferedInputStream bis = new BufferedInputStream(System.in);
        private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        public static int readNat()throws IOException{
            int n;
            while((n = bis.read()) <=  ' ' && n != -1);
            if(n == -1) return n;
            int total = 0;
            while(n >= '0' && n <= '9'){
                total = total * 10 + (n - '0');
                n = bis.read();
            }
            return total;
        }
        public static char readChar()throws IOException{
            int n;
            while((n = bis.read()) <=  ' ' && n != -1);
            if(n == -1) return '\0';
            return (char) n;
        }

        public static char[][] readCharMat(int rows, int cols)throws IOException{
            char[][] m = new char[rows][cols];
            for(int i = 0; i < rows; ++i)
                for(int j = 0; j < cols; ++j)
                    if((m[i][j] = readChar()) == '\0') return null;
            return m;
        }
        
        public static void printString(final char[] res, int start, int len)throws IOException{
            bw.write(res, start, len);
        }

        public static void end()throws IOException{
            bw.close();
        }
    }

    public static class Game{
        private static final char[] res = new char[256];

        public static Coord seguentD(final Coord p, int n){
            if(p.x == n - 1 && p.y == n - 1) return new Coord(0, 0);
            int sum = p.x + p.y;
            if(p.x == 0 || p.y == n -1){
                if(sum < n - 1) return new Coord(sum + 1, 0);
                else return new Coord(n - 1, sum - n + 2);
            }
            return new Coord(p.x - 1, p.y + 1);
        }

        public static int desencripta(final char[][] m, char[] res,
                int dist, int mLen, final Coord ini){
            Coord curr = new Coord(ini.x, ini.y);
            for(int iter = 0; iter < mLen;){
                res[iter++] = m[curr.x][curr.y];
                for(int i = 0; i <= dist; ++i){
                    curr = seguentD(curr, m.length);
                }
            }
            int resLen = 0;
            for(int i = 0; i < mLen;){
                if(res[i] == 'X' && i < mLen - 1){
                    if(res[i + 1] == 'X'){
                        res[resLen++] = ' ';
                        i += 2;
                        continue;
                    }
                }
                res[resLen++] = res[i];
                ++i;
            }
            res[resLen++] = '\n';
            return resLen;
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        int mSize, dist, mLen, x, y;
        char[] res = new char[256];
        while((mSize = Solution.IO.readNat()) != -1 &&
                (dist = Solution.IO.readNat()) != -1 &&
                (mLen = Solution.IO.readNat()) != -1 &&
                (x = Solution.IO.readNat()) != -1 &&
                (y = Solution.IO.readNat()) != -1){
            Coord ini = new Coord(x, y);
            char[][] m = Solution.IO.readCharMat(mSize, mSize);
            if(m == null) break;
            int resLen = Solution.Game.desencripta(m, res, dist, mLen, ini);
            Solution.IO.printString(res, 0, resLen);
        }
        Solution.IO.end();
    }
}
