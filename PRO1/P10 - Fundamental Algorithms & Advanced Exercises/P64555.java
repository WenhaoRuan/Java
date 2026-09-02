import java.io.*;
import java.util.*;

record Point(int x, int y){
    Point(){
        this(0, 0);
    }
}

record MapInfo(int dist, Point p){
    MapInfo(){
        this(0, new Point());
    }

    public static final Comparator<MapInfo> cmp = Comparator
        .comparingInt(MapInfo::dist)
        .thenComparing(MapInfo::p, Comparator.comparingInt(Point::x))
        .thenComparing(MapInfo::p, Comparator.comparingInt(Point::y));
}

class Solution{
    public static class IO{
        private static final BufferedInputStream bis = new BufferedInputStream(System.in);
        private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        private static final char[] buff = new char[10];

        public static boolean readInt(int[] res)throws IOException{
            int n;
            while((n = bis.read()) <= ' ' && n != -1);
            if(n == -1) return false;
            boolean neg = (n == '-');
            if(neg) n = bis.read();
            int total = 0;
            while(n > ' '){
                total = total * 10 - (n - '0');
                n = bis.read();
            }
            res[0] = neg ? total : -total;
            return true;
        }

        public static Point readPoint(int[] aux)throws IOException{
            int x;
            if(!readInt(aux)) return null;
            x = aux[0];
            if(!readInt(aux)) return null;
            return new Point(x, aux[0]);
        }

        public static void printInt(int n)throws IOException{
            if(n == 0){
                bw.write('0');
                return;
            }
            int pos = buff.length;
            if(n < 0) bw.write('-');
            else n = - n;
            while(n < 0){
                buff[--pos] = (char)('0' - (n % 10));
                n /= 10;
            }            
            bw.write(buff, pos, buff.length - pos);
        }

        public static void printPoint(final Point p)throws IOException{
            printInt(p.x());
            bw.write(' ');
            printInt(p.y());
            bw.write('\n');
        }

        public static void printRes(MapInfo[] res)throws IOException{
            int dist = - 1;
            for(MapInfo node : res){
                if(dist < node.dist()){
                    dist = node.dist();
                    bw.write("punts a distancia ");
                    printInt(dist);
                    bw.write('\n');
                }
                IO.printPoint(node.p());
            }
        }

        public static void end()throws IOException{
            bw.close();
        }
    }

    public static class Game{

        public static int distance(final Point ini, final Point end){
            return Math.abs(ini.x() - end.x()) + Math.abs(ini.y() - end.y());
        }

        public static MapInfo[] compute(int[] aux, int size, final Point ini)throws IOException{
            if(size <= 0) return null;
            MapInfo[] res = new MapInfo[size];
            for(int i = 0; i < size; ++i){
                Point end = IO.readPoint(aux);
                if(end == null) return null;
                res[i] = new MapInfo(distance(ini, end), end);
            }
            Arrays.sort(res, MapInfo.cmp);
            return res;            
        }
    }
}    

class Main{
    public static void main(String[] args)throws IOException{
        int[] aux = new int[1];
        Point ini = Solution.IO.readPoint(aux);
        if(ini == null) return;
        if(!Solution.IO.readInt(aux)) return;
        int size = aux[0];
        MapInfo[] res = Solution.Game.compute(aux, size, ini);
        if(res == null) return;
        Solution.IO.printRes(res);
        Solution.IO.end();
    }
}
