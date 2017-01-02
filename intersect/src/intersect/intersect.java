package intersect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class intersect {
	static class line{
		int v1x;
		int v1y;
		int v2x;
		int v2y;
		public line(int a, int b, int c, int d){
			v1x = a;
			v1y = b;
			v2x = c;
			v2y = d;
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("intersect.input"));
		line LineA = new line(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()); 
		line LineB = new line(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()); 
		
		sc.close();
	}
	public static boolean intersect(line a, line b){
		int d = a.v1x * b.v1x - a.v1y * b.v1y;
		int e = a.v1x * b.v2x - a.v1y * b.v2y;
		int f = b.
		if(((a.v1x * b.v1x - a.v1y * b.v1y) * (a.v1x * b.v2x - a.v1y * b.v2y)) < 0 
	}
}
