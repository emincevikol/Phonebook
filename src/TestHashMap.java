public class TestHashMap 
{
	public static void main(String[] args) 
	{
		HashMap<Integer,String> myHashMap = new HashMap<Integer,String>();
		
		System.out.println();
		System.out.println("The size of the HashMap : " + myHashMap.size());
		System.out.println("Is HashMap empty : " + myHashMap.isEmpty());	
		System.out.println();

		String result;
		
		result = myHashMap.put(1, "Emre");
		result = myHashMap.put(2, "Ilker");
		result = myHashMap.put(4, "Tahir");
		result = myHashMap.put(5, "Ovunc");
		result = myHashMap.put(6, "Tugrul");
		result = myHashMap.put(7, "Tugba");
		result = myHashMap.put(9, "Zeynep");
		result = myHashMap.put(10, "Ali");
		result = myHashMap.put(11, "Veli");
		result = myHashMap.put(12, "Ayse");
		
		myHashMap.printHashMap();
		
		System.out.println();
		System.out.println("The size of the HashMap : " + myHashMap.size());
		System.out.println("Is HashMap empty : " + myHashMap.isEmpty());
		System.out.println();
		
		result = myHashMap.put(11, "Osman");
		System.out.println("key: 11 -> Put : Osman " + "Get : " + result);
		myHashMap.printHashMap();
		
		System.out.println();
		result = myHashMap.get(2);
		System.out.println("Get : " + result);	
		myHashMap.printHashMap();

		System.out.println();
		result = myHashMap.remove(7);
		System.out.println("Remove : " + result);
		
		myHashMap.printHashMap();

	}
}	