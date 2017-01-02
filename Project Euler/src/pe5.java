

public class pe5 {

	public static void main(String[] args) {
		boolean flag = true;
		for(int i = 20; i< 1000000000; i++){
			flag = true;
			for(int j = 2; j <21; j++){
				if(i%j !=0){
					flag = false;
					break;
				}
			}
			if (flag){
				System.out.println(i);
				break;
			}
		}

	}

}
