import java.io.*;

class Solution{
    public class IO{
        private static BufferedInputStream bis = new BufferedInputStream(System.in);
        private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        public static boolean readInt(int[] res)throws IOException{
            int n;
            while((n = bis.read()) <= ' ' && n != -1);
            if(n == -1) return false;
            boolean neg = (n == '-');
            if(neg){
                while((n = bis.read()) <= ' ' && n != -1);
                if(n == -1) return false;
            }
            int total = 0;
            while(n >= '0' && n <= '9'){
                if(neg) total = total * 10 - (n - '0');
                else total = total * 10 + (n - '0');
                n = bis.read();
            }
            res[0] = total;
            return true;
        }

        public static boolean readIMat(int[][] mat, int[] aux)throws IOException{
            int rows = mat.length, cols = mat[0].length;
            for(int i = 0; i < rows; ++i){
                for(int j = 0; j < cols; ++j){
                    if(!readInt(aux)) return false;
                    mat[i][j] = aux[0];
                }
            }
            return true;
        }

        public static void print(int maxDiff, int nMat)throws IOException{
            bw.write("la diferencia maxima es ");
            bw.write(String.valueOf(maxDiff));
            bw.write('\n');
            bw.write("la primera matriu amb aquesta diferencia es la ");
            bw.write(String.valueOf(nMat));
            bw.write('\n');
        }

        public static void end()throws IOException{
            bw.close();
        }
    }

    public class Game{
        public static void minMax(int[][] mat, int[] min, int[] max)throws IOException{
            int minAux, maxAux, currAux;
            minAux = maxAux = mat[0][0];
            int rows = mat.length, cols = mat[0].length;
            for(int i = 0; i < rows; ++i){
                for(int j = 0; j < cols; ++j){
                    currAux = mat[i][j];
                    if(minAux > currAux) minAux = currAux;
                    if(maxAux < currAux) maxAux = currAux;
                }
            }
            min[0] = minAux;
            max[0] = maxAux;
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        int[] rows = new int[1], cols = new int[1], aux = new int[1], 
            min = new int[1], max = new int[1];
        int maxDiff = -1, mats = 0, nMat = 0, aux2;
        while(Solution.IO.readInt(rows) && Solution.IO.readInt(cols)){
            if(rows[0] < 1 || cols[0] < 1) break;
            int[][] mat = new int[rows[0]][cols[0]];
            if(!Solution.IO.readIMat(mat, aux)) break;
            ++mats;
            Solution.Game.minMax(mat, min, max);
            aux2 = max[0] - min[0];
            if(maxDiff < aux2){
                maxDiff = aux2;
                nMat = mats;
            }
        }
        Solution.IO.print(maxDiff, nMat);
        Solution.IO.end();
    }
}
                
            




