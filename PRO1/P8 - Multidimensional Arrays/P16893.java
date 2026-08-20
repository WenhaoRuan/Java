import java.io.*;

class Solution{
    class IO{
        private static BufferedInputStream bis = new BufferedInputStream(System.in);
        private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        public static int readIByte()throws IOException{
            int n;
            while((n = bis.read()) <= ' ' && n != -1);
            if(n == -1) return n;
            else return n - '1';
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

        public static boolean readSudoku(int[][] sudoku)throws IOException{
            int rows = 9, cols = 9;
            for(int i = 0; i < rows; ++i){
                for(int j = 0; j < cols; ++j){
                    if((sudoku[i][j] = readIByte()) == -1) return false;
                }
            }
            return true;
        }

        public static void printRes(boolean correct)throws IOException{
            if(correct) bw.write("si\n");
            else bw.write("no\n");
        }

        public static void end()throws IOException{
            bw.close();
        }
    }

    public class Game{
        public static boolean comprobarSudoku(int[][] sudoku){
            int rows = 9, cols = 9;
            for(int i = 0; i < rows; ++i){
                boolean[] vert = new boolean[rows], horit = new boolean[cols], quadrant = new boolean[9];
                for(int j = 0; j < cols; ++j){
                    int v = sudoku[i][j], 
                        h = sudoku[j][i],
                        q = sudoku[(i/3) * 3 + j/3][(i%3) * 3 + j%3];
                    if(vert[v] || horit[h] || quadrant[q]) return false;
                    vert[v] = true;
                    horit[h] = true;
                    quadrant[q] = true;
                }
            }
            return true;
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        int iter;
        if((iter = Solution.IO.readNat()) != -1){
            int[][] sudoku = new int[9][9];
            for(int i = 0; i < iter; ++i){
                if(!Solution.IO.readSudoku(sudoku)) return;
                Solution.IO.printRes(Solution.Game.comprobarSudoku(sudoku));
            }            
        }
        Solution.IO.end();
    }
}
