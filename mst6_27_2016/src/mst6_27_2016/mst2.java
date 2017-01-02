package mst6_27_2016;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

class node implements Comparable {
    int key;
    int i;
    public node(int k, int a) {
        key = k;
        i = a;
    }
    @Override
    public int compareTo(Object t) {
        node e = (node)t;
        return this.key - e.key;
    }
}

public class mst2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new FileReader("mst2.input"));
        PriorityQueue<node> pq = new PriorityQueue<node>();

        int v = input.nextInt();
        int e = input.nextInt();

//        node[][] g = new node[v + 1][v + 1];
        ArrayList[] g = new ArrayList[v + 1];

//        for (int i = 0; i < g.length; i++) {
//            for (int j = 0; j < g[0].length; j++) {
//                g[i][j] = new node(1<<30,j);
//            }
//        }

        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<node>();
        }

        for (int i = 0; i < e; i++) {
            int A = input.nextInt();
            int B = input.nextInt();
            int C = input.nextInt();
            g[A].add(new node(C, B));
            g[B].add(new node(C, A));
        }

        boolean[] mark = new boolean[v + 1];
        pq.add(new node(0, 1));

        int[] w = new int[v + 1];

        for (int i = 0; i < w.length; i++) {
            w[i] = 10001;
        }
        while (!pq.isEmpty()) {
            int x = pq.poll().i;
            if (mark[x])continue;
            mark[x] = true;
            for (int i = 0; i < g[x].size(); i++) {
                int a = ((node)g[x].get(i)).i;
                int b = ((node)g[x].get(i)).key;
                if (!mark[a] && w[a] > b) {
                    w[a] = b;
                    pq.add(((node)g[x].get(i)));
                }
            }
        }

        int total = 0;
        for (int i = 2; i < w.length; i++) {
            total += w[i];
        }
        System.out.println(total);

    }
}