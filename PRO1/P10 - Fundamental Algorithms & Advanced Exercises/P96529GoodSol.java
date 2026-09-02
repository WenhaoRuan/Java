import java.io.*;

class Main{
    private static final BufferedInputStream bis = new BufferedInputStream(System.in);
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final char[] buff = new char[256];

    //retorna true si tot va be, false si acaba abans de llegir res,
    //o la linia de caracters conte un caracter que no pertoca.
    //El resultat de si la linia es valida o no la deixa en res.
    public static boolean readAndProcess(boolean[] res)throws IOException{
        int n;
        while((n = bis.read()) <= ' ' && n != -1);
        if(n == -1) return false;
        int len = 0;
        boolean valid = true;
        while(n > ' '){
            if(valid){
                switch(n){
                    case '[' -> buff[len++] = (char) n;
                    case ']' ->{
                        if(len > 0 && buff[len - 1] == '[') --len;
                        else valid = false;
                    }
                    case '(' -> buff[len++] = (char) n;
                    case ')' ->{
                        if(len > 0 && buff[len - 1] == '(') --len;
                        else valid = false;
                    }
                    default -> valid = false;
                }
            }
            n = bis.read();
        }
        res[0] = valid && (len == 0);
        return true;
    }

    public static void main(String[] args)throws IOException{
        int n;
        boolean[] res = new boolean[1];
        while(readAndProcess(res)){
            if(res[0]) bw.write("si\n");
            else bw.write("no\n");
        }
        bw.close();
    }
}
