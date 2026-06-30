import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int hora = input.nextInt(), minut = input.nextInt(),
		segon = input.nextInt();
		++segon;
		int aux = segon%60;
		String outSegon = (aux < 10) ? "0" + aux: Integer.toString(aux);
		minut = minut + segon/60;
		aux = minut%60;
		String outMinut = (aux < 10) ? "0" + aux: Integer.toString(aux);
		hora = hora + minut/60;
		aux = hora%24;
		String outHora = (aux < 10) ? "0" + aux: Integer.toString(aux);
		System.out.println(outHora + ':' + outMinut + ':' + outSegon);
		input.close();
	}
}
