import java.io.*;
import java.util.*;

class Solution{
    public class IO{
        private static BufferedInputStream bis = new BufferedInputStream(System.in);
        private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        public static boolean readInt(int res[])throws IOException{
            int n;
            while((n = bis.read()) <= ' ' && n != -1);
            if(n == -1) return false;
            boolean neg = (n == '-');
            if(neg) n = bis.read();
            int total = 0;
            while(n >= '0' && n <= '9'){
                if(neg) total = total * 10 - (n -'0');
                else total = total * 10 + (n - '0');
                n = bis.read();
            }
            res[0] = total;
            return true;
        }

        public static boolean readIMat(int[][] mat, int[] res)throws IOException{
            int rows = mat.length, cols = mat[0].length;
            for(int i = 0; i < rows; ++i){
                for(int j = 0; j < cols; ++j){
                    if(!readInt(res)) return false;
                    mat[i][j] = res[0];
                }
            }
            return true;
        }

        public static void print(boolean res)throws IOException{
            if(res) bw.write("si\n");
            else bw.write("no\n");
        }

        public static void end()throws IOException{
            bw.close();
        }
    }

    public class Game{
        public static final int[][] DIRS = {
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        
        public static boolean check(int[][] mat, int x, int y){
            int rows = mat.length, cols = mat[0].length;
            int[] lens = {
                Math.min(rows - x, cols - y),
                Math.min(rows - x, y + 1),
                Math.min(x + 1, cols - y),
                Math.min(x + 1, y + 1)
            };
            int maxLen = 0;
            for(int l : lens) if(l > maxLen) maxLen = l;
            int[] currs = new int[4];
            currs[0] = currs[1] = currs[2] =  currs[3] = mat[x][y];

            for(int i = 1; i < maxLen; ++i){
                for(int d = 0; d < DIRS.length; ++d){
                    if(i < lens[d]){
                        int newX = x + i * DIRS[d][0];
                        int newY = y + i * DIRS[d][1];
                        if(currs[d] >= mat[newX][newY]) return false;
                        currs[d] = mat[newX][newY];
                    }
                }
            }
            return true;
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        int[] rows = new int[1], cols = new int[1], aux = new int[1],
            x = new int[1], y  = new int[1];
        while(Solution.IO.readInt(rows) && Solution.IO.readInt(cols)){
            int[][] mat = new int[rows[0]][cols[0]];
            if(!Solution.IO.readIMat(mat, aux)) break;
            if(!Solution.IO.readInt(x) || !Solution.IO.readInt(y)) break;
            Solution.IO.print(Solution.Game.check(mat, x[0], y[0]));
        }
        Solution.IO.end();
    }
}
