import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.TreeMap;

public class lorenzo {
	public static TreeMap <Integer, Long> roads = new TreeMap<Integer, Long>();
	public static int beginning;
	public static int ending;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int tasks = sc.nextInt();
		roads.put(1, (long) 0);
		for(int i = 0; i < tasks; i++){
			int type = sc.nextInt();
			if(type == 1){
				beginning = sc.nextInt();
				ending = sc.nextInt();
				long cost = sc.nextInt();
				fillTreeE(ending, beginning,  cost);
			}
			if(type == 2){
				int l = sc.nextInt();
				int j = sc.nextInt();
				beginning = Math.min(l, j);
				ending = Math.max(l, j);
				System.out.println(costPath(beginning, ending, 0));
			}
		}
		sc.close();
	}
	public static void fillTreeB(int n, long cost){
		if(n==1 || n == ending){
			return;
		}
		else{
			if(!roads.containsKey(n)){
				roads.put(n,(long) cost);
			}
			else{
				roads.put(n, (long) (roads.get(n) + cost));
			}
			fillTreeB(n/2, cost);
		}
	}
	public static void fillTreeE(int n, int begin, long cost){
		if(n == beginning){
			return;
		}
		if(n == 1){
			fillTreeB(begin, cost);
			return;
		}
		else{
			if(!roads.containsKey(n)){
				roads.put(n,(long) cost);
			}
			else{
				roads.put(n, (long) (roads.get(n) + cost));
			}
			fillTreeE(n/2,begin, cost);
		}
	}
	public static long costPath(int b, int e, long cost){
		if(b == e){
			return cost;
		}	
		if(!roads.containsKey(b)){
			roads.put(b, (long) 0);
		}
		if(!roads.containsKey(e)){
			roads.put(e, (long) 0);
		}
		if(e > b){
			cost+= roads.get(e);
			return costPath(b, e/2,cost);
		}
		if(e < b){
			if(e*2 == b){
				e = e*2;
				cost += roads.get(e);
				return costPath(b,e,cost);
			}
			if(e*2 + 1 == b){
				e = e*2 + 1;
				cost += roads.get(e);				
				return costPath(b,e,cost);
			}
			else{
				cost+= roads.get(e);
				return costPath(b, e/2,cost);
			}
		}
		
		return cost;
	}
}