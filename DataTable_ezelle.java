import java.util.*;
public class DataTable_ezelle<String,TreeMap> extends HashMap{

	public HashMap<String,TreeMap> table = new HashMap<String,TreeMap>();

	

}





class Node{
	User user;
	Node previous;
	Node left;
	Node right;


	public Node(User user){
		this.user=user;
		previous = null;
	}

}

/*class BinarySearchTree{

	private Node root;
	

	public BinarySearchTree(Node a){
		root = a;
	
		
	}

	public BinarySearchTree(){
	}

	public void put(int key, User user){
		root = put(root, key, user);
	}

	public Node put(Node a, int key, User user){
		if (a==null){
			Node temp = new Node(user);
			return temp;
		}
		if (key > a.key){
			a.right = put(a.right, key, user);
		} else if (key < a.key){
			a.left = put(a.left, key, user);
		} 
		a.user = user;
		return a;
		
	}

	

	public User get(int key){
		return get(root, key);
	}

	public User get(Node a, int key){
		if (a==null){
			return null;
		}
		
		if (key < a.key) {
			return get(a.left, key);
		} else if (key > a.key){
			return get(a.right, key);
		} else {
			return a.user;
		}
	} 

	

	


}

*/
/*class HashTable{
	
	BinarySearchTree [] table;

	public static HashTable(){
		BinarySearchTree [] table = new BinarySearchTree [3]; // should create 1 binary tree for each hash in the table. Make the endcoding function length of Value (username) mod 3.
	}

	public boolean contains(String user){ // search the bst for the value
		int k = user.getName().length();
		int hash = k%3;
		char c = user.getName().charAt(0);
		int key= Character.getNumericValue(c);
		if (table[hash].get(key) == null){
			return false;
		}
		return true; 
	}
	public void put(Node a){
		int k = a.user.getName().length();
		int hash = k%3;
		table[hash].put(a.key, a.user);
	}  // Hash each node by inserting it in one of 3 BSTs. Use String.compareTo() to assign it a position

	public User get(String name){
		char c = name.charAt(0);
		int key= Character.getNumericValue(c);
		int hash = name.length()%3;
		return table[hash].get(key);

	}
	
}
*/