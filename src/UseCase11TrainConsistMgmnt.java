import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UseCase11TrainConsistMgmnt {

    public static boolean isValidTrainID(String trainID) {
        String regex = "TRN-\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(trainID).matches();
    }

    public static boolean isValidCargoCode(String cargoCode) {
        String regex = "PET-[A-Z]{2}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(cargoCode).matches();
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC11 - Validate Train ID & Cargo Codes (Regex) ");
        System.out.println("==========================================\n");

        String[] testTrainIDs = {"TRN-1234", "TRAIN12", "TRN-123", "TRN-12345"};
        String[] testCargoCodes = {"PET-AB", "PET-ab", "PET123", "AB-PET"};

        System.out.println("Validating Train IDs:");
        for (String id : testTrainIDs) {
            System.out.println(id + " -> " + (isValidTrainID(id) ? "VALID" : "INVALID"));
        }

        System.out.println("\nValidating Cargo Codes:");
        for (String code : testCargoCodes) {
            System.out.println(code + " -> " + (isValidCargoCode(code) ? "VALID" : "INVALID"));
        }

        System.out.println("\nUC11 validation completed...");
    }
}
