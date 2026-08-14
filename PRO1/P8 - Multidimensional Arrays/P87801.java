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

        public static boolean readCMat(int[][] soupMat)throws IOException{
            int rows = soupMat.length, cols = soupMat[0].length;
            for(int i = 0; i < rows; ++i){
                for(int j = 0; j < cols; ++j){
                    if((soupMat[i][j] = readByte()) == -1) return false;                   
                }
            }
            return true;
        }

        public static boolean readIMat(int[][] prizeMat, int[][] prefixSum)throws IOException{
            int n, rows = prizeMat.length, cols = prizeMat[0].length;
            for(int i = 0; i < rows; ++i){
                for(int j = 0; j < cols; ++j){
                    if((prizeMat[i][j] = readNat()) == -1) return false;
                    prefixSum[i + 1][j + 1] = prefixSum[i][j + 1] 
                        + prefixSum[i + 1][j] 
                        + prizeMat[i][j] 
                        - prefixSum[i][j] ;
                }
            }
            return true;
        }

        public static boolean readSVec(int[][] words)throws IOException{
            int n, rows = words.length, cols = words[0].length;
            for(int i = 0; i < rows; ++i){
                if((n = readByte()) == -1) return false;
                words[i][1] = n;
                int j = 2;
                for(; j < cols; ++j){
                    if((n = bis.read()) == -1) return false;
                    if(n <= ' ') break;
                    words[i][j] = n;
                }
                words[i][0] = j - 1;
            }
            return true;
        }

        public static void print(int[] maxWin)throws IOException{
            for(int n : maxWin){
                if(n == -1)bw.write("no\n");
                else{
                    bw.write(String.valueOf(n));
                    bw.write('\n');
                }
            }
        }

        public static void end()throws IOException{
            bw.close();
        }
    }

    public class Game{
        public static final int[][] DIRS = {{0, 1}, {1, 0}};

        public static int getHoritPrize(int[][] prefixSum, int x, int y, int len){
            int endY = len + y;
            return prefixSum[x + 1][endY] - prefixSum[x + 1][y] - prefixSum[x][endY] + prefixSum[x][y];
        }

        public static int getVertPrize(int[][] prefixSum, int x, int y, int len){
            int endX = len + x;
            return prefixSum[endX][y + 1] - prefixSum[x][y + 1] - prefixSum[endX][y] + prefixSum[x][y];
        }

        public static void tryCandidate(int[] word, int[][] soupMat, int[][] prizeMat,
                int[][] prefixSum, int w, int x, int y, int dX, int dY, int[] maxWin){
            int len = word[0];
            int endX = x + dX * (len - 1), endY = y + dY * (len - 1);
            if(endX >= soupMat.length || endY >= soupMat[0].length) return;
            int prize = (dX > dY)
                ? getVertPrize(prefixSum, x, y, len)
                : getHoritPrize(prefixSum, x, y, len);
            if(maxWin[w] > prize) return;
            for(int i = 1; i < len; ++i)
                if(word[i + 1] != soupMat[x + i * dX][y + i * dY]) return;
            maxWin[w] = prize;
        }

        public static int[] process(int[][] words, int[][] soupMat, int[][] prizeMat, int[][] prefixSum){
            int nWords = words.length, sRows = soupMat.length, sCols = soupMat[0].length;
            int[] maxWin = new int[nWords];
            Arrays.fill(maxWin, -1);
            for(int w = 0; w < nWords; ++w){
                for(int x = 0; x < sRows; ++x){
                    for(int y = 0; y < sCols; ++y){
                        if(soupMat[x][y] == words[w][1]){
                            tryCandidate(words[w], soupMat, prizeMat, prefixSum, w, x, y, 1, 0, maxWin);
                            tryCandidate(words[w], soupMat, prizeMat, prefixSum, w, x, y, 0, 1, maxWin);
                        }
                    }
                }
            }
            return maxWin;
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        int rows, cols;
        while((rows = Solution.IO.readNat()) != -1 && (cols = Solution.IO.readNat()) != -1){
            int[][] soupMat = new int[rows][cols];
            if(!Solution.IO.readCMat(soupMat)) break;
            int[][] prizeMat = new int[rows][cols], prefixSum = new int[rows + 1][cols + 1];
            if(!Solution.IO.readIMat(prizeMat, prefixSum)) break;
            int nWord;
            if((nWord = Solution.IO.readNat()) == -1) break;
            int[][] words = new int[nWord][101];
            if(!Solution.IO.readSVec(words)) break;
            Solution.IO.print(Solution.Game.process(words, soupMat, prizeMat, prefixSum));
        }
        Solution.IO.end();
    }
}
