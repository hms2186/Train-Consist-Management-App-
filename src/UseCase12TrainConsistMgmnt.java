import java.util.ArrayList;
import java.util.List;

public class UseCase12TrainConsistMgmnt {

    public static class GoodsBogie {
        public String type;
        public String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    // Safety Rule: If type is Cylindrical, cargo MUST be Petroleum
    public static boolean checkSafetyCompliance(List<GoodsBogie> bogies) {
        return bogies.stream().allMatch(b -> 
            !(b.type.equalsIgnoreCase("Cylindrical")) || b.cargo.equalsIgnoreCase("Petroleum")
        );
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC12 - Safety Compliance Check (Goods) ");
        System.out.println("==========================================\n");

        List<GoodsBogie> train = new ArrayList<>();
        train.add(new GoodsBogie("Cylindrical", "Petroleum"));
        train.add(new GoodsBogie("Open", "Coal"));
        train.add(new GoodsBogie("Box", "Grain"));

        boolean isSafe = checkSafetyCompliance(train);

        System.out.println("Safety Check Results:");
        for (GoodsBogie b : train) {
            System.out.println("Type: " + b.type + " | Cargo: " + b.cargo);
        }

        System.out.println("\nTrain Safety Compliant: " + (isSafe ? "YES (Safe to Depart)" : "NO (Safety Violation!)"));
        System.out.println("\nUC12 safety check completed...");
    }
}
