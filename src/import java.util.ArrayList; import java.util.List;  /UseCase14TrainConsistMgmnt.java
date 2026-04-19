import java.util.ArrayList;
import java.util.List;

// Custom Exception Class
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

public class UseCase14TrainConsistMgmnt {

    public static class Bogie {
        public String name;
        public int capacity;

        public Bogie(String name, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC14 - Handle Invalid Bogie Capacity ");
        System.out.println("==========================================\n");

        try {
            System.out.println("Attempting to create a valid bogie...");
            Bogie validBogie = new Bogie("Sleeper", 72);
            System.out.println("Created: " + validBogie);

            System.out.println("\nAttempting to create an invalid bogie (0 capacity)...");
            Bogie invalidBogie = new Bogie("AC Chair", 0); 
            
        } catch (InvalidCapacityException e) {
            System.err.println("ALERT: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");
    }
}
