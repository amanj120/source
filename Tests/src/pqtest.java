//package priority_queue_test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class pqtest {
	static class point {

        int weight;
        int node;

        point(int weight, int node) {
            this.weight = weight;
            this.node = node;
        }
    }
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int[] a = {1,4,2,5,6,7,3,8,9,3,0,2,5,4,7};
		for(int i = 0; i < a.length; i++){
			pq.add(a[i]);
		}
		
		//PQsort pqs = new PQsort();
		//PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(10, pqs);
		// In this particular case, we can simply use Collections.reverseOrder()
		// instead of self-defined comparator
		//for (int x ) {
		//	pq2.offer(x);
		//}
 
	}

}