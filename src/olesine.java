
import java.util.*; 
public class olesine {
	
	public static void main(String[] args) {
		
		PhoneNumber number1 = new PhoneNumber("work", "4568425554");
		PhoneNumber number2 = new PhoneNumber("cell", "145865");
		SLinkedList<Person> myLinkedList = new SLinkedList<Person>();
		myLinkedList.addLast(new Person("ugur", "kafal", "gltepe", number1));
		myLinkedList.addLast(new Person("hilmi", "araz", "konak", number2));
		
		Iterator itr = myLinkedList.iterator();
		
		while(itr.hasNext()) {
			
			Person he = (Person)itr.next();
			if(he.getName().equals("hilmi"))
				myLinkedList.remove(he);
		}
		
		myLinkedList.printList();
		
	}
}