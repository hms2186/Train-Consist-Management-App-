import static org.junit.Assert.*;
import org.junit.Test;

public class UseCase11TrainConsistMgmntTest {

    @Test
    public void testRegex_ValidTrainID() {
        assertTrue(UseCase11TrainConsistMgmnt.isValidTrainID("TRN-1234"));
    }

    @Test
    public void testRegex_InvalidTrainIDFormat() {
        assertFalse(UseCase11TrainConsistMgmnt.isValidTrainID("TRAIN12"));
        assertFalse(UseCase11TrainConsistMgmnt.isValidTrainID("1234-TRN"));
    }

    @Test
    public void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(UseCase11TrainConsistMgmnt.isValidTrainID("TRN-123")); // Too short
        assertFalse(UseCase11TrainConsistMgmnt.isValidTrainID("TRN-12345")); // Too long
    }

    @Test
    public void testRegex_ValidCargoCode() {
        assertTrue(UseCase11TrainConsistMgmnt.isValidCargoCode("PET-AB"));
    }

    @Test
    public void testRegex_InvalidCargoCodeFormat() {
        assertFalse(UseCase11TrainConsistMgmnt.isValidCargoCode("PET123"));
        assertFalse(UseCase11TrainConsistMgmnt.isValidCargoCode("AB-PET"));
    }

    @Test
    public void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(UseCase11TrainConsistMgmnt.isValidCargoCode("PET-ab")); // Lowercase rejected
    }

    @Test
    public void testRegex_EmptyInputHandling() {
        assertFalse(UseCase11TrainConsistMgmnt.isValidTrainID(""));
        assertFalse(UseCase11TrainConsistMgmnt.isValidCargoCode(""));
    }
}
