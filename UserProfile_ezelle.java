import java.util.*;

public class UserProfile_ezelle{
	public static void main(String[] args) {
		User a = new User("Eli");
		User b = new User("Sam");
		a.friends.add(b);
		a.addFriend(a,b);
	}
}

class User{
	private String name;
	public ArrayDeque<User> friends;
	

	User(String name){
		this.name = name;
		friends = new ArrayDeque<User>();
	}


	public String getName(){
		return name;
	}

	public void addFriend(User a, User b){
		
		b.friends.add(a);
		a.friends.add(b);
	}

	
	public void removeFriend(User a, User b){
		a.friends.remove(b);
		b.friends.remove(a);
		
	}

	public ArrayDeque<User> getFriends(){
		return friends;
	}

	

}
