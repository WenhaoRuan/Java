import java.io.*;
import java.util.*;

record Track(char[] artist, char[] title, char[] genre, int year){
    Track(){
        this(null, null, null, 0);
    }

    public static final Comparator<Track> cmp = Comparator
        .comparing(Track::genre, Arrays::compare)
        .thenComparing(Track::artist, Arrays::compare)
        .thenComparingInt(Track::year)
        .thenComparing(Track::title, Arrays::compare);
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
            while(n > ' '){
                total = total * 10 + (n - '0');
                n = bis.read();
            }
            return total;
        }

        public static char[] readString()throws IOException{
            int n;
            while((n = bis.read()) <= ' ' && n != -1);
            if(n == -1) return null;
            int len = 0;
            while(n > ' '){
                buff[len++] = (char) n;
                n = bis.read();
            }
            return Arrays.copyOfRange(buff, 0, len);
        }
        
        public static Track readTrack()throws IOException{
            char[] artist = readString();
            if(artist == null) return null;
            char[] title = readString();
            if(title == null) return null;
            char[] genre = readString();
            if(genre == null) return null;
            int year = readNat();
            if(year == -1) return null;
            return new Track(artist, title, genre, year);
        }

        public static Track[] readTracks(int n)throws IOException{
            Track[] res = new Track[n];
            for(int i = 0; i < n; ++i)
                if((res[i] = readTrack()) == null) return null;
            return res;
        }

        public static void printNat(int n)throws IOException{
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

        public static void printTrack(final Track t)throws IOException{
            bw.write(t.artist());
            bw.write(" (");
            printNat(t.year());
            bw.write(") ");
            bw.write(t.title());
            bw.write(" (");
            bw.write(t.genre());
            bw.write(")\n");
        }

        public static void printTrackVec(final Track[] tVec, int ini, int end)throws IOException{
            for(int i = ini; i <= end; ++i) printTrack(tVec[i]);
        }

        public static void end()throws IOException{
            bw.close();
        }
    }

    public static class Game{
        public static int lowerSearch(final Track[] tVec, final char[] genre, int l, int r){
            int res = -1;
            while(l <= r){
                int m = l + ((r - l) >> 1);
                int comp = Arrays.compare(genre, tVec[m].genre());
                if(comp == 0){
                    res = m;
                    r = m - 1;
                }
                else if(comp < 0) r = m - 1;
                else l = m + 1;
            }
            return res;
        }

        public static int upperSearch(final Track[] tVec, final char[] genre, int l, int r){
            int res = -1;
            while(l <= r){
                int m = l + ((r - l) >> 1);
                int comp = Arrays.compare(genre, tVec[m].genre());
                if(comp == 0){
                    res = m;
                    l = m + 1;
                }
                else if(comp < 0) r = m - 1;
                else l = m + 1;
            }
            return res;
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException{
        int size = Solution.IO.readNat();
        if(size < 0) return;
        Track[] mediateca = Solution.IO.readTracks(size);
        Arrays.sort(mediateca,Track.cmp);
        char[] genre;
        while((genre = Solution.IO.readString()) != null){
            int start = Solution.Game.lowerSearch(mediateca, genre, 0, mediateca.length - 1);
            if(start != -1){
                int end = Solution.Game.upperSearch(mediateca, genre, start, mediateca.length - 1);
                Solution.IO.printTrackVec(mediateca, start, end);
            }
        }
        Solution.IO.end();
    }
}
