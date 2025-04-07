import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Runner {
// add functionality for two word, three word for next word
	public static void main(String[] args) {
		frequent();
	}
	
	public static void 
	
	
	public static void frequent() {
		Map<String, Map<String, Integer>> followers = new HashMap<>();
		try {
			Scanner scan = new Scanner(new File("shakespeare.txt"));

			String previous = null;

			while (scan.hasNext()) {
			    String current = scan.next().toLowerCase().replaceAll("[^-a-zA-Z]", "");

			    if (previous != null) {
			        // Get the map of followers or create a new one
			        Map<String, Integer> map = followers.getOrDefault(previous, new HashMap<>());
			        map.put(current, map.getOrDefault(current, 0) + 1);
			        followers.put(previous, map);
			    }

			    previous = current;
			}
			scan.close();

			// Now find the most frequent word that follows "will"
			String selected = "will";
			String greatest = "";
			int maxCount = 0;

			if (followers.containsKey(selected)) {
			    for (Map.Entry<String, Integer> entry : followers.get(selected).entrySet()) {
			        if (entry.getValue() > maxCount) {
			            maxCount = entry.getValue();
			            greatest = entry.getKey();
			        }
			    }
			}

			System.out.println(greatest + ", " + maxCount);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
}

/* HASH LOGIC
* TO: find the greatest (int) occurrence of a word pairing (String to String)
* Two hashmaps, one to store the String key to a Integer value, another to store the selected string
* and the String-Integer hashmap.
* Add onto the String-Integer hashmap for number of occurrences 
* 
* find the previous string to compare
* to find the number of occurrences for one string after the previous
* 
* count that in the wordOccurs hash
* repeat for all of the instances of the selected word
* 
* add to hasher, compare for the most common trailing word through the wordCount
*/ 


// next word based on prev, next based 2w, next based on 3w
// generate the most natural and longest sentence, starting with "once upon a time"
