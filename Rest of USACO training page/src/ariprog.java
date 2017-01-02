/*
ID: amanj121
LANG: JAVA
TASK: ariprog
*/
import java.util.*;
import java.io.*;

public class ariprog {
	
	public static int n;
	public static HashSet<Integer> bisquares;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader ("ariprog.in"));
		n = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		ArrayList<Integer> starts = new ArrayList<Integer>();
		bisquares = new HashSet<Integer>();
		ArrayList<int[]> a = new ArrayList<int[]>();
		for(int i = 0; i <= m; i++){
			for(int j = i; j <=m; j++){
				boolean startAdd = bisquares.add(i*i + j*j);
				if(startAdd != false){
					starts.add(i*i+j*j);
				}
			}
		}
		for(int j = 0; j < starts.size(); j++){
			int start = starts.get(j);
			for(int inc = 1; inc <=((((m*m*2)-start)/(n-1))+1); inc++){		
				if(exists(start,inc)){
					int[] ad = {start,inc};
					a.add(ad);
				}
			}
		}
		Collections.sort(a, new Comparator<int[]>() {
		    @Override
		    public int compare(int[] a, int[] b) {
		        return (a[1] - b[1] != 0? a[1]-b[1] : a[0]-b[0]);
		    }
		});
		
		PrintWriter  out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
		if(a.size() == 0)
			out.println("NONE");
		else
			for(int i = 0; i < a.size(); i++)
				out.println(a.get(i)[0] + " " + a.get(i)[1]);
		out.close();                                  
		System.exit(0);
	}
	public static boolean exists(int start, int inc){
		for(int i = start; i < start +(inc * n); i+= inc){
			Integer x = new Integer(i);
			if(!(bisquares.contains(x))) return false;
		}
		return true;
	}
}


