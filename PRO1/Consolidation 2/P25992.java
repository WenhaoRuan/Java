import java.io.*;
import java.util.*;

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

    public record Result(int[] even, int[] odd){}

    public static Result readVec()throws IOException{
        List<Integer> evenL = new ArrayList<>();
        List<Integer> oddL = new ArrayList<>();
        int aux;
        while((aux = readNat()) > 0){
            if((aux & 1) == 0) evenL.add(aux);
            else oddL.add(aux);
        }
        if(aux == -1) return null;
        int[] even = new int[evenL.size()], odd = new int[oddL.size()];
        for(int i = 0; i < evenL.size(); ++i) even[i] = evenL.get(i);
        for(int i = 0; i < oddL.size(); ++i) odd[i] = oddL.get(i);
        return new Result(even, odd);
    }
    
    public static void printVec(int[] v)throws IOException{
       for(int i = 0; i < v.length; ++i){
           if(i > 0) bw.write(' ');
           bw.write(String.valueOf(v[i]));
       }
    }

    public static void merge(int[] v, int l, int m, int r, boolean even){
        int sizeL = m - l + 1, sizeR = r - m;
        int[] L = new int[sizeL], R = new int[sizeR];
        for(int i = 0; i < sizeL; ++i) L[i] = v[l + i];
        for(int i = 0; i < sizeR; ++i) R[i] = v[m + 1 + i];
        int i = 0, j = 0, k = l;
        while(i < sizeL && j < sizeR){
            if(even){
                if(L[i] <= R[j]) v[k++] = L[i++];
                else v[k++] = R[j++];
            }
            else{
                if(L[i] >= R[j]) v[k++] = L[i++];
                else v[k++] = R[j++];
            }
        }
        while(i < sizeL) v[k++] = L[i++];
        while(j < sizeR) v[k++] = R[j++];
    }

    public static void mergeSort(int[] v, int l, int r, boolean even){
        if(l >= r) return;
        int m = l + (r - l) / 2;
        mergeSort(v, l, m, even);
        mergeSort(v, m + 1, r, even);
        merge(v, l, m, r, even);
    }

    public static void main(String[] args)throws IOException{
        Result result;
        while((result = readVec()) != null){
            int[] even = result.even(), odd = result.odd();
            if(even.length != 0){
                mergeSort(even, 0, even.length - 1, true);
                printVec(even);
            }
            bw.write('\n');
            if(odd.length != 0){
                mergeSort(odd, 0, odd.length - 1, false);
                printVec(odd);
            }
            bw.write('\n');
        }
        bw.close();        
    }
}
