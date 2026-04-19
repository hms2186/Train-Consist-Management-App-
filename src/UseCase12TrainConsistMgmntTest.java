import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class UseCase12TrainConsistMgmntTest {

    @Test
    public void testSafety_AllBogiesValid() {
        List<UseCase12TrainConsistMgmnt.GoodsBogie> train = new ArrayList<>();
        train.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Cylindrical", "Petroleum"));
        train.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Open", "Coal"));
        
        assertTrue(UseCase12TrainConsistMgmnt.checkSafetyCompliance(train));
    }

    @Test
    public void testSafety_CylindricalWithInvalidCargo() {
        List<UseCase12TrainConsistMgmnt.GoodsBogie> train = new ArrayList<>();
        train.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Cylindrical", "Coal")); // Illegal!
        
        assertFalse(UseCase12TrainConsistMgmnt.checkSafetyCompliance(train));
    }

    @Test
    public void testSafety_EmptyBogieList() {
        List<UseCase12TrainConsistMgmnt.GoodsBogie> train = new ArrayList<>();
        // No bogies = no violations = true
        assertTrue(UseCase12TrainConsistMgmnt.checkSafetyCompliance(train));
    }

    @Test
    public void testSafety_NonCylindricalBogiesAllowed() {
        List<UseCase12TrainConsistMgmnt.GoodsBogie> train = new ArrayList<>();
        train.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Open", "Petroleum"));
        train.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Box", "Coal"));
        
        assertTrue(UseCase12TrainConsistMgmnt.checkSafetyCompliance(train));
    }
}
