import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UseCase13TrainConsistMgmnt {

    public static class Bogie {
        public String name;
        public int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // Traditional Loop approach
    public static List<Bogie> filterWithLoop(List<Bogie> bogies, int threshold) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > threshold) {
                result.add(b);
            }
        }
        return result;
    }

    // Stream API approach
    public static List<Bogie> filterWithStream(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                     .filter(b -> b.capacity > threshold)
                     .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC13 - Performance Comparison (Loops vs Streams) ");
        System.out.println("==========================================\n");

        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 56));
        }

        // Measure Loop
        long startTimeLoop = System.nanoTime();
        List<Bogie> loopResult = filterWithLoop(bogies, 60);
        long endTimeLoop = System.nanoTime();
        long durationLoop = endTimeLoop - startTimeLoop;

        // Measure Stream
        long startTimeStream = System.nanoTime();
        List<Bogie> streamResult = filterWithStream(bogies, 60);
        long endTimeStream = System.nanoTime();
        long durationStream = endTimeStream - startTimeStream;

        System.out.println("Loop-Based Execution Time: " + durationLoop + " ns");
        System.out.println("Stream-Based Execution Time: " + durationStream + " ns");
        System.out.println("\nUC13 performance comparison completed...");
    }
}
