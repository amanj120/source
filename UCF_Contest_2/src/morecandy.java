import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;



public class morecandy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i = 0; i < n; i++){
			int l = sc.nextInt();
			pq.add(l);
		}
		long ans = 0;
		for(int i = 0; i < k; i++){
			int j = pq.poll();
			ans+= j/2;
			j = j - j/2;
			pq.add(j);
		}
		System.out.println(ans);
		sc.close();
		
	}

}
