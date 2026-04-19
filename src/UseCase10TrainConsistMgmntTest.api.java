import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class UseCase10TrainConsistMgmntTest {

    @Test
    public void testReduce_TotalSeatCalculation() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("AC Chair", 56));

        int total = UseCase10TrainConsistMgmnt.calculateTotalCapacity(bogies);
        
        assertEquals(128, total);
    }

    @Test
    public void testReduce_EmptyBogieList() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        
        int total = UseCase10TrainConsistMgmnt.calculateTotalCapacity(bogies);
        
        assertEquals(0, total);
    }

    @Test
    public void testReduce_SingleBogieCapacity() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("First Class", 24));

        int total = UseCase10TrainConsistMgmnt.calculateTotalCapacity(bogies);
        
        assertEquals(24, total);
    }

    @Test
    public void testReduce_OriginalListUnchanged() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("Sleeper", 72));
        
        UseCase10TrainConsistMgmnt.calculateTotalCapacity(bogies);
        
        assertEquals(1, bogies.size());
    }
}
