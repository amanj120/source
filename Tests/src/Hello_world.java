
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;
public class Hello_world {

	public static void main(String[] args) {
		ArrayList test = new ArrayList();
		test.add("hello");
		test.add("its me");
		test.add("if after all");
		test.add(2,"i was wondering");
		test.add(4);
		
		test.remove(1);
		
		for(int i = 0; i<test.size(); i++){
			System.out.println(test.get(i));
		}
		
		
	}

}
