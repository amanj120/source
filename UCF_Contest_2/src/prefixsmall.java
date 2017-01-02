import java.util.*;
public class prefixsmall {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int n = 2;
		int k = 20;
		boolean[] primes = new boolean[k + 1];
		Arrays.fill(primes,  true);
		TreeSet<Integer> pNos = new TreeSet<Integer>();
		primes[0] = primes[1] = false;
		//TreeSet<Integer> cumSum = new TreeSet<Integer>();
		for(int i = 2; i <= k; i++){
			if(primes[i]){
				for(int j = 2 * i; j <= k; j = j+i){
					primes[j] = false;
				}
				pNos.add(i);
			}
		}
		/*cumSum.add(pNos.);
		for(int i = 1; i < pNos.size() - 1; i++){
			cumSum.add(pNos.get(i) + cumSum.get(i-1));
		}*/
		
		sc.close();
	}

}
