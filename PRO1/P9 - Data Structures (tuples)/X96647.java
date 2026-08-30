import java.io.*;
import java.util.*;

class Punt{
    static final double EPS = 1e-9;
    double x, y;

    Punt(){
        this(0.0, 0.0);
    }

    Punt(double x, double y){
        this.x = x;
        this.y = y;
    }

    boolean pEquals(Punt p){
        if (p == null) return false;
        return Math.abs(this.x - p.x) < EPS && Math.abs(this.y - p.y) < EPS;
    }
}

class Conditionals{
    boolean prop1, prop2, prop3;

    Conditionals(){
        this(true, true, true);
    }

    Conditionals(boolean prop1, boolean prop2, boolean prop3){
        this.prop1 = prop1;
        this.prop2 = prop2;
        this.prop3 = prop3;
    }

    public boolean noNormal(){
        return !(prop1 && prop2 && prop3);
    }
}

class Solution{
    public static class IO{
        private static final BufferedInputStream bis = new BufferedInputStream(System.in);
        private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        private static final char[] buff = new char[256];

        public static int readNat()throws IOException{
            int n = 0;
            while((n = bis.read()) <= ' ' && n != -1);
            if(n == -1) return n;
            int total = 0;
            while(n >= '0' && n <= '9'){
                total = total * 10 + (n - '0');
                n = bis.read();
            }
            return total;
        }

        public static double readDouble()throws IOException{
            int n = 0;
            while((n = bis.read()) <= ' ' && n != -1);
            if(n == -1) return Double.NaN;
            int len = 0;
            while(n > ' '){
                buff[len++] = (char) n;
                n = bis.read();
            }
            return Double.parseDouble(new String(buff, 0, len));
        }

        public static Punt readPunt()throws IOException{
            double x = readDouble();
            if(Double.isNaN(x)) return null;
            double y = readDouble();
            if(Double.isNaN(y)) return null;
            return new Punt(x, y);
        }

        public static Punt[] readPuntVec(int size)throws IOException{
            Punt[] res = new Punt[size];
            for(int i = 0; i < size; ++i)
                if((res[i] = readPunt()) == null) return null;
            return res;
        }

        public static void printDouble(double n, int precision)throws IOException{
            if(n < 0.0){
                bw.write('-');
                n = -n;
            }
            double scale = Math.pow(10, precision);
            long rounded = Math.round(n * scale);
            long intPart = (precision > 0) ? rounded / (long) scale : rounded;
            long fracPart = (precision > 0) ? rounded % (long) scale : 0;
            int pos = buff.length;
            if(intPart == 0) buff[--pos] = '0';
            else{
                while(intPart > 0){
                    buff[--pos] = (char)('0' + (intPart % 10));
                    intPart /= 10;
                }
            }
            bw.write(buff, pos, buff.length - pos);
            if(precision > 0){
                bw.write('.');
                pos = buff.length;
                for(int i = 0; i < precision; ++i){
                    buff[--pos] = (char)('0' + (fracPart % 10));
                    fracPart /= 10;
                }
                bw.write(buff, pos, precision);
            }
        }

        public static void printRes(Punt p, Conditionals c, int precision)throws IOException{
            bw.write("baricentre: (");
            printDouble(p.x, precision);
            bw.write(',');
            printDouble(p.y, precision);
            bw.write(")\n");
            if(c.noNormal()){
                bw.write("el vector no compleix la propietat ");
                if(!c.prop1) bw.write('1');
                else if(!c.prop2) bw.write('2');
                else bw.write('3');
                bw.write('\n');
                return;
            }
            bw.write("vector normalitzat\n");
        }

        public static void end()throws IOException{
            bw.close();
        }
    }

    public static class Game{
        private static final double EPS = 1e-9;

        public static Conditionals baricentre(final Punt[] puntVec, Punt b){
            boolean prop1 = false, prop2, prop3 = true;
            double x = 0.0, y = 0.0;
            for(Punt p : puntVec){
                if(!prop1 && !p.pEquals(puntVec[0])) prop1 = true;
                x += p.x;
                y += p.y;
            }
            b.x = x / puntVec.length;
            b.y = y / puntVec.length;
            prop2 = Math.abs(b.x - b.y) < EPS;
            for(Punt p: puntVec){
                if(b.pEquals(p)){
                    prop3 = false;
                    break;
                }
            }
            return new Conditionals(prop1, prop2, prop3);
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        int size;
        while((size = Solution.IO.readNat()) > 0){
            Punt p = new Punt();
            Punt[] puntVec = Solution.IO.readPuntVec(size);
            if(puntVec == null) break;
            Conditionals c = Solution.Game.baricentre(puntVec, p);
            Solution.IO.printRes(p, c, 2);
        }
        Solution.IO.end();
    }
}
