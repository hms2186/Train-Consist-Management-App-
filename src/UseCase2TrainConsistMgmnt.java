import java.util.ArrayList;
import java.util.List;

public class UseCase2TrainConsistMgmnt {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println(" UC2 - Add Passenger Bogies to Train ");
        System.out.println("==========================================\n");

        List<String> passengerBogies = new ArrayList<>();

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("Passenger bogies added successfully...");
        System.out.println("Current Consist : " + passengerBogies);
        System.out.println("Initial Bogie Count : " + passengerBogies.size());

        System.out.println("\nDetaching 'AC Chair' for maintenance...");
        passengerBogies.remove("AC Chair");

        boolean hasSleeper = passengerBogies.contains("Sleeper");
        System.out.println("Checking availability...");
        System.out.println("Does 'Sleeper' bogie exist? " + hasSleeper);

        System.out.println("\nFinal Train Consist : " + passengerBogies);
        System.out.println("Updated Bogie Count : " + passengerBogies.size());
        
        System.out.println("\nSystem ready for next operation...");
    }
}