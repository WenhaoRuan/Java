import java.io.*;

class Rectangle{
    int xEsq, xDre, yBaix, yDalt;

    Rectangle(int xEsq, int xDre, int yBaix, int yDalt){
        this.xEsq = xEsq;     
        this.xDre = xDre;
        this.yBaix = yBaix;
        this.yDalt = yDalt;
    }

    public static Rectangle initRectangle(int xEsq, int xDre, int yBaix, int yDalt){
        return new Rectangle(xEsq, xDre, yBaix, yDalt);
    }
}

class Solution{
    public static class IO{
        private static BufferedInputStream bis = new BufferedInputStream(System.in);
        private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        private final static int sides = 4;

        public static boolean readInt(int[] res, int i)throws IOException{
            int n;
            while((n = bis.read()) <= ' ' && n != -1);
            boolean neg = (n == '-'); 
            if(neg) while((n = bis.read()) <= ' ' && n != -1);
            if(n == -1) return false;
            int total = 0;
            while(n >= '0' && n <= '9'){
                if(neg) total = total * 10 - (n -'0');
                else total = total * 10 + (n -'0');
                n= bis.read();
            }
            res[i] = total;
            return true;
        }

        public static boolean llegeix(Rectangle r, int[] corners)throws IOException{
            for(int i = 0; i < sides; ++i){
                if(!readInt(corners, i)) return false;
            }
            r.xEsq = corners[0];
            r.xDre = corners[1];
            r.yBaix = corners[2];
            r.yDalt = corners[3];
            return true;
        }

        public static void printRes(int res)throws IOException{
            switch(res){
                case 1 -> bw.write("el primer rectangle es interior al segon\n");
                case 2 -> bw.write("el segon rectangle es interior al primer\n");
                case 3 -> bw.write("els rectangles intersecten\n");
                case 4 -> bw.write("els rectangles son iguals\n");
                default -> bw.write("els rectangles no intersecten\n");
            }
        }

        public static void end()throws IOException{
            bw.close();
        }
    }

    public static class Game{
        public static int relacio(final Rectangle r1, final Rectangle r2){
            if(r1.xDre == r2.xDre && 
                    r1.xEsq == r2.xEsq &&
                    r1.yBaix == r2.yBaix && 
                    r1.yDalt == r2.yDalt) return 4;
            else if(r1.xDre >= r2.xDre && 
                    r1.xEsq <= r2.xEsq &&
                    r1.yBaix <= r2.yBaix && 
                    r1.yDalt >= r2.yDalt) return 2;
            else if(r1.xDre <= r2.xDre && 
                    r1.xEsq >= r2.xEsq && 
                    r1.yBaix >= r2.yBaix && 
                    r1.yDalt <= r2.yDalt) return 1;
            else if(r1.xDre < r2.xEsq ||
                    r1.xEsq > r2.xDre ||
                    r1.yDalt < r2.yBaix ||
                    r1.yBaix > r2.yDalt) return 5;
            return 3;
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        int[] aux = new int[4];
        if(Solution.IO.readInt(aux, 0)){
            int casos = aux[0];
            Rectangle r1 = Rectangle.initRectangle(0, 0, 0, 0), 
                      r2 = Rectangle.initRectangle(0, 0, 0, 0); 
            for(int i = 0; i < casos; ++i){
                if(!Solution.IO.llegeix(r1, aux) || !Solution.IO.llegeix(r2, aux)) break;
                Solution.IO.printRes(Solution.Game.relacio(r1, r2));
            }
        }
        Solution.IO.end();
    }
}
