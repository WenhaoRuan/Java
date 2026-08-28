import java.io.*;
import java.util.*;

class Parell{
    int valor;
    int pos;

    Parell(int valor, int pos){
        this.valor = valor;
        this.pos = pos;
    }
}

class Solution{
    public static class IO{
        private static BufferedInputStream bis = new BufferedInputStream(System.in);
        private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        private static final char[] buff = new char[10];

        public static boolean readInt(int[] res)throws IOException{
            int n;
            while((n = bis.read()) <= ' ' && n != -1);
            if(n == -1) return false;
            boolean neg = (n == '-');
            if(neg) n = bis.read();
            int total = 0;
            while(n >= '0' && n <= '9'){
                if(neg) total = total * 10 - (n - '0');
                else total = total * 10 + (n - '0');
                n = bis.read();
            }
            res[0] = total;
            return true;
        }

        public static Parell readPair(int[] aux)throws IOException{
            int valor, pos;
            if(!readInt(aux)) return null;
            valor = aux[0];
            if(!readInt(aux)) return null;
            if((pos = aux[0]) < 0) return null;
            return new Parell(valor, pos);
        }

        public static Parell[] readPairVec(int size, int[] aux)throws IOException{
            Parell[] res = new Parell[size];
            for(int i = 0; i < size; ++i)
                if((res[i] = readPair(aux)) == null) return null;
            return res;
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
            int pos = buff.length;
            while(n > 0){
                buff[--pos] = (char)('0' + (n % 10));
                n /= 10;
            }
            bw.write(buff, pos, buff.length - pos);
        }
        
        public static void printPairVec(final Parell[] res)throws IOException{
            if(res == null){
                bw.write("0\n");
                return;
            }
            printInt(res.length);
            for(Parell p : res){
                bw.write(' ');
                printInt(p.valor);
                bw.write(';');
                printInt(p.pos);
            }
            bw.write('\n');
        }

        public static void end()throws IOException{
            bw.close();
        }
    }

    public static class Game{
        public static Parell[] suma(final Parell[] v1, final Parell[] v2){ 
            List<Parell> res = new ArrayList<>();
            int i = 0, j = 0;
            int pos1, pos2;
            while(i < v1.length && j < v2.length){
                pos1 = v1[i].pos;
                pos2 = v2[j].pos;
                if(pos1 < pos2){
                    res.add(new Parell(v1[i].valor, pos1));
                    ++i;
                }
                else if(pos1 == pos2){
                    int valorAux = v1[i].valor + v2[j].valor;
                    if(valorAux != 0) res.add(new Parell(valorAux, pos1));
                    ++i;
                    ++j;
                }
                else{
                    res.add(new Parell(v2[j].valor, pos2));
                    ++j;
                }
            }            
            for(;i < v1.length; ++i) res.add(new Parell(v1[i].valor, v1[i].pos));
            for(;j < v2.length; ++j) res.add(new Parell(v2[j].valor, v2[j].pos));
            return res.isEmpty() ? null : res.toArray(Parell[]::new);
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        int[] aux = new int[1];
        if(!Solution.IO.readInt(aux)) return;
        int cases = aux[0]; 
        for(int i = 0; i < cases; ++i){
            if(!Solution.IO.readInt(aux)) break;
            Parell[] v1 = null;
            if(aux[0] > 0){
                int size = aux[0];
                if((v1 = Solution.IO.readPairVec(size, aux)) == null) break;
            }
            if(!Solution.IO.readInt(aux)) break;          
            Parell[] v2 = null;
            if(aux[0] > 0){
               int size = aux[0];
               if((v2 = Solution.IO.readPairVec(size, aux)) == null) break;
            }
            if(v1 == null){
                if(v2 == null) Solution.IO.printPairVec(null);
                else Solution.IO.printPairVec(v2);
            }
            else if(v2 == null) Solution.IO.printPairVec(v1);
            else Solution.IO.printPairVec(Solution.Game.suma(v1, v2));
        }
        Solution.IO.end();
    }
}
