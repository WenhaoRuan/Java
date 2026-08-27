import java.io.*;

class Rectangle{
    int xEsq, xDre, yBaix, yDalt;

    Rectangle(int xEsq, int xDre, int yBaix, int yDalt){
        this.xEsq = xEsq;
        this.xDre = xDre;
        this.yBaix = yBaix;
        this.yDalt = yDalt;
    }
    
    Rectangle(){
        this(0, 0, 0, 0);
    }

    public static Rectangle empty(){
        return new Rectangle();
    }
}

class Solution{
    public static class IO{
        private final static BufferedInputStream bis = new BufferedInputStream(System.in);
        private final static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        private final static int costats = 4;
        private static final char[] intBuff = new char[10];
        private enum costat{
            ESQ(0),
            DRE(1),
            BAIX(2),
            DALT(3);

            public final int index;
            
            costat(int index){
                this.index = index;
            }
        }

        public static boolean readInt(int[] res, int i)throws IOException{
            int n;
            while((n = bis.read()) <= ' ' && n != -1);
            boolean neg = (n == '-');
            if(neg) while((n = bis.read()) <= ' ' && n != -1);
            if(n == -1) return false;
            int total = 0;
            while(n >= '0' && n <= '9'){
                if(neg) total = total * 10 - (n - '0');
                else total = total * 10 + (n - '0');
                n = bis.read();
            }
            res[i] = total;
            return true;
        }

        public static boolean readRectangle(Rectangle r, int[] aux)throws IOException{
            for(int i = 0; i < costats; ++i) if(!readInt(aux, i)) return false;
            r.xEsq = aux[costat.ESQ.index];
            r.xDre = aux[costat.DRE.index];
            r.yBaix = aux[costat.BAIX.index];
            r.yDalt = aux[costat.DALT.index];
            return true;
        }

        public static void printInt(int n)throws IOException{
            if(n == 0){
                bw.write('0');
                return;
            }
            if(n < 0){
                bw.write('-');
                n = -n;
            }
            int pos = intBuff.length;
            while(n > 0){
                intBuff[--pos] = (char) ('0' + (n % 10));
                n /= 10;
            }
            bw.write(intBuff, pos, intBuff.length - pos);
        }

        public static void printRes(Rectangle r, boolean intersecten)throws IOException{
            if(intersecten){
                bw.write("punt inferior esquerre = (");
                printInt(r.xEsq);
                bw.write(", ");
                printInt(r.yBaix);
                bw.write("); punt superior dret = (");
                printInt(r.xDre);
                bw.write(", ");
                printInt(r.yDalt);
                bw.write(")\n");
                return;
            }
            bw.write("interseccio buida\n");
        }

        public static void end()throws IOException{
            bw.close();
        }
    }

    public static class Game{
        public static boolean intersecBuida(Rectangle r){
            return (r.xEsq >= r.xDre || r.yBaix >= r.yDalt);
        }

        public static void intersecta(Rectangle r, final Rectangle rAux){
            if(r.xEsq >= rAux.xDre ||
                    r.xDre <= rAux.xEsq ||
                    r.yBaix >= rAux.yDalt ||
                    r.yDalt <= rAux.yBaix){
                r.xEsq = r.xDre = r.yBaix = r.yDalt = 0;
                return;
            }
            r.xEsq = Math.max(r.xEsq, rAux.xEsq);
            r.xDre = Math.min(r.xDre, rAux.xDre);
            r.yBaix = Math.max(r.yBaix, rAux.yBaix);
            r.yDalt = Math.min(r.yDalt, rAux.yDalt);
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        int[] aux = new int[4];
        int casos, i;
        Rectangle r = Rectangle.empty(), rAux = Rectangle.empty();
        boolean buit = false;
        while(Solution.IO.readInt(aux, 0) && (casos = aux[0]) > 0){
            buit = false;
            if(!Solution.IO.readRectangle(r, aux)) break;
            for(i = 1; i < casos; ++i){
                if(!Solution.IO.readRectangle(rAux, aux)) break;
                Solution.Game.intersecta(r, rAux);
                if((buit = Solution.Game.intersecBuida(r))){
                   ++i;
                   break;
                }
            }
            for(; i < casos; ++i) if(!Solution.IO.readRectangle(rAux, aux)) break;
            Solution.IO.printRes(r, !buit);
        }
        Solution.IO.end();
    }
}
