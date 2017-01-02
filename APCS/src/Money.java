//Money.java
//Aman Jain
//This simple class consists of only 2 instance variables, containing dollars and cents values.
//It is both incomplete and incorrect.
//Your task:  Complete, fix it, and thoroughly test it.
import java.util.*;

public class Money             
{
	// private instance variables
	private int myDollars;
	private int myCents;
	
	// default constructor method -- no parameters
	public Money(){
		myDollars = 0;
		myCents = 0;
	}
	// constructor method to input dollars and cents
	
	public Money(int newDollars, int newCents){
		myDollars = newDollars;
		myCents = newCents;
		this.normalize();
	}

	//Accessor methods -- return the private variable values
	
	public int getDollars(){
		return myDollars;
	}
	public int getCents(){
		return myCents;
	}
	
	//  One Money parameter add method
	//  This method combines the totals in this and the parameter amount
	//Money sum = maggie.add(sishir);
	
	public Money add(Money amount)
	{
		Money result = new Money();
		
		result.myCents = this.myCents + amount.myCents;
		result.myDollars = this.myDollars + amount.myDollars;
		
		result.normalize();
		return result;
	}
	public Money add(int d, int c){
		int dollars = this.myDollars + d;
		int cents = this.myCents + c;
		Money ret = new Money(dollars, cents);
		ret.normalize();
		return ret;
	}
	// 	Two int parameter add method  -- YOU WILL ADD THIS AND MUCH MORE!!!
	//  This method gets passed dollars and cents instead of a Money object
	public Money subtract(Money a){
		int dollars = this.myDollars - a.myDollars;
		int cents = this.myCents - a.myCents;
		Money ret = new Money(dollars, cents);
		ret.normalize();
		return ret;
	}
	public Money subtract(int d, int c){
		int dollars = this.myDollars - d;
		int cents = this.myCents - c;
		Money ret = new Money(dollars, cents);
		ret.normalize();
		return ret;
	}
	public Money multiply(int x){
		int dollars = this.myDollars * x;
		int cents = this.myCents * x;
		Money ret = new Money(dollars, cents);
		ret.normalize();
		return ret;
	}
	//This method should fix the problem of myCents > 99 or myCents < 0
	//Think carefully about which methods should call normalize()
	//COMPLETING THIS METHOD IS THE MAIN PART OF THIS ASSIGNMENT
	public void normalize(){
		if(myCents < 0){ // Subtracts cents from the dollars if cents are negative
			while(myCents < 0){
				myCents += 100;
				myDollars--;
			}
		}
		if(this.myCents > 99){ // adds dollars if cents > 99, and removes 100 each time it adds a dollar
			myDollars += (myCents / 100);
			myCents = (myCents % 100);
		}
		if(myDollars < 0){ // makes money 0.00 if less than 0 dollars, because of above if statements, myCents 
		                   // guaranteed to be positive
			myDollars = 0;
			myCents = 0;
		}
		//System.out.println("Inside the Normalize method");  // this display is only for testing purposes	
	}

	//This method (incorrectly) displays the values attractively to the screen 
	//THIS METHOD REQUIRES ONLY A SMALL MODIFICATION TO WORK PROPERLY
	public void print(){
		System.out.println(this.toString());
	}

	// This method (incorrectly) overwrites the automatic toString() method	
	// THIS METHOD REQUIRES ONLY A SMALL MODIFICATION TO WORK PROPERLY
	public String toString(){
		String s;
		normalize();
		if(this.myCents < 10)
			s = ("$" + myDollars + ".0" + myCents);
		else
			s = ("$" + myDollars + "." + myCents);
		return s;
	}
	public static void SortMoney(){
		MyComparator comparator = new MyComparator();
		PriorityQueue<Money> bonus = new PriorityQueue<Money>(1, comparator);
		int next = 0;
		Scanner sc = new Scanner(System.in);
		while(next != -1){
			int d = 0;
			int c = 0;
			System.out.println("Enter the dollar value: ");
			d = sc.nextInt();
			System.out.println("Enter the cent value(or -1 to stop): ");
			c = sc.nextInt();
			Money input = new Money(d,c);
			bonus.add(input);
			if(c == -1){
				next = -1;
			}	
		}
		while(bonus.size() > 0){
			bonus.poll().print();
		}
	}

}

class MyComparator implements Comparator<Money> {

    public int compare(Money t, Money x){
		Money zero = new Money();
		int ret;
		if(t.getCents() == x.getCents() && t.getDollars() == x.getDollars()){
			ret = 0;
		}
		else if(t.subtract(x).equals(zero)){
			ret = 1;
		}
		else{
			ret = -1;
		}
		return ret;
	}
}




