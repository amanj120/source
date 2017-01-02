package project_euler_3;

public class pe3 {
	
	
	public static void main(String[] args) {
		long ans = 1;
		long initial =600851475143L; 
		long number = 408464633L; // we found this is the first factor
		int counter = 0;
		for(long m = number-1; m < 0; m--){
			if(isPrime(m)){
				if(number % m == 0){
					ans = m;
					break;
				}
			}
			if (counter >= 100000000){
				System.out.println("i am at " + m);
				counter = 0;
			}
			counter++;
			if (initial % m == 0){
				if(isPrime(m)){
					System.out.println(m);
				break;
			}
			}	
		}

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
