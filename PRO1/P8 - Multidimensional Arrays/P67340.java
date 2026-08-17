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

        public static int readByte()throws IOException{
            int n;
            while((n = bis.read()) <= ' ' && n != -1);
            return n;
        }

        public static boolean readTauler(int[][] tauler)throws IOException{
            int rows = tauler.length, cols = tauler[0].length;
            for(int i = 0; i < rows; ++i){
                for(int j = 0; j < cols; ++j){
                    if((tauler[i][j] = readByte()) == -1) return false;
                }
            }
            return true;
        }

        public static void printDanger(int x1, int y1, int x2, int y2)throws IOException{
            bw.write('(');
            if(x1 <= 9) bw.write((char)(x1 + '0'));
            else bw.write(String.valueOf(x1));
            bw.write(',');
            if(y1 <= 9) bw.write((char)(y1 + '0'));
            else bw.write(String.valueOf(y1));
            bw.write(")<->(");
            if(x2 <= 9) bw.write((char)(x2 + '0'));
            else bw.write(String.valueOf(x2));
            bw.write(',');
            if(y2 <= 9) bw.write((char)(y2 + '0'));
            else bw.write(String.valueOf(y2));
            bw.write(")\n");
        }

        public static void end()throws IOException{
            bw.close();
        }
    }

    public class Game{
        private static int[][] DIRS = {
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        public record Pos(int x, int y){}

        public static boolean posOk(int[][] tauler, int x, int y){
            return(x >= 0 && x < tauler.length && y >= 0 && y < tauler[0].length);
        }

        public static int diagonals(int[][]tauler, int x, int y, int[] x2, int[] y2){
            int staring = 0;
            for(int[] dir : DIRS){
                int newX = x + dir[0], newY = y + dir[1];
                for(;;){
                    if(!posOk(tauler, newX, newY)) break;
                    if(tauler[newX][newY] == 'X'){
                        x2[staring] = newX;
                        y2[staring] = newY;
                        ++staring;
                        break;
                    }
                    newX += dir[0];
                    newY += dir[1];
                }
            }
            return staring;
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        int rows, cols;
        if((rows = Solution.IO.readNat()) != -1 &&
                (cols = Solution.IO.readNat()) != -1){
            int[][] tauler = new int[rows][cols];
            if(!Solution.IO.readTauler(tauler)) return;
            int x2[] = new int[4], y2[] = new int[4];
            int conflictes = 0;
            for(int i = 0; i < rows; ++i){
                for(int j = 0; j < cols; ++j){
                    if(tauler[i][j] == 'X'){
                        tauler[i][j] = '.';
                        conflictes = Solution.Game.diagonals(tauler, i, j, x2, y2);
                        for(int c = 0; c < conflictes; ++c)
                            Solution.IO.printDanger(i + 1, j + 1, x2[c] + 1, y2[c] + 1);
                        tauler[i][j] = 'X';
                    }
                }
            }
        }
        Solution.IO.end();
    }
}
