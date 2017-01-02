/*
ID: amanj121
LANG: JAVA
TASK: frac1
*/
import java.io.*;
import java.util.*;

public class frac1 {
	static class frc{
		int num;
		int den;
		public frc(int n, int d){
			num = n;
			den = d;
			for(int i = den; i >=1; i--)
				if(num%i == 0 && den%i == 0){
					num/= i;
					den/=i;
					break;
				}
		}
		public String toString(){
			return num + "/" + den;
		}
		public boolean equals(frc a){
			return (a.num*den == a.den*num);
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("frac1.in"));
		int n = sc.nextInt();
		sc.close();
		ArrayList<frc> ans = new ArrayList<frc>();
		for(int i = 1; i <=n ;i++)
			for(int j = 1; j < i; j++)
				ans.add(new frc(j,i));
		ans.add(new frc(1,1));
		ans.add(new frc(0,1));
		Collections.sort(ans, new Comparator<frc>() {
		    @Override
		    public int compare(frc a, frc b) {
		    	return(a.num*b.den - b.num*a.den);
		    }
		});
		for(int i = ans.size()-1; i >0; i--)
			if(ans.get(i).equals(ans.get(i-1)))
				ans.remove(i-1);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
		for(frc a: ans)
			out.println(a);
		out.close();
		System.exit(0);
	}
}