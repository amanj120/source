import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class factorial {
	public static boolean[] primes = new boolean[1000000];
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("factorial.in"));
		long n = sc.nextInt();
		long m = sc.nextInt();
		primeMaker();
		ArrayList<Integer> factors = new ArrayList<Integer>();
		while(!primes[(int) m]){
			for(long i = 2; i < m; i++){
				if(primes[(int) i] && m%i == 0){
					factors.add((int) i);
					m = m/i;
				}
			}
		}
		sc.close();
		
	}
	public static void primeMaker(){
		Arrays.fill(primes, true);
		primes[0] = primes[1] = false;
		for(long i = 2; i * i < primes.length; i++){
			for(long j = i * i; j * j < primes.length; j = j+i ){
				primes[(int) j] = false;
			}
		}
	}

}
