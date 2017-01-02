package project_euler_14;

public class pe14 {

	public static void main(String[] args) {
		int ans = 0;
		int actual = 0;
		for(int i = 1000000; i> 1; i--){
			int n = i;
			int counter = 0;
			while(n!= 1){
				if(n%2 == 0){
					n = n/2;
				}
				else{
					n = 3*n+1;
				}
				counter++;
			}
			System.out.println(counter + " " + i);
			
			
			if(counter>ans){
				ans = counter;
				actual = i;
				System.out.println("------" + ans + " " + actual);
			}
		}
		
		System.out.println("*********************" + ans + " " + actual);
	}

}
