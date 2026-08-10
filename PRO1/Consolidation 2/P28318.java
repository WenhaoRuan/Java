import java.io.*;

class Main{
    private static BufferedInputStream bis = new BufferedInputStream(System.in);
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static boolean EOF = false;
    
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

    public static int readInt()throws IOException{
        int n;
        while((n = bis.read()) <= ' ' && n != -1);
        if(n == -1){
            EOF = true;
            return n;
        }
        boolean neg = (n == '-');
        if(neg) n = bis.read();
        int total = 0;
        while(n >= '0' && n <= '9'){
            total = total * 10 + (n - '0');
            n = bis.read();
        }
        return neg ? - total : total;
    }

    public static int[][] readMat(int rows, int cols)throws IOException{
        int[][] mat = new int[rows][cols];
        int aux;
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                mat[i][j] = readInt();
                if(EOF) break;               
            }
        }
        return mat;
    }

    public static String readString(StringBuilder sb)throws IOException{
        int n;
        while((n = bis.read()) <= ' ' && n != -1);
        if(n == -1) return null;
        sb.setLength(0);
        while(n >= 'a' && n <= 'z'){
            sb.append((char)n);
            n = bis.read();
        }
        return sb.toString();        
    }
   
    public static void main(String[] args)throws IOException{
        int rows, cols;
        if((rows = readNat()) != -1 && (cols = readNat()) != -1){
            int[][] mat = readMat(rows, cols);
            String s;
            StringBuilder sb = new StringBuilder();
            int fila, columna;
            while((s = readString(sb)) != null){
                switch(s){
                    case "fila" -> {
                        if((fila = readNat()) == -1) break;
                        bw.write("fila ");
                        bw.write(String.valueOf(fila));
                        bw.write(':');
                        for(int i = 0; i < cols; ++i){
                            bw.write(' ');
                            bw.write(String.valueOf(mat[fila - 1][i]));                
                        }
                        bw.write('\n');
                    }
                    case "columna" -> {
                        if((columna = readNat()) == -1) break;
                        bw.write("columna ");
                        bw.write(String.valueOf(columna));
                        bw.write(':');
                        for(int i = 0; i < rows; ++i){
                            bw.write(' ');
                            bw.write(String.valueOf(mat[i][columna - 1]));
                        }
                        bw.write('\n');
                    }
                    default -> {
                        if((fila = readNat()) == -1 || (columna = readNat()) == -1) break;
                        bw.write("element ");
                        bw.write(String.valueOf(fila));
                        bw.write(' ');
                        bw.write(String.valueOf(columna));
                        bw.write(':');                        
                        bw.write(' ');
                        bw.write(String.valueOf(mat[fila - 1][columna - 1]));
                        bw.write('\n');
                    }
                }
            }
            bw.close();
        }
    }
}

