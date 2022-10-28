import org.junit.jupiter.api.Test;
import static org.junit.Assert.fail;
import static org.junit.Assert.*;

public class urinalsTest {

    @Test
    void testGoodString() {
        // fail("Test Failed");
        urinals urinal = new urinals();
        assertEquals(urinal.goodString(""), true);
    }
}
