// MoneyRunner
// Aman Jain
// Testing the Money Class
import java.util.*;
public class MoneyRunner
{
	public static void main(String[] args)
	{
		Money x = new Money(0,9);
		Money y = new Money(6,6);
		x = x.add(y);
		x.print();
	}
}







