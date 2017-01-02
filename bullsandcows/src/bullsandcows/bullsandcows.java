package bullsandcows;
import java.util.Scanner;
public class bullsandcows {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] vals = new int[sc.nextInt()+1];
		int k = sc.nextInt();
		for(int i = 0; i <= k + 1; i++){
			vals[i] = i+1;
		}
		for(int i = k+2; i < vals.length - 1 + 1; i++){
			vals[i] = (vals[i-1] + vals[i - (k+1)]) % 5000011;
		}
		System.out.println(vals[vals.length - 1]);
		sc.close();
	}
}
