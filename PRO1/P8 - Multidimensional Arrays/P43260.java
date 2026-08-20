import java.io.*;
import java.util.*;

class Solution{
    public class IO{
        private static BufferedInputStream bis = new BufferedInputStream(System.in);
        private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        public static int readByte()throws IOException{
            int n;
            while((n = bis.read()) <= ' ' && n != -1);
            return n;
        }
        
        public static void print(char[][] mat)throws IOException{
            for(char[] row : mat){
                bw.write(row);
                bw.write('\n');
            }
        }
            
        public static void end()throws IOException{
            bw.close();
        }
    }

    public class Game{
        private final static int[][] DIRS = {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}, {0, 0}}; 

        public static void initialize(char[][] mat){
            for(char[] row: mat) Arrays.fill(row, ' ');
            int lastCol = mat[0].length - 1;
            for(int i = 0; i < mat.length; ++i){
                mat[i][0] = '|';
                mat[i][lastCol] = '|';
            }
        }

        public static void creu(char[][] mat, int n, int x, int y, int separation){
            mat[x-1][y] = '|';
            mat[x+1][y] = '|';
            mat[x][y-1] = '-';
            mat[x][y+1] = '-';
            mat[x][y] = 'O';
            if(n > 1){
                int next = separation / 3;
                for(int[] dir : DIRS){
                    int newX = x + separation * dir[0], newY = y + separation * dir[1];
                    creu(mat, n - 1, newX, newY, next);
                }
            }
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        int size;
        if((size = Solution.IO.readByte()) != - 1){
            size -= '0';
            int matSize = 1;
            for(int i = 0; i < size; ++i) matSize *= 3;
            char[][] mat = new char[matSize][matSize + 2];
            Solution.Game.initialize(mat);
            Solution.Game.creu(mat, size, matSize >> 1, (matSize >> 1) + 1, matSize/3);
            Solution.IO.print(mat);
        }
        Solution.IO.end();
    }    
}
