import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> cityPopulation = new HashMap<>();
        cityPopulation.put("City1", 1000);
        cityPopulation.put("City2", 1500);
        cityPopulation.put("City3", 900);
        cityPopulation.put("City4", 2000);

        // Find the city with the largest population
        int maxPopulation = 0;
        String cityWithMaxPopulation = "";
        for (Map.Entry<String, Integer> entry : cityPopulation.entrySet()) {
            if (entry.getValue() > maxPopulation) {
                maxPopulation = entry.getValue();
                cityWithMaxPopulation = entry.getKey();
            }
        }
        System.out.println("City with the largest population: " + cityWithMaxPopulation);

        // Calculate the average population across all cities
        double totalPopulation = 0;
        for (int population : cityPopulation.values()) {
            totalPopulation += population;
        }
        double avgPopulation = totalPopulation / cityPopulation.size();
        System.out.println("Average population across all cities: " + avgPopulation);

        // Find all cities with the same population
        Map<Integer, String> citiesWithSamePopulation = new HashMap<>();
        for (Map.Entry<String, Integer> entry : cityPopulation.entrySet()) {
            String city = entry.getKey();
            int population = entry.getValue();
            if (citiesWithSamePopulation.containsKey(population)) {
                String cities = citiesWithSamePopulation.get(population);
                cities += "," + city;
                citiesWithSamePopulation.put(population, cities);
            } else {
                citiesWithSamePopulation.put(population, city);
            }
        }
        for (Map.Entry<Integer, String> entry : citiesWithSamePopulation.entrySet()) {
            System.out.println("Cities with the same population " + entry.getKey() + ": " + entry.getValue());
        }
    }
}