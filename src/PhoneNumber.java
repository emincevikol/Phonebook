
public class PhoneNumber {
	
	private String type;
	private String number;
	HashMap<String,String> myHashMap = new HashMap<String,String>();
	
	public PhoneNumber(String type,String number){
	
		this.type = type;
		this.number = number;
		myHashMap.put("work", "No Number");
		myHashMap.put("cell", "No Number");
		myHashMap.put("home", "No Number");
		myHashMap.put(type, number);
	}
	
	public void addCellPhoneNumber(String cellNumber) {
		
		myHashMap.put("cell", cellNumber);
	}
	
	public void addHomePhoneNumber(String homeNumber) {
		
		myHashMap.put("home", homeNumber);
	}
	
	public void addWorkPhoneNumber(String workNumber) {
		
		myHashMap.put("work", workNumber);
	}
	
	public String getPhoneNumber(String type) {
	
		return myHashMap.get(type);
	}
	
	public void setPhoneNumber(String number) {
		
		this.number = number;
	}
	
	public void printAllPhoneNumber() {
		
		myHashMap.printHashMap();
	}
	
	public String toString() {
		System.out.println("Work phone number is : " + getPhoneNumber("work"));
		System.out.println("Cell phone number is : " + getPhoneNumber("cell"));
        return "Home phone number is : " + getPhoneNumber("home");
    }
}
