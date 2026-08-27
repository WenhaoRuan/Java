import java.io.*;

class Assignatura {
    String nom;
    double nota;

    Assignatura(String nom, double nota){
        this.nom = nom;
        this.nota = nota;
    }
}

class Alumne {
    String nom;
    int dni;
    Assignatura[] ass;

    Alumne(String nom, int dni, Assignatura[] ass){
        this.nom = nom;
        this.dni = dni;
        this.ass = ass;
    }
}

class Solution{
    public static class IO{
        private static BufferedInputStream bis = new BufferedInputStream(System.in);
        private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        private static final int buffLen = 256;
        private static final char[] buff = new char[buffLen];

        public static int readNat()throws IOException{
            int n;
            while((n = bis.read()) <= ' ' && n != -1);
            if(n == -1) return n;
            int total = 0;
            while(n >= '0' && n <= '9'){
                total = total * 10 + (n -'0');
                n = bis.read();
            }
            return total;
        }

        public static double readDouble()throws IOException{
            int n;
            while((n = bis.read()) <= ' ' && n != -1);
            if(n == -1) return Double.NaN;
            if(n == '-'){
               bis.read();
               return -1.0;
            }
            int len = 0; 
            while(n  > ' '){
                buff[len++] = (char) n;
                n = bis.read();
            }
            return Double.parseDouble(new String(buff, 0, len));
        }

        public static String readString()throws IOException{
            int n;
            while((n = bis.read()) <= ' ' && n != -1);
            if(n == -1) return null;
            int len = 0;
            while(n > ' '){
                buff[len++] = (char) n;
                n = bis.read();
            }
            return new String(buff, 0, len);
        }

        public static Assignatura readAss()throws IOException{
            String nom;
            double nota;
            if((nom = readString()) == null) return null;
            if(Double.isNaN(nota = readDouble())) return null;
            return new Assignatura(nom, nota);
        }

        public static Assignatura[] readAssVec(int size)throws IOException{
            Assignatura[] assVec = new Assignatura[size];
            for(int i = 0; i < size; ++i)
                if((assVec[i] = readAss()) == null) return null;
            return assVec;
        }

        public static Alumne readAlumne()throws IOException{
            String nom;
            int dni, assLen;
            if((nom = readString()) == null) return null;
            if((dni = readNat()) == -1 || (assLen = readNat()) == -1) return null;
            Assignatura[] assVec = new Assignatura[assLen];
            if((assVec = readAssVec(assLen)) == null) return null;
            return new Alumne(nom, dni, assVec);
        }

        public static Alumne[] readAlVec(int size)throws IOException{
            Alumne[] alVec = new Alumne[size];
            for(int i = 0; i < size; ++i)
                if((alVec[i] = readAlumne()) == null) return null;
            return alVec;
        }

        public static void printRes(int n)throws IOException{
            if(n == 0){
                bw.write("0\n");
                return;
            }
            if(n < 10){
                bw.write((char)(n + '0'));
                bw.write('\n');
                return;
            }
            int pos = buffLen;
            buff[--pos] = '\n';
            while(n > 0){
                buff[--pos] = (char)('0' + (n % 10));
                n /= 10;
            }
            bw.write(buff, pos, buffLen - pos);
        }

        public static void end()throws IOException{
            bw.close();
        }
    }

    public static class Game{
        public static double mitjana(final Assignatura[] ass){
            int assValides = 0;
            double total = 0.0;
            for(Assignatura a : ass)
                if(a.nota != -1){
                    total += a.nota;
                    ++assValides;
                }
            return assValides == 0 ? -1 : total / assValides;
        }

        public static double nota(final Alumne[] alums, int dni, String nom){
            for(Alumne a : alums){
                if(a.dni == dni){
                    for(Assignatura as : a.ass)
                        if(as.nom.equals(nom)) return as.nota;
                }
            }
            return -1.0;
        }

        public static void compta(final Alumne[] alums, int dni, String nom, int[] com){
            com[0] = 0;
            double notaTall = nota(alums, dni, nom);
            for(Alumne a : alums)
                if(mitjana(a.ass) > notaTall) ++com[0];
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        int FacultatSize = Solution.IO.readNat();
        if(FacultatSize <= 0) return;
        Alumne[] Facultat = new Alumne[FacultatSize];
        if((Facultat = Solution.IO.readAlVec(FacultatSize)) == null) return;
        int dni;
        String ass;
        int[] com = new int[1];
        while((dni = Solution.IO.readNat()) != -1 && 
                (ass = Solution.IO.readString()) != null){
            Solution.Game.compta(Facultat, dni, ass, com);
            Solution.IO.printRes(com[0]);
        }
        Solution.IO.end();
    }
}
