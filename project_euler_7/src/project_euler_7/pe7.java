package project_euler_7;

public class pe7 {

	public static void main(String[] args) {
		int counter = 0;
		for(long i = 2; i< 1000000000000000000L; i++){
			if(isPrime(i)){
				counter++;
				System.out.println(i + "counter" + counter);
			}
			if(counter == 10000){
				System.out.println("**************" + i);
				break;
			}
		}
	}
	public static boolean isPrime(long n){
		if (n%2==0) return false;
		    for(long i=3;i*i<=n;i+=2) {
		        if(n%i==0)
		            return false;
		    }
		    return true;
	}
}
