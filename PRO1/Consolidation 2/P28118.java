import java.io.*;
import java.text.DecimalFormat;

class Main{
    private static BufferedInputStream bis = new BufferedInputStream(System.in);
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static double readDouble()throws IOException{
        int n;
        while((n = bis.read()) <= ' ' && n != -1 && n != '\n');
        if(n == -1 || n == '\n') return Double.NaN;
        boolean neg = (n == '-');
        if(neg) n = bis.read();
        double total = 0;
        while(n >= '0' && n <= '9'){
            total = total * 10 + (n - '0');
            n = bis.read();
        }
        if(n == '.'){
            double decimal = 1, frac = 0;
            n = bis.read();
            while(n >= '0' && n <= '9'){
                decimal *= 10;
                frac = frac * 10 + (n - '0');
                n = bis.read();
            }
            total += frac/decimal;
        }
        return neg ? - total : total;
    }
    
    public static String readString()throws IOException{
        int n;
        while((n = bis.read()) <= ' ' && n != -1);
        if(n == -1) return null;
        StringBuilder sb = new StringBuilder();
        while(n >= 'a' && n <= 'z'){
            sb.append((char) n);
            n = bis.read();
        }
        return sb.toString();
    }

    public static double distancia(double x1, double y1,double x2, double y2){
        double dx = x1 - x2, dy = y1 - y2;
        return Math.sqrt(dx * dx + dy * dy);
    }
    
    public static void main(String[] args)throws IOException{
        String trajecte;
        DecimalFormat df = new DecimalFormat("0.0000");
        while((trajecte = readString()) != null){
            bw.write("Trajecte ");
            bw.write(trajecte);
            bw.write(": ");
            double disTotal = 0, x1, y1, x2, y2, initx1, inity1;
            if(!Double.isNaN(x1 = readDouble()) && !Double.isNaN(y1 = readDouble())){
                initx1 = x1; inity1 = y1;
                while(!Double.isNaN(x2 = readDouble()) && !Double.isNaN(y2 = readDouble())){
                    disTotal += distancia(x1, y1, x2, y2);
                    if(initx1 == x2 && inity1 == y2) break;
                    x1 = x2;
                    y1 = y2;
                }
            }
            bw.write(df.format(disTotal));
            bw.write('\n');
        }
        bw.close();
    }
}
