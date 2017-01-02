import java.util.*;
public class cubes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		int low = 1;
		int high = 1000000;
		int s = 0;
		while(low <= high){
			long sum = low * low * low + high * high * high;
			if(sum > n){
				high--;
			}
			if(sum < n){
				low++;
			}
			if(sum == n){
				low++;
				high--;
				s++;
			}
		}
		System.out.println(s);
		sc.close();
	}
}
