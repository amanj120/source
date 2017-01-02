package rocks;

import java.io.*;
import java.util.*;

public class rocks {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("rocks.input"));
		int N = sc.nextInt();
		for(int l=0;l<1<<N;l++){
			String K="";
			for(int r=1;r<N+1;r++){
				if(l<=(1<<(r-1))-1){K+='O';	continue;}
				if((((l-(r))/(1<<(r))))%2==0)K+='X';
				if((((l-(r))/(1<<(r))))%2==1)K+='O';
			}
			System.out.println(K);
		}
		for(int i = 0; i < N; i++)System.out.print('O');
	}
}