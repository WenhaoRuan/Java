import java.io.*;

class Main{
	public static boolean trobaHola()throws IOException{
		char[] target = {'h', 'o', 'l', 'a'};
		int len = 4, streak = 0, aux;
		while((aux = System.in.read()) <= ' ' && aux != -1);
		if(aux == -1 || aux == '.') return false;
		while(aux >= 'a' && aux <= 'z'){
			if(aux == target[streak]){
				++streak;
				if(streak == len) return true;
			}
			else if(aux == target[0]) streak = 1;
			else streak = 0;
			aux = System.in.read();
		}
		return false;
	}

	public static void main(String[] args)throws IOException{
		boolean res = trobaHola();
		if(res) System.out.println("hola");
		else System.out.println("adeu");
	}
}
