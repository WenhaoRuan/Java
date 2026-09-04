import java.io.*;

record Point(int y, int x){
    Point(){
        this(0, 0);
    }
}

class Solution{
    public static class IO{
        private static final BufferedInputStream bis = new BufferedInputStream(System.in);
        private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        public static int readNat()throws IOException{
            int n;
            while((n = bis.read()) <= ' ' && n != -1);
            if(n == -1) return n;
            int total = 0;
            while(n > ' '){
                total = total * 10 + (n - '0');
                n = bis.read();
            }
            return total;
        }

        public static char[][] readPetriDish(int rows, int cols)throws IOException{
            if(rows == 0 || cols == 0) return null;
            int n;
            char[][] res = new char[rows][cols];
            for(int i = 0; i < rows; ++i){
                for(int j = 0; j < cols; ++j){
                    while((n = bis.read()) <= ' ' && n != -1);
                    if(n == -1) return null;
                    res[i][j] = (char) n;
                }
            }
            return res;
        }

        public static void printRes(char[][] res, boolean[] first)throws IOException{
            if(!first[0]) bw.write('\n');
            else first[0] = false;
            for(char[] row : res){
                for(char item: row)
                    bw.write(item);
                bw.write('\n');
            }
        }

        public static void end()throws IOException{
            bw.close();
        }
    }

    public static class Game{
        private static final Point[] DIRS = { new Point(-1, 0), new Point(-1, 1),
            new Point(0, 1), new Point(1, 1), new Point(1, 0),
            new Point(1, -1), new Point(0, -1), new Point(-1, -1)};

        public static char[][] nextFrame(final char[][] dish){
            if(dish == null) return null;
            int rows = dish.length, cols = dish[0].length;
            char[][] res = new char[rows][cols];
            for(int i = 0; i < rows; ++i){
                for(int j = 0; j < cols; ++j){
                    int companys = 0;
                    for(Point dir : DIRS){
                        int newY = i + dir.y(), newX = j + dir.x();
                        if(newY >= 0 && newY < rows && newX >= 0 && newX < cols &&
                                dish[newY][newX] == 'B') ++companys;
                    }
                    if((dish[i][j] == 'B' && companys == 2) || companys == 3)res[i][j] = 'B';
                    else res[i][j] = '.';
                }
            }
            return res;
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        int rows, cols;
        boolean[] first = new boolean[1];
        first[0] = true;
        while((rows = Solution.IO.readNat()) > 0 &&
                (cols = Solution.IO.readNat()) > 0){
            char[][] petriDish = Solution.IO.readPetriDish(rows, cols);
            if(petriDish == null) break;
            Solution.IO.printRes(Solution.Game.nextFrame(petriDish), first);
        }
        Solution.IO.end();
    }
}
