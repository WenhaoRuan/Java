import java.io.*;

class Solution{
	public static class IO{
		private static final BufferedInputStream bis = new BufferedInputStream(System.in);
		private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		private static final char[] buff = new char[10];

        private static final String[] unitats = {
            "zero", "un", "dos", "tres", "quatre","cinc", "sis", "set", "vuit", "nou"};
        private static final String[] deuRelated = {
            "deu", "onze", "dotze", "tretze", "catorze", "quinze", "setze", "disset",
            "divuit", "dinou"};
        private static final String[] desenes = {
            "vint", "trenta", "quaranta", "cinquanta", "seixanta", "setanta", "vuitanta", 
            "noranta"};
		
		public static int readNat()throws IOException{
			int n;
			while((n = bis.read()) <= ' ' && n != -1);
			if(n == -1) return n;
            int total = 0;
            while(n > ' '){
                total = total * 10 + (n - '0');
                n = bis.read();
			}
            return total;
        }

        public static void printNat(int n)throws IOException{
            int pos = buff.length;
            while(n > 0){
                buff[--pos] = (char)('0' + (n % 10));
                n /= 10;
            }
            bw.write(buff, pos, buff.length - pos);
        }

        public static void printStart(int n)throws IOException{
            if(n == 0) bw.write('0');
            else printNat(n);
            bw.write(": ");
        }

        public static void printPart(int n, boolean first){
            if(!first) bw.write(' ');
            if(n < 10)  bw.write(unitats[n]);
            else if(n < 20) bw.write(deuRelated[n - 10]);
            else if(n < 100){
                if(n < 30){
                    bw.write(desenes[n/10 - 2]);
                    if(n > 20) bw.write("-i");
                }
                else bw.write(desenes[n/10 - 2]);
                if((n % 10) != 0){
                    bw.write('-');
                    printPart(n % 10);
                }

            }
            else{
                if(n/100 > 1){
                    printPart(n/100, first);
                    bw.write('-');
                    bw.write("cents");
                }
                else{
                    bw.write("cent");
                }
                if(n%100 > 0) printPart(n%100, false);
            }
        }

        public static void printRes(int n)throws IOException{
            int giga = n / 10e9;
            int mega = (n % 10e9) / 10e6;
            int kilo = (n % 10e6) / 10e3;
            int resta = n % 10e3;
            int first = true;
            if(giga > 0){
                if(giga > 1){ 
                    printPart(giga, first);
                    bw.write(" mil");
                }
                else bw.write("mil");
                first = false;
                if(mega == 0) bw.write(" milions");
            }
            if(mega > 0){
                printPart(mega, first);
                if(first && mega > 1) first = false;
                if(first) bw.write(" milio");
                else bw.write(" milions");
            }
            if(kilo > 0){
                printPart(kilo, first);
                if(first) first = false;
                bw.write(" mil");
            }
            if(first || resta != 0) printPart(resta, first);
        }

        public static void printEnd()throws IOException{
            bw.write(".\n");
        }

        public static void end()throws IOException{
            bw.close();
        }
    }

    public static class Game{
        public static void escriuNumero(int n)throws IOException{
            IO.printNat(n);
            IO.printStart();
            IO.printRes(n);
            IO.printEnd();
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        int n;
        while((n = Solution.IO.readNat()) != -1)
            SolutionGame.escriuNumero(n);
        Solution.IO.end();
    }
}
