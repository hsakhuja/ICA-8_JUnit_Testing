import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.fail;

import java.io.IOException;
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

    @Test
    void testGetFreeUrinals() {
        List<String> testdata = List.of("10001","1001","00000","0000","01000","011");
        List<Integer> answer = List.of(1,0,3,2,1,-1);
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<testdata.size();i++) {
            result.add(urinal.getFreeUrinals(testdata.get(i).trim().split("")));
        }
        Assert.assertEquals(answer, result);
    }

    @Test
    void testRead() throws IOException{
        String testFileName = new String();
        testFileName = "somefile.txt";
        List<String> result = urinals.read(testFileName);
        Assert.assertEquals(null, result);
    }
    
    
}
