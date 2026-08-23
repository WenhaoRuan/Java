import java.io.*;

class Fraccio{
    int num, den;

    Fraccio(int num, int den){
        this.num = num;
        this.den = den;
    }

    public static Fraccio initFraccio(int num, int den){
        return new Fraccio(num, den);
    }
}

class Solution{
    public static class IO{
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

        public static boolean readFraccio(Fraccio f)throws IOException{
            int num, den;
            if((num = readNat()) != -1 && (den = readNat()) != -1){
                f.num = num;
                f.den = den;
                return true;
            }
            return false;
        }

        public static boolean readOp(char[] op)throws IOException{
            int n;
            while((n = bis.read()) <= ' ' && n != -1);
            if(n == -1) return false;
            op[0] = (char) n;
            return true;
        }

        public static void printRes(Fraccio f)throws IOException{
            bw.write(String.valueOf(f.num));
            bw.write('/');
            bw.write(String.valueOf(f.den));
            bw.write('\n');
        }

        public static void end()throws IOException{
            bw.close();
        }
    }
    
    public static class Game{

        public static int mcd(int a, int b){
            if(b == 0) return a;
            return mcd(b, a%b);
        }
        
        public static int mcm(int a, int b){
            if(a == b) return a;
            return (a / mcd(a, b)) * b;
        }

        public static void treuFactors(Fraccio f){
            int MCD = mcd(f.num, f.den);
            f.num /= MCD;
            f.den /= MCD;
        }

        public static Fraccio suma(final Fraccio x, final Fraccio y){
            int MCM = mcm(x.den, y.den);
            Fraccio f = Fraccio.initFraccio(x.num * (MCM / x.den) + y.num * (MCM / y.den), MCM);
            treuFactors(f);
            return f;
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        Fraccio f = Fraccio.initFraccio(0,1), aux = Fraccio.initFraccio(0,1);
        if(Solution.IO.readFraccio(f)){
            char[] op = new char[1];
            while(Solution.IO.readOp(op)){
                switch(op[0]){
                    case '+' ->{
                        if(!Solution.IO.readFraccio(aux)) break;
                        f = Solution.Game.suma(f, aux);
                    }
                    default -> Solution.IO.printRes(f);
                }
            }
        }
        Solution.IO.end();
    }
}
