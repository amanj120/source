/*
ID: amanj121
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

public class gift1 {

	public static void main(String[] args) throws IOException {
		 // Use BufferedReader rather than RandomAccessFile; it's much faster
	    Scanner sc = new Scanner(new FileReader("gift1.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
	    int i1 = sc.nextInt();
	    String[] names = new String[i1];
	    for(int i = 0; i < names.length; i++){
	    	names[i] = sc.next();
	    }
	    int[] money = new int[i1];
	    while(sc.hasNext()){
	    	String a = sc.next();
	    	if( a .length() == 0){
	    		break;
	    	}
	    	int gifts = sc.nextInt();
	    	int people = sc.nextInt();
	    	int giverIndex = 0;
	    	for(int i = 0; i < i1; i++){
	    		if(a.equals(names[i])){
	    			giverIndex = i;
	    			break;
	    		}
	    	}
	    	for(int i = 0; i < people; i++){
	    		String nextPerson = sc.next();
	    		for(int j = 0; j < names.length; j++){
		    		if(nextPerson.equals(names[j])){
		    			money[j] += gifts/people;
		    			money[giverIndex] -= gifts/people;
		    			break;
		    		}
		    	}
	    	}
	    	
	    }
	    for(int j = 0; j < names.length; j++){
	    	out.println(names[j] + " " + money[j]);
	    }
	    out.close();
	}
}
