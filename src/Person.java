
public class Person {
	
	private String name, surname, address;
	PhoneNumber number;
	
	public Person(String name, String surname, String address, PhoneNumber number) {
		
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.number = number;
	}
	
	public String getName() {
		
		return name;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public String getSurname() {
		
		return surname;
	}
	
	public void setSurname(String surname) {
		
		this.surname = surname;
	}
	
	public String getAddress() {
		
		return address;
	}
	
	public void setAddress(String address) {
		
		this.address = address;
	}
	
	public String toString() {
		System.out.println();
		System.out.println();
		System.out.println("Name is : " + getName() + " Surname is : " + getSurname() + " Address is : " + getAddress());
        return number.toString();
    }
}