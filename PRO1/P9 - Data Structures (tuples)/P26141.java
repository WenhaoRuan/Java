import java.io.*;

class Racional{
    int num, den;

    Racional(int num, int den){
        this.num = num;
        this.den = den;
    }

    public static Racional initRacional(){
        return new Racional(0, 1);
    }
}

class Solution{
    public static class IO{
        private static BufferedInputStream bis = new BufferedInputStream(System.in);
        private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        public static boolean readInt(int[] res)throws IOException{
            int n;
            while((n = bis.read()) <= ' ' && n != -1);
            if(n == -1) return false;
            boolean neg = (n == '-');
            if(neg) while((n = bis.read()) <= ' ' && n != -1);
            if(n == -1) return false;
            int total = 0;
            while(n >= '0' && n <= '9'){
                if(neg) total = total * 10 - (n - '0');
                else total = total * 10 + (n - '0');
                n = bis.read();
            }
            res[0] = total;
            return true;
        }

        public static boolean readRacional(Racional r, int[] n, int[] d)throws IOException{
            if(!readInt(n) || !readInt(d)) return false;
            r.num = n[0];
            r.den = d[0];
            return true;
        }

        public static boolean readOp(char[] op)throws IOException{
            int n;
            while((n = bis.read()) <= ' ' && n != -1);
            if(n == -1) return false;
            op[0] = (char) n;
            while((n = bis.read()) >= 'a' && n <= 'z');
            return true;
        }

        public static void printRes(Racional r)throws IOException{
            if(r.den == 1) bw.write(String.valueOf(r.num));
            else{
                bw.write(String.valueOf(r.num));
                bw.write('/');
                bw.write(String.valueOf(r.den));
            }
            bw.write('\n');
        }

        public static void end()throws IOException{
            bw.close();
        }
    }

    public static class Game{
        public static int mcd(int a, int b){
            if(b == 0) return (a < 0) ? -a : a;
            return mcd(b, a%b);
        }

        public static int mcm(int d1, int d2){
            if(d1 == d2) return d1;
            return (d1 / mcd(d1, d2)) * d2;
        }

        public static Racional racional(int n, int d){
            if(d < 0){
                n = -n;
                d = -d;
            }
            Racional r = Racional.initRacional();
            if(n != 0){
                int MCD = mcd(n, d);                
                r.num = n/MCD;
                r.den = d/MCD;
            }
            return r;
        }

        public static Racional suma(Racional a, Racional b){
            int MCM = mcm(a.den, b.den);
            int n = a.num * (MCM / a.den) + b.num * (MCM / b.den);
            return racional(n, MCM);
        }
        
        public static Racional resta(Racional a, Racional b){
            int MCM = mcm(a.den, b.den);
            int n = a.num * (MCM / a.den) - b.num * (MCM / b.den);
            return racional(n, MCM);
        }

        public static Racional multiplicacio(Racional a, Racional b){
            return racional(a.num * b.num, a.den * b.den);
        }

        public static Racional divisio(Racional a, Racional b){
            return racional(a.num * b.den, b.num * a.den);
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        Racional r = Racional.initRacional(), aux = Racional.initRacional();
        int[] n = new int[1], d = new int[1];
        if(Solution.IO.readRacional(r, n, d)){
            r = Solution.Game.racional(r.num, r.den);
            Solution.IO.printRes(r);
            char[] op = new char[1];
            while(Solution.IO.readOp(op)){
                if(!Solution.IO.readRacional(aux, n, d)) break;
                aux = Solution.Game.racional(aux.num, aux.den);
                switch(op[0]){
                    case 's' -> r = Solution.Game.suma(r, aux);
                    case 'r' -> r = Solution.Game.resta(r, aux);
                    case 'm' -> r = Solution.Game.multiplicacio(r, aux);
                    default -> r = Solution.Game.divisio(r, aux);
                }
                Solution.IO.printRes(r);
            }
        }
        Solution.IO.end();
    }
}
