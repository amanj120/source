
public class fib {
	public static void main(String[] args) {
		int n = 100;
		long[] val = new long[n+1];
		val[1]= 1;
		val[2] = 1;
		for(int i = 3; i <=n; i++){
			val[i] = val[i-1] + val[i-2];
		}
		System.out.println(val[n]);
	}
}

