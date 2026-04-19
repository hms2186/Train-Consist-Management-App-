import static org.junit.Assert.*;
import org.junit.Test;

public class UseCase14TrainConsistMgmntTest {

    @Test
    public void testException_ValidCapacityCreation() throws InvalidCapacityException {
        UseCase14TrainConsistMgmnt.Bogie bogie = new UseCase14TrainConsistMgmnt.Bogie("Sleeper", 72);
        assertNotNull(bogie);
        assertEquals(72, bogie.capacity);
    }

    @Test(expected = InvalidCapacityException.class)
    public void testException_NegativeCapacityThrowsException() throws InvalidCapacityException {
        new UseCase14TrainConsistMgmnt.Bogie("Sleeper", -10);
    }

    @Test(expected = InvalidCapacityException.class)
    public void testException_ZeroCapacityThrowsException() throws InvalidCapacityException {
        new UseCase14TrainConsistMgmnt.Bogie("AC Chair", 0);
    }

    @Test
    public void testException_ExceptionMessageValidation() {
        try {
            new UseCase14TrainConsistMgmnt.Bogie("Sleeper", -5);
            fail("Expected an InvalidCapacityException to be thrown");
        } catch (InvalidCapacityException e) {
            assertEquals("Capacity must be greater than zero", e.getMessage());
        }
    }
}
