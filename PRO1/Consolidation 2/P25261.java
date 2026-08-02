import java.io.*;

class Main{
    private static BufferedInputStream bis = new BufferedInputStream(System.in);
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static int readInt()throws IOException{
        int n;
        while((n = bis.read()) <= ' ' && n != -1);
        if(n == -1) return n;
        boolean neg = (n == '-');
        if(neg) n = bis.read();
        int total = 0;
        while(n >= '0' && n <= '9'){
            total = total * 10 + (n - '0');
            n = bis.read();
        }
        return neg ? - total : total;
    }
    
    public static void merge(int[] v, int l, int mid, int r){
        int sizeL = mid - l + 1, sizeR = r - mid;
        int[] L = new int[sizeL], R = new int[sizeR];
        for(int i = 0; i < sizeL; ++i)L[i] = v[l + i];
        for(int i = 0; i < sizeR; ++i)R[i] = v[mid + 1 + i];
        int i = 0, j = 0, k = l;
        while(i < sizeL && j < sizeR){
            if(L[i] >= R[j]) v[k++] = L[i++];
            else v[k++] = R[j++];
        }
        while(i < sizeL) v[k++] = L[i++];
        while(j < sizeR) v[k++] = R[j++];
    }

    public static void mergeSort(int[] v, int l, int r){
        if(l >= r) return;
        int mid = l + (r - l)/2;
        mergeSort(v, l, mid);
        mergeSort(v, mid + 1, r);
        merge(v, l, mid, r);
    }

    public static int[] readVec(int size)throws IOException{
        int[] v = new int[size];
        for(int i = 0; i < size; ++i) v[i] = readInt();
        return v;
    }

    public static void printVec(int[] v)throws IOException{
        for(int i = 0; i < v.length; ++i){
            if(i != 0) bw.write(' ');
            bw.write(String.valueOf(v[i]));
        }
        bw.write('\n');
    }

    public static void main(String[] args)throws IOException{
        int size;
        while((size = readInt()) >= 0){
            int[] v = readVec(size);
            mergeSort(v, 0, size -1);
            printVec(v);
        }
        bw.close();
    }
}
