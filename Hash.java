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

                City value = new City(
                    row[0], row[1], 
                    Integer.parseInt(row[2]), 
                    Integer.parseInt(row[3]), 
                    Integer.parseInt(row[4]), 
                    Integer.parseInt(row[5])
                );

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

            // Compute and display total metrics for the state
            City totals = getStateTotals(cities);
            System.out.println("\nState Totals for " + stateIn + ":");
            System.out.println("  Total Cases: " + totals.getCases());
            System.out.println("  Total Deaths: " + totals.getDeaths());
            System.out.println("  Total Recovered: " + totals.getRecovered());
            System.out.println("  Total Hospitalized: " + totals.getHospitalized());

            // Prompt for city
            System.out.print("\nInput a city: ");
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

    // Compute total metrics for a state
    public static City getStateTotals(Map<String, City> cities) {
        int totalCases = 0;
        int totalDeaths = 0;
        int totalRecovered = 0;
        int totalHospitalized = 0;

        for (City city : cities.values()) {
            totalCases += city.getCases();
            totalDeaths += city.getDeaths();
            totalRecovered += city.getRecovered();
            totalHospitalized += city.getHospitalized();
        }

        return new City("ALL_CITIES", "STATE_TOTAL", totalCases, totalDeaths, totalRecovered, totalHospitalized);
    }

    public static void main(String[] args) {
        readFile();
    }
}
