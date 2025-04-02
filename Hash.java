import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class Hash {
	public static void readFile() {
		File data = new File("covid417.csv");
		Map<String, Map<String, City>> states = new HashMap<String, Map<String, City>>();
		try {
			Scanner scan = new Scanner(data);
			scan.nextLine();
			
			// initialize a hashmap to store the state value for the  key
			
			// print all values
			
			while(scan.hasNextLine()) {
				String[] row = scan.nextLine().split(",");
				String state = row[1];
				String city = row[0];
				
				Map<String, City> metrics = new HashMap<String, City>();
				
				City value = new City(row[0], row[1], Integer.parseInt(row[2]),Integer.parseInt(row[3]), Integer.parseInt(row[4]),Integer.parseInt(row[5]));
				if(!states.containsKey(state)) {
					metrics.put(city, value);
					states.put(state, metrics);
					System.out.println(states.toString());
				}
				else {
					states.replace(state, metrics);
				}
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		Scanner input = null;
		while(true) {
			input = new Scanner(System.in);
			System.out.println("Input a state: ");
			String stateIn = input.nextLine();
			if(states.containsKey(stateIn)) {
				
				
			}
			else {
				System.out.println("Error: state not found");
			}
			input.close();
			
			Map<String, City> cities = states.get(stateIn);
			
			input = new Scanner(System.in);
			System.out.println("Input a city: ");
			String cityIn = input.nextLine();
			
			if(cities.containsKey(cityIn)) {
				states.put(cityIn, cities);
				System.out.println(states.toString());
			}
			input.close();
		}
		
		
	}
	
	
//	public static Map<String, Integer> getInput(Map<String, Integer> hashMap) {
//		
//		if(hashMap.containsKey(key)) {
//			hashMap.replace(key, value);
//		}
//		else {
//			hashMap.put(key, value);
//		}
//		return hashMap;
//		
//	}
	
	
	public static void main(String[] args) {
		readFile();
	}
}
