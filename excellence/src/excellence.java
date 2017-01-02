import java.util.Arrays;
import java.util.Scanner;

public class excellence {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int j = sc.nextInt();
		int[] l = new int[j];
		for(int i = 0; i < j; i++){
			l[i] = sc.nextInt();
		}
		Arrays.sort(l);
		int[] sums = new int[j/2];
		for(int i = 0; i < j/2; i++){
			sums[i] = l[i] + l[j - 1 - i];
		}
		Arrays.sort(sums);
		System.out.println(sums[0]);
		sc.close();
	}

}
