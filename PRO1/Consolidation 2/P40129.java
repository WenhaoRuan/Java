import java.io.*;

class Main{
    private static BufferedInputStream bis = new BufferedInputStream(System.in);
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int readNat()throws IOException{
        int n;
        while((n = bis.read()) <= ' ' && n != -1);
        if(n == -1) return n;
        if(n >= '0' && n <= '9') return n - '0';
        else if(n == 'X') return 10;
        else return -2;
    }

    public static int[] readISBN()throws IOException{
        int size = 10;
        int[] ISBN = new int[size];
        for(int i = 0; i < size; ++i) if((ISBN[i] = readNat()) == -1) break;
        return ISBN;
    }

    public static int solveISBN(int[] ISBN){
        int mult = 10, total = 0, aux, stage = -1;
        for(int i = 0; i < ISBN.length; ++i){
            aux = ISBN[i];
            if(aux == -1) return -1;
            else if(aux == -2) stage = mult;
            else total += ISBN[i] * mult;
            --mult;
        }
        for(int i = 0; i <= 10; ++i)
            if((total + i * stage) % 11 == 0) return i;
        return -1;
    }

    public static void main(String[] args)throws IOException{
        int[] ISBN = readISBN();
        int size = 10, sol;
        while((sol = solveISBN(ISBN)) != -1){
            if(sol == 10) bw.write('X');
            else bw.write((char)(sol + '0'));
            bw.write('\n');
            ISBN = readISBN();
        }
        bw.close();
    }
}
