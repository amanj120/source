import java.util.*;

public class cake {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		long w = sc.nextLong();
		long l = sc.nextLong();
		long a = sc.nextLong();
		long b = sc.nextLong();
		for(long c = 1; c < Long.MAX_VALUE; c++){
			double d = Math.floor(((a*w*l*c) - ((2*c*l*b) + (2*c*w*b)))/ (w*l*b));
			if((w*l*b*d) + (2*c*l*b) + (2*c*w*b) == (a*w*l*c)){
				System.out.println(c + " " + (int)d);
				System.exit(0);
			}
			d+= 1;
			if((w*l*b*d) + (2*c*l*b) + (2*c*w*b) == (a*w*l*c)){
				System.out.println(c + " " +(int) d);
				System.exit(0);
			}	
		}
		sc.close();
	}

}
