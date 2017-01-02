

public class pe12 {

	public static void main(String[] args) {
		long trig = 0;
		for(long i = 1; i< 100000000000000000L; i++){
			trig = trig + i;
			if(howManyDivisiors(trig)>= 250){
				System.out.println(trig);
				break;
			}
		}
	}
	public static int howManyDivisiors(long n){
		int ans = 0;
		for(long i = 1; i*i<=n; i++){
			if(n%i == 0){
				ans++;
			}
		}
		if(ans>100){
			System.out.println(ans + " " + n);
		}
		return ans;
	}
}
