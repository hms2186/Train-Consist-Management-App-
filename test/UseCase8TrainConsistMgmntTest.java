import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class UseCase8TrainConsistMgmntTest {

    @Test
    public void testFilter_CapacityGreaterThanThreshold() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("AC Chair", 56));

        List<UseCase8TrainConsistMgmnt.Bogie> result = UseCase8TrainConsistMgmnt.filterHighCapacityBogies(bogies, 60);
        
        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).name);
    }

    @Test
    public void testFilter_NoBogiesMatching() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("AC Chair", 56));

        List<UseCase8TrainConsistMgmnt.Bogie> result = UseCase8TrainConsistMgmnt.filterHighCapacityBogies(bogies, 70);
        
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_OriginalListUnchanged() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("Sleeper", 72));
        
        UseCase8TrainConsistMgmnt.filterHighCapacityBogies(bogies, 60);
        
        assertEquals(1, bogies.size());
    }
}
