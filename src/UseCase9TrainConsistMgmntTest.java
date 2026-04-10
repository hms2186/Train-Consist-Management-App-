import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UseCase9TrainConsistMgmntTest {

    @Test
    public void testGrouping_BogiesGroupedByType() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 70));

        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> result = UseCase9TrainConsistMgmnt.groupBogiesByType(bogies);
        
        assertTrue(result.containsKey("Sleeper"));
        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    public void testGrouping_DifferentBogieTypes() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("AC Chair", 56));

        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> result = UseCase9TrainConsistMgmnt.groupBogiesByType(bogies);
        
        assertEquals(2, result.size());
        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
    }

    @Test
    public void testGrouping_OriginalListUnchanged() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72));
        
        int originalSize = bogies.size();
        UseCase9TrainConsistMgmnt.groupBogiesByType(bogies);
        
        assertEquals(originalSize, bogies.size());
    }
}