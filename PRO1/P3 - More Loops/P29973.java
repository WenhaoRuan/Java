import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();		
		int size = (number * (number + 1)) / 2 + number, index = 0;
		char[] map = new char[size];
		for(int i = 0; i < number; ++i){
			for(int j = 0; j <= i; ++j){
				map[index++] = '*';
			}
			map[index++] = '\n';
		}
		System.out.print(map);
	}
}
