import java.util.*;
public class B {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cities = sc.nextInt();
		int kapitals = sc.nextInt();
		int[] cVals = new int[cities];
		long citySum = 0;
		long kapSum = 0;
		long sum = 0;
		cVals[0] = sc.nextInt();
		citySum += cVals[0];
		for(int i = 1; i < cities; i++){
			cVals[i] = sc.nextInt();
			sum += cVals[i] * cVals[i-1];
			citySum += cVals[i];
		}
		sum += cVals[0] * cVals[cities-1];
		HashSet<Integer> caps = new HashSet<Integer>();
		for(int i = 0; i < kapitals; i++){
			int k = sc.nextInt() - 1;
			caps.add(k);
			kapSum += cVals[k];
			if(k == 0){
				long mult = citySum - kapSum;
				if(!caps.contains(1)) mult -= cVals[1];
				if(!caps.contains(cities  - 1)) mult -= cVals[cities - 1];
				sum += cVals[0] * mult;
				continue;
			}
			if(k == cities - 1){
				long mult = citySum - kapSum;
				if(!caps.contains(k  - 1)) mult -= cVals[k-1];
				if(!caps.contains(0)) mult -= cVals[0];
				sum += cVals[cities-1] * mult;
				continue;
			}
			else{
				long mult = citySum - kapSum;
				if(!caps.contains(k  + 1)) mult -= cVals[k+1];
				if(!caps.contains(k  - 1)) mult -= cVals[k - 1];
				sum += cVals[k] * mult;
				continue;
			}
		}
		System.out.println(sum);
		sc.close();
	}
}
