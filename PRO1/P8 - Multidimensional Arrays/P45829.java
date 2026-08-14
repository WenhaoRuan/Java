import java.io.*;
import java.util.*;

class Solution{
    public class IO{
        private static BufferedInputStream bis = new BufferedInputStream(System.in);
        private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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

        public static boolean readIMat(int[][] field)throws IOException{
            int rows = field.length, cols = field[0].length;
            for(int i = 0; i < rows; ++i){
                for(int j = 0; j < cols; ++j){
                    if((field[i][j] = readNat()) < 0) return false;
                }
            }
            return true;
        }

        public static void print(int n)throws IOException{
            bw.write(String.valueOf(n));
            bw.write('\n');
        }

        public static void end()throws IOException{
            bw.close();
        }
    }
    
    public class Game{
        private static int[][] DIRS = {
            {-1, 0}, {-1, 1}, {0, 1}, {1, 1},
            {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

        public static boolean posOk(int[][] field, int x, int y){
            if(x >= 0 && x < field.length && y >= 0 && y < field[0].length)
                return(field[x][y] != 0);
            return false;
        }

        public record Pos(int x, int y){}

        public static int BFS(int[][] field)throws IOException{
            int rows = field.length, cols = field[0].length;
            int count = 0;
            for(int x = 0; x < rows; ++x){
                for(int y = 0; y < cols; ++y){
                    if(field[x][y] != 0){
                        ++count;
                        Queue<Pos> Q = new ArrayDeque<>();
                        Q.add(new Pos(x, y));
                        while(!Q.isEmpty()){
                            Pos curr = Q.poll();
                            for(int[] dir : DIRS){
                                int newX = curr.x  + dir[0], newY = curr.y + dir[1];
                                if(posOk(field, newX, newY)){
                                    field[newX][newY] = 0;
                                    Q.add(new Pos(newX, newY));
                                }
                            }
                        }
                    }
                }
            }
            return count;
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        int rows, cols;
        while((rows = Solution.IO.readNat()) != -1 && (cols = Solution.IO.readNat()) != -1){
            int[][] field = new int[rows][cols];
            if(!Solution.IO.readIMat(field)) break;
            Solution.IO.print(Solution.Game.BFS(field));
        }
        Solution.IO.end();
    }
}

