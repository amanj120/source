import java.util.*;
import java.io.*;
public class prankwar {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int[] pranks = new int[n];
		for(int i = 0; i <n; i++)
			pranks[i] = sc.nextInt();
		Arrays.sort(pranks);
		int weight = 0;
		int i = 0;
		while(i < pranks.length){
			if(pranks[i] + weight <= w){
				weight+= pranks[i];
				i++;
			}
			else break;
		}
		System.out.println(i + 1);
		sc.close();
	}
}