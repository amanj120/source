

public class pe6 {
	public static void main(String[] args){
		int sumOfstuff = 0;
		int sumsquare = 0;
		for(int i = 1; i< 101; i++){
			sumOfstuff = sumOfstuff + i;
		}
		sumsquare = sumOfstuff * sumOfstuff;
		int sum = 0;
		for(int j = 0; j<101; j++){
			sum = sum + j*j;
		}
		System.out.println(sumsquare - sum);
	}
}
