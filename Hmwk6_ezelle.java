// Eli Zelle 
// 12/4/16


import java.util.*;
//import org.jgrapht.*;

public class Hmwk6_ezelle{



	static HashMap<String, TreeMap>  table = new HashMap<String, TreeMap>();
	static StringComparator comparator = new StringComparator();	
	public static void main(String[] args){
		
		int choiceentry = -1;
		Scanner scanchoice = new Scanner(System.in);


		do {
			System.out.println("Welcome to MyFriendsSpace!!! \nSelect from the following menu:\n1. Add/update user\n2. Search user\n3. Add friend for user\n4. Remove friend for user\n5. Find shortest path between 2 users\n0. Exit MyFriendsSpace\" ");
	 		choiceentry = scanchoice.nextInt();
 			switch (choiceentry)
	 		{
	 			
				case 1:
 					// operation1
					// Adds a user to the BST
					System.out.println("Input a new user's name: ");
					Scanner username = new Scanner(System.in);
					String user = username.next();
					User a = new User(user);
					addUser(a);
 					break;
 				case 2:
		 			// operation2
 					// Finds a user in the BST and returns it's location
 					// If it doens't find it, returns null
 					//Scanner username = new Scanner(System.in);
 					String un = "";
 					System.out.println("Input a user's name: ");
 					Scanner username1 = new Scanner(System.in);
					un = username1.next();
					User b = new User(un);
					try{
	 					searchUser(b);
	 				}
	 				catch(NullPointerException ex){
	 					System.out.println("User does not exist");
	 				}
 					break;
 				case 3:
		 			// operation3
 					// Updates the connections between the two users to include eachother as friends
 					//Scanner username = new Scanner(System.in);
 					System.out.println("Input a user's name: ");
 					Scanner username2 = new Scanner(System.in);
 					System.out.println("Input a user's name: ");
 					Scanner username3 = new Scanner(System.in);
					User user1 = new User(username2.next());
					User user2 = new User(username3.next());
					try{
	 					addFriend(user1, user2);
	 				}
	 				catch(NullPointerException ex){
	 					System.out.println("Opperation Impossible");
	 				}
 					
	 				break;
 				case 4:
			 		// operation4
 					// Updates the conncetions between the two users to remove eachother from their friends lists
 					//Scanner username = new Scanner(System.in);
 					System.out.println("Input a user's name: ");
 					Scanner username4 = new Scanner(System.in);
 					System.out.println("Input a user's name: ");
 					Scanner username5 = new Scanner(System.in);
					user1 = new User(username4.next());
					user2 = new User(username5.next());
 					removeFriend(user1, user2);
 					break;
		 		case 5:
			 		// operation5
			 		// Choicealculates the degrees of sepereation between two users
		 			// Uses a breath first search algorithm
		 			//Scanner username = new Scanner(System.in);
		 			System.out.println("Input a user's name: ");
		 			Scanner username6 = new Scanner(System.in);
		 			System.out.println("Input a user's name: ");
		 			Scanner username7 = new Scanner(System.in);
					user1 = new User(username6.next());
					
					user2 = new User(username7.next());

					/*Collection<String> users;

					for (String s : table.keySet()){
						users.add(s);
					}

					//SimpleGraph<User> graph = new SimpleGraph<User>();
					

					HashMap<String, Integer> userstoints = new HashMap<String, Integer>();
					Iterator<String> iterator = users.iterator();
					int s = 1;
					
					while(iterator.hasNext() == true){
						Integer r = new Integer(s);
						String temp = iterator.next();
						iterator.remove();
						userstoints.put(temp, r);
						s++;
					} 
*/
					/*for (String s: table.keySet()){
						graph.addVertex(s);
						for (String r : table.get(s.getName()).get(keySet())){
							graph.addEdge(s,r);
						}
					}
					DijkistraShortestPath path = new DijkistraShortestPath(graph);
					getShortestPath(graph,user1,user2);
					List list = path.getPathEdgeList();


					//BreadthFistPaths bfp = new BreadthFistPaths(graph, 1);


			 		//ArrayDeque<User> list = userlist.clone();
	 				//ArrayDeque<User> userlist = degreesOfSeperation(user1, user2);
	 				
	 				*/
	 				System.out.println(degreesOfSeperation(user1,user2));


					



	 				
 					break;
		 		default:
	 				System.out.println("Choice must be a value between 0 and 5.");
 			}	
		} while (choiceentry != 0);
		System.out.println("Bye, bye!");
	}
	
	

	public static void addFriend(User a, User b){
		if (table.get(a.getName()).containsValue(b) == true){ // need to write this method
			return;
		}
		table.get(a.getName()).put(b.getName(),b);
		table.get(b.getName()).put(a.getName(),a);
		addFriend(a,b);

		
	}

	public static void removeFriend(User a, User b){
		if (table.get(a.getName()).containsKey(b.getName()) == false){
			System.out.println("Users are not friends");
			return;
		}
		System.out.println();
		System.out.println("These two users are no longer friends");
		table.get(a.getName()).remove(b.getName());
		table.get(b.getName()).remove(a.getName());
		removeFriend(a,b);
		
	}

	public static void addUser(User a){
		boolean flag = table.containsKey(a.getName());
		if (flag == false){
			String key = a.getName();
			TreeMap<String, User> tree = new TreeMap<String, User>(comparator);
			tree.put(a.getName(),a); // ---------------------------------Needs to compare strings alphebetically 
			table.put(a.getName(),tree);
			tree.remove(a.getName());
			//graph.add(a);
			
		} else{
			System.out.println("User already exists");
			/*System.out.println ("Would you like to change their name?  y/n");
			Scanner yn1 = new Scanner(System.in);
			String yn = yn1.next();
			if (yn.equals('y') || yn.equals('Y') == true){
				System.out.println("Please type the User's new name");
				Scanner newname45 = new Scanner(System.in);
				User newname = new User(newname45.next());
				a = newname;
			} else {
				return;
			}
		*/}
	}	

	public static void searchUser(User a){
		boolean flag = table.containsKey(a.getName());
		
		if (flag == true){
			
			System.out.println(a.getName());
			System.out.println("Friends: ");
			Set set = table.get(a.getName()).keySet();
			System.out.println(set);
			// Print out the name and the list of friends
		} else {
			System.out.println("User doesn't exist");
		}
	}

	public static String degreesOfSeperation(User a, User b){
		// Breadth first implementation 
		// Look at user's friends. If the friends include b, we are done.
		// If not, enque all friends and see if they include b.
		ArrayDeque<Node> queue = new ArrayDeque<Node>();
		
		ArrayDeque<Node> nodes = new ArrayDeque<Node>();
		ArrayDeque<String> nodes2 = new ArrayDeque<String>();
		
		Node head  = new Node(a);
		Node tail = new Node(b);
		TreeMap map = table.get(a.getName());
		TreeMap map2 = map;
		
		Set set  = map.keySet();
		
		Iterator<String> iterator = set.iterator();
		
		while (iterator.hasNext()==true){
			
			String string = iterator.next();
			
			User p = new User(string);
			Node l = new Node(p);
			l.previous = head;
			
			
			
			nodes.add(l);
		}
		
		


		/*String firstkey = map.firstKey();
		User p = new User(firstkey);
		Node l = new Node(p);
		nodes.add(l);
		while(map.floorKey(firstkey)!=null){
			System.out.println("Flag!!@$");
			String o = map.floorKey(firstkey);
			p = new User(o);
			l = new Node(p);
			nodes.add(l);
			firstkey = map.floorKey(firstkey);
		}
		/*System.out.println("Flag");
		while(f.isEmpty()==false){
			User c = f.remove();
			Node temp = new Node(c);
			temp.previous = head;
			nodes.add(temp);
			System.out.println("adding node");
		}
		*/

		
		nodes2.remove(tail);


		int links = 2147483647;

		

		while (nodes.isEmpty() == false){
			
			Node current = nodes.remove();
			
			
			
			if (current.user.getName().equals(tail.user.getName())==true){
				
				int i = 0;
				Node temp2 = current;
				while(temp2.previous!=null){
					i++;
					temp2 = temp2.previous;
					
				}
				if (i < links){
						links = i;
						temp2 = current;
						while(temp2.previous!=null){
							queue.push(temp2);
							temp2 = temp2.previous;
						}
				}
			} 
			User temp  = current.user;
			String q = temp.getName();
			TreeMap tm = table.get(q);
			Set st  = tm.keySet();
		
			Iterator<String> iterator2 = st.iterator();

			while (iterator2.hasNext()==true){
				String j = iterator2.next();
			
				User jj = new User(j);
				Node jjj = new Node(jj);

			
				if (nodes2.contains(jjj.user.getName())==false){
					
					jjj.previous = current;
					nodes.add(jjj);
					nodes2.add(jjj.user.getName());
				
				}
			}





			//if(temp.frineds.contains(b)){
			//	Node head = new Node(b);
			//	head.previous = current;
			//}
		

			

		}
		
		




		String path = a.getName();
		
		while (queue.isEmpty() == false){
			Node t = queue.pop();
			String s = t.user.getName();
			path = path + ", " + s;
		}


		
		
		return path;
		




