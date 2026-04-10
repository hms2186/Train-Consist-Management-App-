import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UseCase9TrainConsistMgmnt {

    public static class Bogie {
        public String name;
        public int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    // Logic for grouping - this makes testing easy
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                     .collect(Collectors.groupingBy(b -> b.name));
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC9 - Group Bogies by Type ");
        System.out.println("==========================================\n");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));

        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        Map<String, List<Bogie>> groupedBogies = groupBogiesByType(bogies);

        System.out.println("\nGrouped Bogies:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\nBogie Type: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println("  Capacity -> " + b.capacity);
            }
        }

        System.out.println("\nUC9 grouping completed...");
    }
}