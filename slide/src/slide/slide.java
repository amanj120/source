package slide;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class slide {
	public static int[][] edges;
	public static int nodes;
	public static int slides;
	public static int control;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner (new FileReader("slide.in"));
		nodes = sc.nextInt();
		slides = sc.nextInt();
		control = sc.nextInt();
		edges = new int[slides][3];
		for(int i = 0; i < edges.length; i++){
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}
		sc.close();
	}
//	public static int DFS(int cNode, int k){
//		if(cNode == nodes){
//			return 0;
//		}
//		
//		
//	}
}
