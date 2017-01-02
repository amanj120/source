public class Pet {
	
	public int weight;
	public int age;
	public int intelligence;
	public int speed;
	public String favoriteHobby;
	

	public Pet(int a, int b, int c, int d, String e){
		weight = a;
		age = b;
		intelligence = c;
		speed = d;
		favoriteHobby = e;
	}
	
	public Pet(){
		weight = 120;
		age = 16;
		intelligence = 1;
		speed = 2;
		favoriteHobby = "Figure Skating";
	}
	//pet eats and gains weight
	public void eat(int pounds){
		weight = weight + pounds;
		System.out.println("Your pet ate.  It now weighs " + weight + " pounds.");
	}
	//pet reads and gets smarter
	public void read(int hours){
		intelligence += hours;
		System.out.println("Your pet read. It now has " + intelligence + " intelligence");
	}
	//pet celebrates a birthday
	public void birthdays(){
		age ++;
		System.out.println("Your pet celebrated its birthday. It is now "+ age + " years old");
	}
	// pet runs and gets faster
	public void run(int miles){
		speed += miles;
		System.out.println("Your pet ran " + miles + " miles. It now has " + speed + " speed");
	}
	//pet tries an activity, and if it enjoys the activity, it becomes the new fav. activity
	public void tryActivity(String l, int n){
		if(n > 5){
			favoriteHobby = l;
			System.out.println("Your pet tried " + l + " and had lots of fun. Your pet's favorite hobby is " + favoriteHobby);
		}
		else{
			System.out.println("Your pet tried " + l + "and it hated it.");
		}
		
	}
	//pet drinks water and gains weight
	public int drinkWater(int flOz){	
		return (weight += flOz);
	}
	public void displayInfo(){
		System.out.println("Your pet weighs " + weight + " pounds.");
		System.out.println("Your pet is " + age + " years old.");
		System.out.println("Your pet has " + intelligence + " intelligence.");
		System.out.println("Your pet has " + speed + " speed.");
		System.out.println("Your pet's favorite hobby is " + favoriteHobby);
	}
	
}
