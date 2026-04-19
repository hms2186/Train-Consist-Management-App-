import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class UseCase13TrainConsistMgmntTest {

    @Test
    public void testLoopAndStreamResultsMatch() {
        List<UseCase13TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase13TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase13TrainConsistMgmnt.Bogie("AC Chair", 56));

        List<UseCase13TrainConsistMgmnt.Bogie> loopRes = UseCase13TrainConsistMgmnt.filterWithLoop(bogies, 60);
        List<UseCase13TrainConsistMgmnt.Bogie> streamRes = UseCase13TrainConsistMgmnt.filterWithStream(bogies, 60);
        
        assertEquals(loopRes.size(), streamRes.size());
        assertEquals(loopRes.get(0).name, streamRes.get(0).name);
    }

    @Test
    public void testExecutionTimeMeasurement() {
        List<UseCase13TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase13TrainConsistMgmnt.Bogie("General", 90));

        long start = System.nanoTime();
        UseCase13TrainConsistMgmnt.filterWithLoop(bogies, 60);
        long end = System.nanoTime();
        
        assertTrue((end - start) >= 0);
    }
}
