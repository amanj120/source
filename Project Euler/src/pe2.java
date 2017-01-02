

public class pe2 {

	public static void main(String[] args) {
		long sum = 0;
		long fib1 = 0;
		long fib2 = 1;
		long temp = 0;
		while(true){
			if (fib1 >=4000000 || fib2 >= 4000000 ){
				break;
			}
			System.out.println(fib1 + fib2);
			if((fib1 + fib2)%2 == 0){
				sum = sum + (fib1 + fib2);
			}
			temp = fib1;
			fib1 = fib2;
			fib2 = temp + fib2;
			
		}
		System.out.println("sum" + sum);

	}

}
