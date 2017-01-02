

import java.math.BigInteger;

public class pe20 {

	public static void main(String[] args) {
		BigInteger ans = BigInteger.valueOf(100);
		String val = "";
		int current = 0;
		long sum = 0;
		for(int i = 99; i>=1; i--){
			BigInteger hi = BigInteger.valueOf(i);
			ans = ans.multiply(hi);
		}
		val = ans.toString();
		for(int i = 0; i< val.length(); i++){
			current =  Character.getNumericValue(val.charAt(i));
			sum = sum + current;
		}
		System.out.println(sum);
	}

}