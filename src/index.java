/**
 * Devoloper 	  : Muhammed Emin Çevikol
 * Faculty number : 120315013 
 */
import java.util.*; 
import java.io.*;
public class index {
	public static void main(String[] args) throws IOException {

	int exit = 0, choice;
	SLinkedList<Person> myLinkedList = new SLinkedList<Person>();
	
	File file = new File("PersonList.txt");
	BufferedReader reader = new BufferedReader(new FileReader(file));
	String line = reader.readLine();
	
	while(line != null) {
		
		PhoneNumber tempNumber = new PhoneNumber("work", "No Number");
		Person tempPerson = new Person(null, null, null, null);
		
		StringTokenizer st = new StringTokenizer(line, "/"); //st.nextElement()
		tempPerson.setName((String)st.nextToken());
		tempPerson.setSurname((String)st.nextToken());
		tempPerson.setAddress((String)st.nextToken());
		tempNumber.addWorkPhoneNumber((String)st.nextToken());
		tempNumber.addCellPhoneNumber((String)st.nextToken());
		tempNumber.addHomePhoneNumber((String)st.nextToken());
		tempPerson.number = tempNumber;
		
		myLinkedList.addLast(tempPerson);
		
		line = reader.readLine();
	}
	
		while (exit != 5){
			
			System.out.println("********************************************************");
			System.out.println("           	     WELCOME PROJECT II");
			System.out.println("********************************************************");
			
			System.out.println("1. Search a person");
			System.out.println("2. Search a phone number");
			System.out.println("3. Create new person");
			System.out.println("4. List All");
			System.out.println("5. Exit");
			Scanner scan =new Scanner(System.in);
			System.out.print("Make your choice :");
			choice = scan.nextInt();
		
			switch(choice){
				
				case 1:
				System.out.print("Please enter any text information to search in the people : ");
				String str = scan.next();
				int times = 0;
				
				Person[] arrayPersonResults;
				arrayPersonResults = new Person[9];
				
				Iterator itr = myLinkedList.iterator();
					while(itr.hasNext() && times !=9) {
						Person he = (Person)itr.next();
						if(he.getName().contains(str) || he.getSurname().contains(str) || he.getAddress().contains(str)) {
							arrayPersonResults[times] = he;
							System.out.println(arrayPersonResults[times]);
							times++; }
					}
					
				System.out.println("---------------------------------------------------------------------");
					
				if(times == 0)
					System.out.println("Sorry no results found!!!");
				else {
					System.out.println("INSTRUCTIONS = a = left, d = right, w = update, s = delete, e = insert, q = exit");
					times = 0;
					boolean loop = true;
					while (loop == true) {   // a = left, d = right, w = update, s = delete, q = insert, e = exit
						if(arrayPersonResults[times] != null)
							System.out.println((times+1) + "." + arrayPersonResults[times]);
						else if(arrayPersonResults[times] == null)
							System.out.println((times+1) + ". DELETED OR EMPTY!!!");
						char data = (char)System.in.read();
						char ch1 = (char)System.in.read(); // carriage return(/r)
						char ch2 = (char)System.in.read(); // line feed(/n)
						if (data == 'a') {
							if(times>0)
								times--;
							else if(times == 0)
								System.out.println("You are already on the first!!!");
						} else if (data == 'd') {
							if(times<8)
								times++;
							else
								System.out.println("You are already at the last!!!");
						} else if (data == 'w') {
							System.out.println("1.Name");
							System.out.println("2.Surname");
							System.out.println("3.Address");
							System.out.println("4.Home Number");
							System.out.println("5.Work Number");
							System.out.println("6.Cell Number");
							System.out.print("Choose one of them : ");
							
							int ChoiceInfo = scan.nextInt();
							String info;
							
							myLinkedList.remove(arrayPersonResults[times]);
							
							switch(ChoiceInfo) {
								case 1 :
								System.out.print("Enter a name : ");
								info = scan.next();
								arrayPersonResults[times].setName(info);
								break;
								case 2 :
								System.out.print("Enter a surname : ");
								info = scan.next();
								arrayPersonResults[times].setSurname(info);
								break;
								case 3 :
								System.out.print("Enter a address : ");
								info = scan.next();
								arrayPersonResults[times].setAddress(info);
								break;
								case 4 :
								System.out.print("Enter a number : ");
								info = scan.next();
								arrayPersonResults[times].number.addHomePhoneNumber(info);
								break;
								case 5:
								System.out.print("Enter a number : ");
								info = scan.next();
								arrayPersonResults[times].number.addWorkPhoneNumber(info);
								break;
								case 6 :
								System.out.print("Enter a number : ");
								info = scan.next();
								arrayPersonResults[times].number.addCellPhoneNumber(info);
								break;
							}
							
							myLinkedList.addLast(arrayPersonResults[times]);
						} else if (data == 's') {
							myLinkedList.remove(arrayPersonResults[times]);
							arrayPersonResults[times] = null;
						} else if(data == 'e') {
							System.out.print("Enter name : ");
							String name = scan.next();
							System.out.print("Enter surname : ");
							String surname = scan.next();
							System.out.print("Enter address : ");
							scan.nextLine();
							String address = scan.nextLine();
							
							System.out.print("Do you want to add a phone number?(YES/NO) : ");
							String choice2 = scan.next();
							
							PhoneNumber no = new PhoneNumber("work", null);
							
							while(choice2.equals("YES") || choice2.equals("yes")) {
								String number;
								
								System.out.println("Which type number you will enter?");
								System.out.println("    1.Home");
								System.out.println("    2.Work");
								System.out.print("    3.Cell : ");
								int t = scan.nextInt();
								
								System.out.print("    Enter number : ");
								switch(t){
									case 1: number = scan.next(); no.addHomePhoneNumber(number);break;
									case 2: number = scan.next(); no.addWorkPhoneNumber(number);break;
									case 3: number = scan.next(); no.addCellPhoneNumber(number);break;
									default: System.out.println("Please enter 1-3 number!!!"); break;
								}
								System.out.print("Do you still want to add another phone number?(YES/NO) : ");
								choice2 = scan.next();
							}
							myLinkedList.addLast(new Person(name, surname, address, no));
						} else if (data == 'q') {
							System.out.println("Exit");
							loop = false;
						}
					}
				}
				
				break;
				case 2:
				System.out.print("Please enter any number : ");
				str = scan.next();
				times = 0;
				
				arrayPersonResults = new Person[9];
				
				itr = myLinkedList.iterator();
					while(itr.hasNext() && times !=9) {
						Person he = (Person)itr.next();
						if(he.number.getPhoneNumber("work") != null || he.number.getPhoneNumber("cell") != null || he.number.getPhoneNumber("home") != null ||
						he.number.getPhoneNumber("work").equals(str) || he.number.getPhoneNumber("cell").equals(str) || he.number.getPhoneNumber("home").equals(str)) {
							arrayPersonResults[times] = he;
							System.out.println(arrayPersonResults[times]);
							times++; }
					}
					
				System.out.println("---------------------------------------------------------------------");
					
				if(times == 0)
					System.out.println("Sorry no results found!!!");
				else {
					System.out.println("INSTRUCTIONS = a = left, d = right, w = update, s = delete, e = insert, q = exit");
					times = 0;
					boolean loop = true;
					while (loop == true) {   // a = left, d = right, w = update, s = delete, q = insert, e = exit
						if(arrayPersonResults[times] != null)
							System.out.println((times+1) + "." + arrayPersonResults[times]);
						else if(arrayPersonResults[times] == null)
							System.out.println((times+1) + ". DELETED OR EMPTY!!!");
						char data = (char)System.in.read();
						char ch1 = (char)System.in.read(); // carriage return(/r)
						char ch2 = (char)System.in.read(); // line feed(/n)
						if (data == 'a') {
							if(times>0)
								times--;
							else if(times == 0)
								System.out.println("You are already on the first!!!");
						} else if (data == 'd') {
							if(times<8)
								times++;
							else
								System.out.println("You are already at the last!!!");
						} else if (data == 'w') {
							System.out.println("1.Name");
							System.out.println("2.Surname");
							System.out.println("3.Address");
							System.out.println("4.Home Number");
							System.out.println("5.Work Number");
							System.out.println("6.Cell Number");
							System.out.print("Choose one of them : ");
							
							int ChoiceInfo = scan.nextInt();
							String info;
							
							myLinkedList.remove(arrayPersonResults[times]);
							
							switch(ChoiceInfo) {
								case 1 :
								System.out.print("Enter a name : ");
								info = scan.next();
								arrayPersonResults[times].setName(info);
								break;
								case 2 :
								System.out.print("Enter a surname : ");
								info = scan.next();
								arrayPersonResults[times].setSurname(info);
								break;
								case 3 :
								System.out.print("Enter a address : ");
								info = scan.next();
								arrayPersonResults[times].setAddress(info);
								break;
								case 4 :
								System.out.print("Enter a number : ");
								info = scan.next();
								arrayPersonResults[times].number.addHomePhoneNumber(info);
								break;
								case 5:
								System.out.print("Enter a number : ");
								info = scan.next();
								arrayPersonResults[times].number.addWorkPhoneNumber(info);
								break;
								case 6 :
								System.out.print("Enter a number : ");
								info = scan.next();
								arrayPersonResults[times].number.addCellPhoneNumber(info);
								break;
							}
							
							myLinkedList.addLast(arrayPersonResults[times]);
						} else if (data == 's') {
							myLinkedList.remove(arrayPersonResults[times]);
							arrayPersonResults[times] = null;
						} else if(data == 'e') {
							System.out.print("Enter name : ");
							String name = scan.next();
							System.out.print("Enter surname : ");
							String surname = scan.next();
							System.out.print("Enter address : ");
							scan.nextLine();
							String address = scan.nextLine();
							
							System.out.print("Do you want to add a phone number?(YES/NO) : ");
							String choice2 = scan.next();
							
							PhoneNumber no = new PhoneNumber("work", null);
							
							while(choice2.equals("YES") || choice2.equals("yes")) {
								String number;
								
								System.out.println("Which type number you will enter?");
								System.out.println("    1.Home");
								System.out.println("    2.Work");
								System.out.print("    3.Cell : ");
								int t = scan.nextInt();
								
								System.out.print("    Enter number : ");
								switch(t){
									case 1: number = scan.next(); no.addHomePhoneNumber(number);break;
									case 2: number = scan.next(); no.addWorkPhoneNumber(number);break;
									case 3: number = scan.next(); no.addCellPhoneNumber(number);break;
									default: System.out.println("Please enter 1-3 number!!!"); break;
								}
								System.out.print("Do you still want to add another phone number?(YES/NO) : ");
								choice2 = scan.next();
							}
							myLinkedList.addLast(new Person(name, surname, address, no));
						} else if (data == 'q') {
							System.out.println("Exit");
							loop = false;
						}
					}
				}
				break;
				case 3:
				System.out.print("Enter name : ");
				String name = scan.next();
				System.out.print("Enter surname : ");
				String surname = scan.next();
				System.out.print("Enter address : ");
				scan.nextLine();
				String address = scan.nextLine();
				
				System.out.print("Do you want to add a phone number?(YES/NO) : ");
				String choice2 = scan.next();
				
				PhoneNumber no = new PhoneNumber("work", "No Number");
				
				while(choice2.equals("YES") || choice2.equals("yes")) {
					String number;
					
					System.out.println("Which type number you will enter?");
					System.out.println("    1.Home");
					System.out.println("    2.Work");
					System.out.print("    3.Cell : ");
					int t = scan.nextInt();
					
					System.out.print("    Enter number : ");
					switch(t){
						case 1: number = scan.next(); no.addHomePhoneNumber(number);break;
						case 2: number = scan.next(); no.addWorkPhoneNumber(number);break;
						case 3: number = scan.next(); no.addCellPhoneNumber(number);break;
						default: System.out.println("Please enter 1-3 number!!!"); break;
					}
					System.out.print("Do you still want to add another phone number?(YES/NO) : ");
					choice2 = scan.next();
				}
				myLinkedList.addLast(new Person(name, surname, address, no));
				break;
				case 4:
				Person[] arrayPerson;
				int arraySize = myLinkedList.size();
				arrayPerson = new Person[arraySize];
				
				itr = myLinkedList.iterator();
				int number = 0;
				
					while(itr.hasNext()) {
						Person he = (Person)itr.next();
						arrayPerson[number] = he;
						number++;
					}
				
				for(int index = 0; index<arraySize;index++) {
					for(int index1 = 0; index1<arraySize-1;index1++) {
						if(arrayPerson[index1].getName().compareTo(arrayPerson[index1+1].getName()) > 0) {
							Person he = arrayPerson[index1];
							arrayPerson[index1] = arrayPerson[index1+1];
							arrayPerson[index1+1] = he; }
					}
				}
				
				for(int i=0; i<arraySize; i++) {
					System.out.println(arrayPerson[i]);
				}
				break;
				case 5:
					FileWriter fw = new FileWriter("PersonList.txt", false);
					BufferedWriter bw = new BufferedWriter(fw);
		
					itr = myLinkedList.iterator();
						while(itr.hasNext()) {
							Person he = (Person)itr.next();
							bw.write(he.getName() + "/");
							bw.write(he.getSurname() + "/");
							bw.write(he.getAddress() + "/");
							bw.write(he.number.getPhoneNumber("work") + "/");
							bw.write(he.number.getPhoneNumber("cell") + "/");
							bw.write(he.number.getPhoneNumber("home"));
							bw.newLine();;
						}
					bw.close();
				exit=5;
				break;
				default:
					System.out.println("Please enter 1-5 number!!!");
				break;
			}			
		}

	}
}
