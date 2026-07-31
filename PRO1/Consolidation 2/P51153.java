import java.io.*;

class Main{
    private static BufferedInputStream bis = new BufferedInputStream(System.in);
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
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

    public static void main(String[] args)throws IOException{
        int amount;
        while((amount = readNat()) != -1){
            int aux;
            boolean teParell = false, teSenar = false;
            for(int i = 0; i < amount; ++i){
                if((aux = readNat()) == -1) break;
                if((aux & 1) == 0) teParell = true;
                else teSenar = true;
            }
            if(teParell && teSenar) bw.write("si\n");
            else bw.write("no\n");
        }
        bw.close();
    }
}
