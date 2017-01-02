import java.util.*;
public class sunwalk {
	public static class tree{
		double x;
		double y;
		double r;
		public tree(double a, double b, double c){
			x = a;
			y = b;
			r = c;
		}
	}
	public static double sdist(tree a, tree b){
		double radii = a.r + b.r;
		double dist = distance(a.x, a.y, b.x, b.y);
		if(dist-radii < 0){
			return 0;
		}
		else{
			return (dist - radii);	
		}
	}
	public static double distance(double x1, double y1, double x2, double y2){
		return Math.hypot((x2 - x1), (y2 - y1));
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		tree[] shades = new tree[n];
		double[][] adj = new double[n][n];
		for(int i = 0; i < n; i++){
			Arrays.fill(adj[i], 500000000);
			adj[i][i] = 0;
			shades[i] = new tree(sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
		}
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				if(j != i){
					for(int k = 0; k < n; k++)
						if((i!= k) && adj[i][j] + adj[j][k] > sdist(shades[i], shades[k]))
								adj[i][k] = sdist(shades[i], shades[k]);
				}
		int q = sc.nextInt();
		for(int h = 0; h < q; h++){
			double startx = sc.nextDouble();
			double starty = sc.nextDouble();
			double endx = sc.nextDouble();
			double endy = sc.nextDouble();
			double min = distance(startx, starty, endx, endy);
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					double a = distance(startx, starty, shades[i].x, shades[i].y);
					double b = distance(endx,endy, shades[j].x, shades[j].y);
					double c = shades[i].r + shades[j].r;
					if(((a+b)-c) + adj[i][j] < 0){
						min = 0;
					}
					else{
						min = Math.min(min, adj[i][j] + ((a+b)-c));
					}
				}
			}
			System.out.printf("%.1f%n", min);
		}
		sc.close();
	}
}