import java.io.*;

class Main{
	public static void main(String[] args)throws IOException{
		int parell = 0, senar = 0, index = 0, aux;
		while((aux = System.in.read()) <= ' ' && aux != -1);
		if(aux == -1)return;
		while(aux >= '0' && aux <= '9'){
			if((index&1) == 0) parell += (aux - '0');
			else senar += (aux - '0');
			aux = System.in.read();
			index++;
		}
		if((index&1) != 0){
			aux = parell;
			parell = senar;
			senar = aux;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(senar).append(' ');
		sb.append(parell).append('\n');
		if(parell == 0) sb.append(parell).append(" = ").append(parell).append(" * ").append(senar).append('\n');
		else if(senar == 0) sb.append(senar).append(" = ").append(senar).append(" * ").append(parell).append('\n');
		else if(senar > parell && senar%parell == 0){
			sb.append(senar).append(" = ").append(senar/parell).append(" * ").append(parell).append('\n');
		}
		else if(parell%senar == 0){
			sb.append(parell).append(" = ").append(parell/senar).append(" * ").append(senar).append('\n');
		}
		else sb.append("res\n");
		System.out.print(sb);
	}
}
