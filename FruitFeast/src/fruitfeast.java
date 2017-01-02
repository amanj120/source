import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class fruitfeast {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("fruitfeast.in"));
		int max = sc.nextInt();
		int B = sc.nextInt();
		int A = sc.nextInt();
		int[] val = new int[((max+1)* 2)];
		val[0] = 1;
		for(int i = 1; i < val.length; i++){
			if(i < Math.min(A, B)){
				val[i] = 0;
			}
			if( i >= A){
				val[i] += val[i-A]%(2^20 + 1)  ;
			}
			if( i >= B){
				val[i] += val[i-B]%(2^20 + 1) ;
			}
		}
		sc.close();
		for(int i = max; i > 0; i--){
			if(val[i] > 0  || val[i*2] > 0){
				System.out.println(i);
				break;
			}
		}
	}
}
