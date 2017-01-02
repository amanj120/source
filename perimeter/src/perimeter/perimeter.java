package perimeter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class perimeter {
	public static int ans = 0;
	public static ArrayList<Integer> xval = new ArrayList<Integer>();
	public static ArrayList<Integer> yval = new ArrayList<Integer>();
	public static ArrayList[] yOfHay;
	public static ArrayList[] xOfHay;
	public static int ymax;
	public static int ymin;
	public static int xmax;
	public static int xmin;
	public static int startx;
	public static int starty;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("perimeter.input"));
		int n = sc.nextInt();
		int[][] points = new int[n][2];
		for(int i = 0; i < n; i++){
			points[i][0] = sc.nextInt() + 1;
			points[i][1] = sc.nextInt() + 1;
		}
		java.util.Arrays.sort(points, new java.util.Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return Integer.compare(a[0], b[0]);
		    }
		});
		xmin = points[0][0];
		xmax = points[points.length - 1][0];
		xOfHay = new ArrayList[(xmax - xmin) + 1];
		for(int i = 0; i < xOfHay.length; i++){
			xOfHay[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < points.length; i++){
			xOfHay[points[i][0] - xmin].add(points[i][1]);
		}
		java.util.Arrays.sort(points, new java.util.Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return Integer.compare(a[1], b[1]);
		    }
		});
		ymin = points[0][1];
		ymax = points[points.length - 1][1];
		yOfHay = new ArrayList[(ymax - ymin) + 1];
		for(int i = 0; i < yOfHay.length; i++){
			yOfHay[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < points.length; i++){
			yOfHay[points[i][1] - ymin].add(points[i][0]);
		}
		startx = xmin;
		starty = 0;
		for(int i = 0; i < xOfHay[0].size(); i++){
			starty = Math.max(starty, (int) xOfHay[0].get(i));
		}
		startx -= 1; 
		starty += 1;
		dfs(startx, starty);
		sc.close();
	}
	public static void dfs(int x, int y){
		//down
		if(y >= ymin){
			if(!yOfHay[y - ymin - 1].contains(x)){
				if(yOfHay[y - ymin - 1].contains(x+1) || yOfHay[y-1 - ymin - 1].contains(x+1)){
					xval.add(x);
					yval.add(y-1);
					dfs(x, y-1);
				}
			}
		}
		//right
		if(x <= xmax + 1){
			if(!xOfHay[x+1 - xmin].contains(y)){
				if(xOfHay[x - xmin].contains(y+1) || xOfHay[x + 1 - xmin].contains(y+1)){
					xval.add(x+1);
					yval.add(y);
					dfs(x+1, y);
				}
			}
			
		}
		//up
		if(y <= ymax +1){
			if(!yOfHay[y + 1 - ymin].contains(x)){
				if(yOfHay[y - ymin].contains(x - 1) || yOfHay[y + 1 - ymin].contains(x-1)){
					xval.add(x);
					yval.add(y+1);
					dfs(x, y+1);
				}
			}
		}
		//left
		if(x >= xmin - 1){
			if(!xOfHay[x - xmin - 1].contains(y)){
				if(xOfHay[x - xmin].contains(y-1) || xOfHay[x-1 - xmin].contains(y-1)){
					yval.add(y);
					xval.add(x-1);
					dfs(x - 1, y);
				}
			}
		}
	}
}
