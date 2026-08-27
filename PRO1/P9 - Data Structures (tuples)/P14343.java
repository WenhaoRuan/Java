import java.io.*;
import java.util.*;

record Pair(int freq, int idn){}

enum status{
    UNASSIGNED(0),
    RED(1),
    YELLOW(2),
    GREEN(3);
    
    public final int index;

    status(int index){
        this.index = index;
    }
}


class Submission{   
    String idn;
    String exer;
    int time;
    status res;

    Submission(String idn, String exer, int time, status res){
        this.idn = idn;
        this.exer = exer;
        this.time = time;
        this.res = res;
    }
}

class infoEst{
    int[] exerRes;
    int redCount;
    int yellowCount;
    int greenCount;
    int greenSubCount;
    
    infoEst(int numOfEx){
        this.exerRes = new int[numOfEx] ;
    }
}

class Solution{
    public static class IO{
        private static BufferedInputStream bis = new BufferedInputStream(System.in);
        private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        private static final char[] buff = new char[10];
        
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
            while(n > ' '){
                buff[len++] = (char) n;
                n = bis.read();
            }
            return new String(buff, 0, len);
        }

        public static status readSubRes()throws IOException{
            String s = readString();
            if(s == null) return status.UNASSIGNED;
            return switch(s){
                case "red" -> status.RED;
                case "yellow" -> status.YELLOW;
                case "green" -> status.GREEN;
                default -> status.UNASSIGNED;
            };
        }

        public static Submission readSubmission()throws IOException{
            String idn, exer;
            int time;
            status res;
            if((idn = readString()) == null) return null;
            if((exer = readString()) == null) return null;
            if((time = readNat()) == -1) return null;
            if((res = readSubRes()) == status.UNASSIGNED) return null;
            return new Submission(idn, exer, time, res);
        }

        public static int readVecMap(Submission[] History, 
                Map<String, Integer> exercicis, int subs)throws IOException{
            int numOfEx = 0;
            for(int i = 0; i < subs; ++i){
                Submission s = Solution.IO.readSubmission();
                if(s == null) return -1;
                if(!exercicis.containsKey(s.exer))
                    exercicis.put(s.exer, numOfEx++);
                History[i] = s;
            }
            return numOfEx;
        }

        public static void printInt(int n)throws IOException{
            if(n == 0){
                bw.write('0');
                return;
            }
            int pos = buff.length;
            while(n > 0){
                buff[--pos] = (char)('0' + (n % 10));
                n /= 10;
            }
            bw.write(buff, pos, buff.length - pos);
        }

        public static void printLine(String s, String idn, int freq)throws IOException{
            bw.write(s);
            if(idn != null){
                bw.write(idn);
                bw.write(" (");
                printInt(freq);
                bw.write(")\n");
            }
            else bw.write("-\n");
        }
        public static void printRes(String idnGS, int nGS, String idnGE, int nGE,
                String idnRE, int nRE, String idnTE, int nTE, String idnLS)throws IOException{
            printLine("student with more green submissions:       ", idnGS, nGS);
            printLine("student with more green exercises:         ", idnGE, nGE);
            printLine("student with more red exercises:           ", idnRE, nRE);
            printLine("student with more tried exercises:         ", idnTE, nTE);
            bw.write("student who has done the last submission:  ");
            if(idnLS != null){
                bw.write(idnLS);
                bw.write('\n');
            }
            else bw.write("-\n");
        }

        public static void end()throws IOException{
            bw.close();
        }
    }

    public static class Game{
        public static String EmplenaJutge(Submission[] History,Map<String, infoEst> Plataforma, 
                Map<String, Integer> exercicis, int numOfEx){
            int lastSubTime = -1;
            String idnLS = null;
            for(Submission s : History){
                if(!Plataforma.containsKey(s.idn))
                    Plataforma.put(s.idn, new infoEst(numOfEx));
                infoEst est = Plataforma.get(s.idn);
                int exercici = exercicis.get(s.exer);
                switch(s.res){
                    case RED ->{
                        if(est.exerRes[exercici] < status.RED.index){
                            est.exerRes[exercici] = status.RED.index;
                            ++est.redCount;
                        }
                    }
                    case YELLOW ->{
                        if(est.exerRes[exercici] < status.YELLOW.index){
                            if(est.exerRes[exercici] == status.RED.index)
                                --est.redCount;
                            est.exerRes[exercici] = status.YELLOW.index;
                            ++est.yellowCount;
                        }
                    }
                    case GREEN ->{
                        if(est.exerRes[exercici] < status.GREEN.index){
                            if(est.exerRes[exercici] == status.RED.index)
                                --est.redCount;
                            else if(est.exerRes[exercici] == status.YELLOW.index)
                                --est.yellowCount;
                            est.exerRes[exercici] = status.GREEN.index;
                            ++est.greenCount;
                        }
                        ++est.greenSubCount;
                    }
                    default -> { return null;}
                }
                if(s.time > lastSubTime){
                    lastSubTime = s.time;
                    idnLS = s.idn;
                }
            }
            return idnLS;
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        int subs = Solution.IO.readNat();
        if(subs < 0) return;
        if(subs == 0){
            Solution.IO.printRes(null, 0, null, 0, null, 0, null, 0, null);
            Solution.IO.end();
            return;
        }
        Submission[] History = new Submission[subs];
        Map<String, Integer> exercicis = new TreeMap<>();
        int numOfEx = Solution.IO.readVecMap(History, exercicis, subs);
        if(numOfEx == -1){
            Solution.IO.printRes(null, 0, null, 0, null, 0, null, 0, null);
            Solution.IO.end();
            return;
        }
        Map<String, infoEst> Plataforma= new TreeMap<>();
        String idnLS = Solution.Game.EmplenaJutge(History, Plataforma, exercicis, numOfEx);
        if(idnLS == null){
            Solution.IO.printRes(null, 0, null, 0, null, 0, null, 0, null);
            Solution.IO.end();
            return;
        }       
        int maxGS = 0, maxGE = 0, maxRE = 0, maxTE = 0;
        String idnGS = null, idnGE = null, idnRE = null, idnTE = null;
        for(Map.Entry<String, infoEst> entry : Plataforma.entrySet()){
            String idn = entry.getKey();
            infoEst est = entry.getValue();
            if(est.greenSubCount > maxGS){
                maxGS = est.greenSubCount;
                idnGS = idn;
            }
            if(est.greenCount > maxGE){
                maxGE = est.greenCount;
                idnGE = idn;
            }
            if(est.redCount > maxRE){
                maxRE = est.redCount;
                idnRE = idn;
            }
            int tried = est.greenCount + est.yellowCount + est.redCount;
            if(tried > maxTE){
                maxTE = tried;
                idnTE = idn;
            }
        }
        Solution.IO.printRes(idnGS, maxGS, idnGE, maxGE, idnRE, maxRE, idnTE, maxTE, idnLS);
        Solution.IO.end();
    }
}
