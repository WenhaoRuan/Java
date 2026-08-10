import java.io.*;
import java.util.*;

class Main{
    private static BufferedInputStream bis = new BufferedInputStream(System.in);
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int readNat() throws IOException{
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

    public static String readString(StringBuilder sb)throws IOException{
        int n;
        while((n = bis.read()) <= ' ' && n != -1);
        if(n == -1) return null;
        sb.setLength(0);
        while(n >= 'a' && n <= 'z'){
            sb.append((char) n);
            n = bis.read();
        }
        return sb.toString();
    }

    public static int readByte()throws IOException{
        int n;
        while((n = bis.read()) <= ' ' && n != -1);
        return n;
    }

    public static boolean readCMat(char[][] m)throws IOException{
        for(int i = 0; i < m.length; ++i){
            for(int j = 0; j < m[0].length; ++j){
                int b = readByte();
                if(b == -1) return false;
                m[i][j] = (char)b;
            }
        }
        return true;
    }

    public static void printCMat(char[][] m)throws IOException{
        for(int i = 0; i < m.length; ++i){
            for(int j = 0; j < m[0].length; ++j){
                if(j > 0 && j < m[0].length) bw.write(' ');
                bw.write(m[i][j]);
            }
            bw.write('\n');
        }
    }

    public static boolean readSVec(String[] names, StringBuilder sb)throws IOException{
        for(int i = 0; i < names.length; ++i)
            if((names[i] = readString(sb)) == null) return false;
        return true;
    }
    
    public class WordSearch{
    
        public record pos(int x, int y){}

        private static final int[][] DIRS = {
            {-1, 0},{-1, 1},{0, 1},{1, 1},
            {1, 0},{1, -1},{0, -1},{-1, -1}
        };
        
        public static List<pos> check(String name, char[][] m, int x, int y){
            List<pos> res = new ArrayList<>();
            int len = name.length(), rows = m.length, cols = m[0].length;
            for(int[] dir : DIRS){
                int dX = dir[0], dY = dir[1];
                int endX = x + dX * (len - 1), endY = y + dY * (len - 1);
                if(endX >= 0 && endX < rows && endY >= 0 && endY < cols){
                    boolean match = true;
                    List<pos> currPath = new ArrayList<>();
                    for(int i = 0; i < len; ++i){
                        int newX = x + i * dX, newY = y + i * dY;
                        if(m[newX][newY] != name.charAt(i)){
                            match = false;
                            break;
                        }
                        currPath.add(new pos(newX, newY));
                    }
                    if(match){
                        res.addAll(currPath);
                    }
                }
            }
            return res;
        }

        public static void process(String[] names, char[][] m){
            boolean[][] matching = new boolean[m.length][m[0].length];
            for(int i = 0; i < names.length; ++i){
                for(int j = 0; j < m.length; ++j){
                    for(int k = 0; k < m[0].length; ++k){
                        if(m[j][k] == names[i].charAt(0)){
                            List<pos> res = check(names[i], m, j, k);
                            for(var pos: res) matching[pos.x()][pos.y()] = true;
                        }
                    }
                }
            }
            for(int i = 0; i < m.length; ++i){
                for(int j = 0; j < m[0].length; ++j){
                    if(matching[i][j]) m[i][j] = Character.toUpperCase(m[i][j]);
                }
            }
        }                            
    }

    public static void main(String[] args)throws IOException{
        int words, rows, cols;
        boolean first = true;
        while((words = readNat()) != -1 && (rows = readNat()) != -1 && (cols = readNat()) != -1){
            String[] names = new String[words];
            StringBuilder sb = new StringBuilder();
            if(!readSVec(names, sb)) break;
            char[][] m = new char[rows][cols];
            if(!readCMat(m)) break;
            if(!first) bw.write('\n');
            else first = false;
            WordSearch.process(names, m);
            printCMat(m);
        }
        bw.close();
    }
}
