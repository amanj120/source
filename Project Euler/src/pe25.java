

import java.math.BigInteger;

public class pe25 {
	public static void main (String [] args){
	BigInteger one = BigInteger.valueOf(1);
	BigInteger two = BigInteger.valueOf(1);
	for(int i = 0; i < 1000000000; i++){
		two = two.add(one);
		one = two.subtract(one);
		if(two.toString().length()>1000){
			System.out.println(i - 2);
			break;
		}
	}
}
}