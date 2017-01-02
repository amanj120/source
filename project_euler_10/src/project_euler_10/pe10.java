package project_euler_10;

public class pe10 {

	public static void main(String[] args) {
		long ans = 0L;
		for(int i = 2; i < 2000001; i++){
			if(isPrime(i)){
				ans = ans + i;
			}
		}
		System.out.println(ans + 2);
	}
	public static boolean isPrime(long n){
		if (n%2==0) return false;
		    //if not, then just check the odds
		    for(long i=3;i*i<=n;i+=2) {
		        if(n%i==0)
		            return false;
		    }
		    return true;
	}
}
