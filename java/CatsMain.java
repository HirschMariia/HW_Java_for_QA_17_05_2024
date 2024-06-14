import java.util.Map;
import java.util.TreeMap;



public class CatsMain {
    public static void main(String[] args) {
        Map<String, Cats> catsMap = new TreeMap<>();


    catsMap.put("Tom", new Cats("Tom", 5, 4.2, "Siamese"));
    catsMap.put("Monja", new Cats("Monja", 6, 4.1, "Persian"));
    catsMap.put("Pushok", new Cats("Pushok", 2, 5.1, "Maine Coon"));

    for (Map.Entry<String, Cats> entry : catsMap.entrySet()) {
        if (entry.getValue().breed.equals("Persian")) {
            System.out.println(entry.getKey());
        }
    }

    double weightThreshold = 4.0;
    for (Map.Entry<String, Cats> entry : catsMap.entrySet()) {
        if (entry.getValue().weight > weightThreshold) {
            System.out.println(entry.getValue().name);
        }
    }

    Cats heaviestOldestCat = catsMap.entrySet().stream()
            .max((entry1, entry2) -> {
                if (entry1.getValue().weight == entry2.getValue().weight) {
                    return entry2.getValue().age - entry1.getValue().age;
                }
                return Double.compare(entry2.getValue().weight, entry1.getValue().weight);
            })
            .map(Map.Entry::getValue)
            .orElse(null);
    System.out.println("The heaviest and oldest cat.: " + heaviestOldestCat.name);
}
}