import java.io.*;

class Main{
    private static BufferedInputStream bis = new BufferedInputStream(System.in);
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int readAndCount()throws IOException{
        int n;
        while((n = bis.read()) != -1 && (n < 'a' ||  n > 'z') && n != '.');
        if(n == '.' || n == -1) return -1;
        int total = 0;
        while(n >= 'a' && n <= 'z'){
            ++total;
            n = bis.read();
        }
        return total;
    }

    public static void main(String[] args)throws IOException{
        int curt, mitja, llarg;
        curt = mitja = llarg = 0;
        int aux;
        while((aux = readAndCount()) != -1){
            if(aux < 5) ++curt;
            else if(aux < 10) ++mitja;
            else ++llarg;
        }
        bw.write(String.valueOf(curt));
        bw.write(',');
        bw.write(String.valueOf(mitja));
        bw.write(',');
        bw.write(String.valueOf(llarg));
        bw.write('\n');
        bw.close();
    }
}
