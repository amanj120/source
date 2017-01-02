/*
ID: amanj121
LANG: JAVA
TASK: namenum
*/
import java.util.*;
import java.io.*;
public class namenum {
	public static ArrayList<Integer> targ = new ArrayList<Integer>();
	public static 	ArrayList<String> names = new ArrayList<String>();
	public static ArrayList<String> anss = new ArrayList<String>();
	public static char[][] keys = {{'A','B','C'},{'D','E','F'},{'G','H','I'},{'J','K','L'},{'M','N','O'},{'P','R','S'},{'T','U','V'},{'W','X','Y'}};
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("namenum.in"));
		Scanner dict = new Scanner(new FileReader("dict.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		while(dict.hasNext()){
			names.add(dict.next());
		}
		int target = 4734;
		int start = 0;
		for(int i = 1; i < target; i = i *10){
			start = i;
		}
		int j = 0;
		while(start >= 1){
			targ.add(target/start);
			target = target % start;
			start = start / 10;
			j++;
		}
		findWord(0, "");
		if(anss.size() > 0){
		for(int i = 0; i < anss.size(); i++){
			out.println(anss.get(i));
		}
		}
		else{
			out.println("NONE");
		}
		sc.close();
		out.close();
	}
	public static void findWord (int index, String ans){
		if(index == targ.size())
			if(names.contains(ans))
				anss.add(ans);
		for(int i = 0; i < 3; i++){
			String l = ans + (char)keys[targ.get(index) - 2][i];
			findWord(index +1 , l);
			l = l.substring(0, l.length() - 1);
		}
	}
	
}
