import java.io.*;

class Temps{
    int hora, minut, segon;

    Temps(int hora, int minut, int segon){
        this.hora = hora;
        this.minut = minut;
        this.segon = segon;
    }
}

class Solution{
    public static class IO{
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

        public static void printRes(Temps t)throws IOException{
            bw.write(String.valueOf(t.hora));
            bw.write(' ');
            bw.write(String.valueOf(t.minut));
            bw.write(' ');
            bw.write(String.valueOf(t.segon));
            bw.write('\n');
        }

        public static void end()throws IOException{
            bw.close();
        }
    }

    public static class Game{
        public static void unSegon(Temps t, Temps t1, Temps t2){
            if((t1.segon = t.segon + 1) == 60){
                t1.segon = 0;
                if((t1.minut = t.minut + 1) == 60){
                    t1.minut = 0;
                    if((t1.hora = t.hora + 1) == 24){
                        t1.hora = 0;
                    }
                }
                else t1.hora = t.hora;
            }
            else{
                t1.minut = t.minut;
                t1.hora = t.hora;
            }
            if((t2.segon = t.segon - 1) < 0){
                t2.segon = 59;
                if((t2.minut = t.minut - 1) < 0){
                    t2.minut = 59;
                    if((t2.hora = t.hora - 1) < 0){
                        t2.hora = 23;
                    }
                }
                else t2.hora = t.hora;
            }
            else{
                t2.minut = t.minut;
                t2.hora = t.hora;
            }
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        Temps t = new Temps(0, 0, 0), t1 = new Temps(0, 0, 0), t2 = new Temps(0, 0, 0);
        while((t.hora = Solution.IO.readNat()) != -1 &&
                (t.minut = Solution.IO.readNat()) != -1 &&
                (t.segon = Solution.IO.readNat()) != -1){
            Solution.Game.unSegon(t, t1, t2);
            Solution.IO.printRes(t1);
            Solution.IO.printRes(t2);
        }
        Solution.IO.end();
    }
}
