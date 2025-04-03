import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class Hash {
    public static void readFile() {
        File data = new File("covid417.csv");
        Map<String, Map<String, City>> states = new HashMap<>();

        try {
            Scanner scan = new Scanner(data);
            scan.nextLine(); // Skip header line

            while (scan.hasNextLine()) {
                String[] row = scan.nextLine().split(",");
                if (row.length < 6) {
                    System.err.println("Skipping invalid row: " + String.join(",", row));
                    continue;
                }

                String state = row[1];
                String city = row[0];

                City value = new City(row[0], row[1], 
                                      Integer.parseInt(row[2]), Integer.parseInt(row[3]), 
                                      Integer.parseInt(row[4]), Integer.parseInt(row[5]));

                states.putIfAbsent(state, new HashMap<>());
                states.get(state).put(city, value);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // User Input Loop
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Input a state (or type 'exit' to quit): ");
            String stateIn = input.nextLine().trim();
            if (stateIn.equalsIgnoreCase("exit")) {
                break;
            }

            if (!states.containsKey(stateIn)) {
                System.out.println("Error: state not found");
                continue;
            }

            Map<String, City> cities = states.get(stateIn);

            System.out.print("Input a city: ");
            String cityIn = input.nextLine().trim();

            if (cities.containsKey(cityIn)) {
                City cityData = cities.get(cityIn);
                System.out.println("City Data: " + cityData);
            } else {
                System.out.println("Error: city not found");
            }
        }
        input.close();
    }

    public static void main(String[] args) {
        readFile();
    }
}
