import java.io.*;

class Main{
	public static void main(String[] args)throws IOException{
		int aux;
		while((aux = System.in.read()) <= ' ' && aux != -1);
		if(aux == -1) return;
		int rowscols = 0, total = 0;
		while(aux >= '0' && aux <= '9'){
			rowscols = rowscols * 10 + (aux -'0');
			aux = System.in.read();
		}
		for(int i = 0; i < rowscols; ++i){
			for(int j = 0; j < rowscols; ++j){
				while(aux <= ' ' && aux != -1) aux = System.in.read();
				if(aux == -1) return;
				if(j == i || j == rowscols - i - 1) {
					total += (aux - '0');
				}
				aux = System.in.read();
			}
		}
		System.out.println(total);
	}
}
