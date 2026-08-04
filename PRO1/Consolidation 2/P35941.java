import java.io.*;

class Main{ 
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedInputStream bis = new BufferedInputStream(System.in);

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

    public static boolean getCypher(char[] cypher)throws IOException{
        int aux, it = 0;
        while(it < 26){
            aux = bis.read();
            if(aux == -1) return false;
            if(aux != '\n' && aux != '\r') cypher[aux] = (char) ('a' + it++);
        }
        return true;
    }

    public static void translator(char[] cypher)throws IOException{
        int aux;        
        while((aux = bis.read()) != '\n' && aux != '\r' && aux != -1){
            if(aux == '\n') break;
            if(aux == '\r') continue;
            if(aux == '_') bw.write(' ');
            else bw.write(cypher[aux]);
        }
    }
    
    public static void main(String[] args)throws IOException{
        char[] cypher = new char[256];
        int lines;
        while(getCypher(cypher)){
            if((lines = readNat()) == -1) break;
            for(int i = 0; i < lines; ++i){
                translator(cypher);
                bw.write('\n');
            }
            bw.write('\n');
        }
        bw.close();
    }
}
