import java.io.*;

class Main{
    private static BufferedInputStream bis = new BufferedInputStream(System.in);
    private static int[] values = {1, 6, 4, 3, 1, 6, 6, 6, 3, 6, 7, 4, 5, 3, 
        2, 5, 6, 3, 2, 4, 4, 6, 7, 6, 6, 6};
    // 1 a e // 2 o s // 3 d i n r // 4 c l t u
    // 5 m p // 6 b f g h j q v x y z // 7 k w

    public static int readAndCompute()throws IOException{
        int n;
        while((n = bis.read()) <= ' ' && n != -1);
        if(n == -1) return -1;
        int total = 0;
        while(n >= 'a' && n <= 'z'){
            total += values[n - 'a'];
            n = bis.read();
        }
        return total;
    }
    
    public static void main(String[] args)throws IOException{
        int total = 0, aux;
        while((aux = readAndCompute()) > 0){
            total += aux;
        }
        System.out.println(String.valueOf(total));
    }    
}

