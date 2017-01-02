import java.math.BigInteger;

public class pe16 {

	public static void main(String[] args) {
		BigInteger ans = BigInteger.valueOf(1);
		String val = "";
		int current = 0;
		long sum = 0;
		for(long i = 0; i<1000; i++){
			ans = ans.add(ans);
		}
		val = ans.toString();
		for(int i = 0; i< val.length(); i++){
			current =  Character.getNumericValue(val.charAt(i));
			sum = sum + current;
		}
		System.out.println(sum);
	}

}
