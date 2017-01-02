package sboost;

import java.util.*;
import java.io.*;
public class sboost {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("sboost.input"));
		double f = sc.nextInt();
		double m = sc.nextInt();
		double[][] p = new double[sc.nextInt()][4];
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i = 0; i< p.length; i++){
			p[i][0] = sc.nextInt();
			p[i][1] = sc.nextInt();
			p[i][2] = p[i][0]/p[i][1];
			p[i][3] = i;
		}
		java.util.Arrays.sort(p, new java.util.Comparator<double[]>() {
		    public int compare(double[] a, double[] b) {
		        return Double.compare(a[2], b[2]);
		    }
		});
		for(int i = p.length-1; i >= 0 ; i--){
			if(((f + p[i][0])/(m + p[i][1]))>= (f/m)){
				f+= p[i][0];	m+= p[i][1];	ans.add((int)(p[i][3]) + 1);
			}
		}
		Collections.sort(ans);
		if(ans.size() == 0)System.out.println("NONE");
		for(int i = 0; i < ans.size(); i++){
			System.out.println(ans.get(i));
		}
	}
}