import java.io.*;
import java.util.*;

record Professor(int caramels, int pastanagues, String name){
    public static final Comparator<Professor> cmp =
        Comparator.comparingInt(Professor::caramels).reversed()
        .thenComparing((p1, p2) -> Integer.compare(p2.pastanagues(), p1.pastanagues()))
        .thenComparingInt(p -> p.name().length())
        .thenComparing(Professor::name);
}

class Solution{
    public static class IO{
        private static final BufferedInputStream bis = new BufferedInputStream(System.in);
        private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        private static final char[] buff = new char[256];

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

        public static String readString()throws IOException{
            int n;
            while((n = bis.read()) <= ' ' && n != -1);
            if(n == -1) return null;
            int len = 0;
            while((n >= 'A' && n <= 'Z') || (n >= 'a' && n <= 'z')){
                buff[len++] = (char) n;
                n = bis.read();
            }
            return new String(buff, 0, len);
        }

        public static Professor readProf()throws IOException{
            String nom;
            if((nom = readString()) == null) return null;
            int caramels, pastanagues;
            if((caramels = readNat()) == -1 || (pastanagues = readNat()) == -1) return null;
            return new Professor(caramels, pastanagues, nom);
        }

        public static void printString(final String s)throws IOException{
            bw.write(s);
            bw.write('\n');
        }

        public static void printProfessorat(final TreeSet<Professor> Professorat)throws IOException{
            if(Professorat != null) for(Professor p : Professorat) printString(p.name());
            bw.write('\n');
        }


        public static void end()throws IOException{
            bw.close();
        }
    }

    public static class Game{
        public static TreeSet<Professor> readAndSort(int n)throws IOException{
            if(n == 0) return null;
            TreeSet<Professor> Professorat = new TreeSet<>(Professor.cmp);
            for(int i = 0; i < n; ++i){
                Professor prof = IO.readProf();
                if(prof == null || !Professorat.add(prof)) return null;
            }
            return Professorat;            
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        int casos = Solution.IO.readNat();
        if(casos <= 0) return;
        for(int i = 0; i < casos; ++i){
            int profSize = Solution.IO.readNat();
            if(profSize == -1) break;
            Solution.IO.printProfessorat(Solution.Game.readAndSort(profSize));
        }
        Solution.IO.end();
    }
}
