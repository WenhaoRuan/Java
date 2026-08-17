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

        public static void printBoard(boolean[][] mat)throws IOException{
            int rows = 10, cols = 10;
            bw.write("  12345678910\n");
            for(int i = 0; i < rows; ++i){
                bw.write((char)('a' + i));
                bw.write(' ');
                for(int j = 0; j < cols; ++j){
                    if(mat[i][j]) bw.write('X');
                    else bw.write('.');
                }
                bw.write('\n');
            }
            bw.write('\n');
        }

        public static void printGuess(int dist, int row, int col)throws IOException{
            bw.write((char)row);
            bw.write(String.valueOf(col));
            if(dist == 0) bw.write(" tocat!\n");
            else{
                bw.write(" aigua! vaixell mes proper a distancia ");
                bw.write(String.valueOf(dist));
                bw.write('\n');
            }
        }

        public static void end()throws IOException{
            bw.close();
        }
    }

    public class Game{
        public static int[][] DIRS = {
            {-1, 0}, {-1, 1}, {0, 1}, {1, 1},
            {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

        public record Pos(int x, int y){}

        public static boolean posOk(boolean[][] mat, int x, int y){
            return (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length);
        }

        public static int BFS(boolean[][] mat, int x, int y){
            Queue<Pos> Q = new ArrayDeque<>();
            Q.add(new Pos(x, y));
            int[][] dist = new int[mat.length][mat[0].length];
            dist[x][y] = 1;
            while(!Q.isEmpty()){
                Pos curr = Q.poll();
                if(mat[curr.x][curr.y]) return dist[curr.x][curr.y] - 1;                
                for(int[] dir : DIRS){
                    int newX = curr.x + dir[0], newY = curr.y + dir[1];
                    if(posOk(mat, newX, newY) && dist[newX][newY] == 0){
                        Q.add(new Pos(newX, newY));
                        dist[newX][newY] = dist[curr.x][curr.y] + 1;
                    }
                }
            }
            return -1;
        }

        public static void embaixella(boolean[][] mat, int x, int y, int size, int orientacio){
            switch(orientacio){
                case 'h' -> {
                    for(int j = y; j < y + size; ++j) mat[x][j] = true;
                }
                default -> {
                    for(int i = x; i < x + size; ++i) mat[i][y] = true;
                }
            }
        }
    }    
}

class Main{
    public static void main(String[] args)throws IOException{
        int x, y, size, orientacio;
        boolean okay = true;
        boolean[][] mat = new boolean[10][10];
        for(int i = 0; i < 10; ++i){
            if((x = Solution.IO.readByte()) == -1 || 
                    (y = Solution.IO.readNat()) == -1 ||
                    (size  = Solution.IO.readNat()) == -1 || 
                    (orientacio = Solution.IO.readByte()) == -1){
                okay = false;
                break;
            }
            Solution.Game.embaixella(mat, x - 'a', y - 1, size, orientacio);
        }
        Solution.IO.printBoard(mat);
        while((x = Solution.IO.readByte()) != -1 &&
                (y = Solution.IO.readNat()) != -1){
            if(mat[x - 'a'][y - 1]) Solution.IO.printGuess(0, x, y);
            else Solution.IO.printGuess(Solution.Game.BFS(mat, x - 'a', y - 1), x, y);
        }
        Solution.IO.end();
    }
}
