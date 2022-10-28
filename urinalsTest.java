import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class urinalsTest {
    urinals urinal = new urinals();
    @Test
    void testGoodString() {
        // fail("Test Failed");
        assertEquals(urinal.goodString(""), true);
    }

    @Test
    void testValid() {
        List<String> testdata = List.of("011","10001000");
        List<Boolean> answer = List.of(false,true); 
        List<Boolean> result = new ArrayList<>();
        for(int i=0; i<testdata.size();i++) {
            result.add(urinal.valid(testdata.get(i).trim().split("")));
        }
        Assert.assertEquals(answer, result);
    }
}
