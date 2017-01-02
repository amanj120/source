
import java.util.*;


public class pokeemango {

	@SuppressWarnings("resource")
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n < 2){
			System.out.println(n);
			return;
		}
		TreeMap<Double, Integer> tm = new TreeMap<Double, Integer>();
		for(int i = 0; i < n; i++){
			double s = sc.nextDouble();
			double e = sc.nextDouble() + 0.1;
			if(tm.containsKey(s)){
				tm.put(s, tm.get(s) + 1);
			}
			else tm.put(s, 1);
			if(tm.containsKey(e)){
				tm.put(e, tm.get(e) - 1);
			}
			else tm.put(e, -1);
		}
		int h = tm.size();
		int[] cumSum = new int[h];
		cumSum[0] = tm.get(tm.firstKey());
		tm.remove(tm.firstKey());
		for(int i = 1; i < h; i++){
			cumSum[i] = cumSum[i-1] + tm.get(tm.firstKey());
			tm.remove(tm.firstKey());
		}
		int ans = 0;
		if(cumSum[0] > cumSum[1]){
			ans++;
		}
		for(int i = 1; i < cumSum.length - 1; i++){
			if(cumSum[i] > cumSum[i-1] && cumSum[i] > cumSum[i+1]){
				ans++;
			}
		}
		System.out.println(ans);
		sc.close();
	}

}
