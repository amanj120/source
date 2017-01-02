import java.util.Arrays;

public class primeSieve {

	public static void main(String[] args) {
		int max = 100000;
		boolean[] isPrime = new boolean[max + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		long start = System.currentTimeMillis();
		for(int i = 2; i*i< max+1; i++){
			for(int j = i*i; j < max+1; j+= i){
				isPrime[j] = false;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

}
