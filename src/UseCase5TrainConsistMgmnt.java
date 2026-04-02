import java.util.HashMap;
import java.util.Map;

public class UseCase5TrainConsistMgmnt {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println(" UC5 - Map Bogie IDs to Details ");
        System.out.println("==========================================\n");

        Map<String, String> bogieRegistry = new HashMap<>();

        bogieRegistry.put("BG101", "Sleeper Class (72 Seats)");
        bogieRegistry.put("BG102", "AC Three Tier (64 Seats)");
        bogieRegistry.put("BG103", "Pantry Car");
        bogieRegistry.put("BG104", "Goods - Coal (20 Tons)");

        System.out.println("Bogie Registry updated...");
        
        String searchId = "BG102";
        if (bogieRegistry.containsKey(searchId)) {
            System.out.println("Details for " + searchId + " : " + bogieRegistry.get(searchId));
        }

        System.out.println("\nFull Train Inventory:");
        for (Map.Entry<String, String> entry : bogieRegistry.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " | Type: " + entry.getValue());
        }

        System.out.println("\nUC5 mapping completed...");
    }
}