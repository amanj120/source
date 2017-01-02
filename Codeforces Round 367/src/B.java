import java.util.*;
import java.io.*;
public class B {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] vals = new int[n];
		TreeSet<Integer> v = new TreeSet<Integer>();
		for(int i = 0; i < n; i++){
			vals[i] = sc.nextInt();
			v.add(vals[i]);
		}
		Arrays.sort(vals);
		int q = sc.nextInt();
		for(int i = 0; i < q; i++){
			int t = sc.nextInt();
			if(t < vals[0]){
				System.out.println(0);
				continue;
			}
			if(t >= vals[n - 1]){
				System.out.println(n);
				continue;
			}
			int low = 0;
			int high = n;
			int guess = (n-1)/2;
			int target = v.higher(t);
			while(true){
				if(vals[guess] == target){
					while(true){
						if(vals[guess - 1] == vals[guess]){
							guess--;
						}
						else{
							break;
						}
					}
					System.out.println(guess);
					break;
				}
				if(vals[guess] > target){
					high = guess;
					guess = (high - low)/2 + low;
				}
				if(vals[guess] < target){
					low = guess;
					guess = (high - low)/2 + low;
				}
			}
		}
		sc.close();
	}
}
