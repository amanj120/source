package project_euler_9;

public class pe9 {

	public static void main(String[] args) {
		for(int a = 0; a<500; a++){
			for(int b = a+1; b< 998-a; b++){
				int c = 1000 - (a+b);
				if(((a*a) + (b*b)) == (c*c)){
					System.out.println(a*b*c);
				}
			}
		}
	}

}
