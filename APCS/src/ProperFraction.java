//Aman Jain
//ProperFraction.java
//makes a fraction into a proper fraction
public class ProperFraction extends Fraction {
	
	public ProperFraction(int n, int d){
		super(n,d); // constructs a fraction and simplifies it
	}
	
	public int getWhole(){ // if fraction < 1 whole = 0, else its num/denom (integer division truncates)
		return(Math.abs(getNumerator()) < getDenominator() ? 0 : getNumerator()/getDenominator());
	}
	
	public int getRemainder(){
		if(getWhole() == 0) // If the fraction is < 1 it just return numerator
			return getNumerator();
		else if(getNumerator() % getDenominator() == 0) // If the fraction is a whole number 
			return 0;
		else //returns remainder
			return Math.abs(getNumerator()) % getDenominator();
	}
	
	public void print(){
		System.out.println(toString());
	}
	
	public String toString(){
		if(getWhole() == 0 && getRemainder() != 0) // in the case of a fraction thats 0 a/b
			return getNumerator() + "/" + getDenominator(); 
		if(getWhole() == 0 && getRemainder() == 0) // in the case that its 0 0/b
			return "" + 0;
		if(getWhole() != 0 && getRemainder() == 0)// in the case thats its a 0/b
			return "" + getWhole();
		else //in the case that its a b/c 
			return getWhole() + " " + getRemainder() + "/" + getDenominator();
	}

}