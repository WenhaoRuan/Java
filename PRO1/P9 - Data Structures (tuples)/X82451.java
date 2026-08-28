import java.io.*;

class Point{
    int x, y;

    Point(){
        this(0, 0);
    }

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Rectangle{
    int xmin, ymin, xmax, ymax;

    Rectangle(){
        this(0, 0, 0, 0);
    }

    Rectangle(int xmin, int ymin, int xmax, int ymax){
        this.xmin = xmin;
        this.ymin = ymin;
        this.xmax = xmax;
        this.ymax = ymax;
    }
}

enum Place{
    OUTSIDE(0),
    BORDER(1),
    INSIDE(2);

    public final int index;

    Place(int index){
        this.index = index;
    }
}

class Solution{
    public static class IO{
        private static final BufferedInputStream bis = new BufferedInputStream(System.in);
        private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        private static final String[] res = {"outside\n", "border\n", "inside\n"};

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

        public static boolean readPoint(Point p, int[] aux)throws IOException{
            if(!readInt(aux)) return false;
            p.x = aux[0];
            if(!readInt(aux)) return false;
            p.y = aux[0];
            return true;
        }

        public static boolean readRectangle(Rectangle r, int[] aux)throws IOException{
            if(!readInt(aux)) return false;
            r.xmin = aux[0];
            if(!readInt(aux)) return false;
            r.ymin = aux[0];
            if(!readInt(aux)) return false;
            r.xmax = aux[0];
            if(!readInt(aux)) return false;
            r.ymax = aux[0];
            return true;
        }

        public static void printRes(int n)throws IOException{
            bw.write(res[n]);
        }

        public static void end()throws IOException{
            bw.close();
        }
    }

    public static class Game{
        public static int containment(Point p, Rectangle r){
            if(p.x > r.xmax || p.x < r.xmin || p.y > r.ymax || p.y < r.ymin) return Place.OUTSIDE.index;
            if(p.x == r.xmax || p.x == r.xmin || p.y == r.ymax || p.y == r.ymin) return Place.BORDER.index;
            return Place.INSIDE.index;
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        int[] aux = new int[1];
        if(!Solution.IO.readInt(aux)) return;
        int cases = aux[0];
        if(cases <= 0) return;
        Point p = new Point();
        Rectangle r = new Rectangle();
        for(int i = 0; i < cases; ++i){
            if(!Solution.IO.readPoint(p, aux)) break;
            if(!Solution.IO.readRectangle(r, aux)) break;
            Solution.IO.printRes(Solution.Game.containment(p, r));
        }
        Solution.IO.end();
        
    }
}
