import java.util.*;
public class triangles {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double m = sc.nextDouble();
		
		double y = m * (b/(m+(b/a)));
		double Matt = (a * y)/2;
		double Travis = ((a * b)/2) - Matt;
		System.out.printf("%.3f ", Matt);
		System.out.printf("%.3f%n",Travis);
		sc.close();
	}

}
