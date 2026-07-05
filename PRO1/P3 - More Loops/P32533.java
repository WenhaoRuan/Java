import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		char[] map = new char[(size + 1) * size];
		int iter = 0;
		for(int i = 0; i < size; ++i){
			for(int j = 0; j < size - i - 1; ++j) map[iter++] = '+';
			map[iter++] = '/';
			for(int j = 0; j < i; ++j) map[iter++] = '*';
			map[iter++] = '\n';
		}
		System.out.print(map);		
	}
}
