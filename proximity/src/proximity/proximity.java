package proximity;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class proximity {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner (new FileReader("proximity.in"));
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][]c = new int[3][3];
		int[] things = new int[N];
		for(int i = 0; i < N; i++){
			things[i] = sc.nextInt();
		}
		for(int i = 1; i <=N; i++){
			int t = things[i-1];
			if(c[t][0] != 0){
				if(c[t][1] == 1){
					if(i - c[t][0] < c[t][2]){
						c[t][2] = i - c[t][0];
						c[t][0] = 1;
					}
					else{
						c[t][2] = c[t][2];
					}
				}
				else{
					c[t][2]=(i) - c[t][0];
					c[t][0] = i;
				}
				c[t][1] = 1;
			}
			if(c[t][0] == 0){
				c[t][0] = i;
			}
		}
		for(int i = c.length-1; i >0; i--){
			if(c[i][1] == 1 && c[i][0] <= K){
				System.out.println(i);
				System.exit(0);
			}
		}
		sc.close();
	}
}
