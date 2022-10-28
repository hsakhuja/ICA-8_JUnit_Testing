import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UrinalsTest {
    private final urinals uri = new urinals();

    @Test
    void testGoodString() {
        System.out.println("====== Hardik Sakhuja == TEST ONE EXECUTED =======");
        System.out.println("testing Dummy test");
        // fail("Test Failed");
        Assertions.assertEquals(uri.goodString(""), true);
    }

    @Test
    void testValid() {
        System.out.println("====== Hardik Sakhuja == TEST TWO EXECUTED =======");
        System.out.println("Testing Valid and Invalid strings");
        List<String> testdata = List.of("011", "10001000", "1000A001", "ASU", "1111111");
        List<Boolean> answer = List.of(false, true, false, false, false);
        List<Boolean> result = new ArrayList<>();
        for (String data : testdata) {
            result.add(uri.valid(data.trim().split("")));
        }
        Assertions.assertEquals(answer, result);
    }

    @Test
    void testGetFreeUrinals() {
        System.out.println("====== Hardik Sakhuja == TEST THREE EXECUTED =======");
        System.out.println("testing getFreeUrinals Algorithm function");
        List<String> testdata = List.of("10001", "1001", "00000", "0000", "01000", "011");
        List<Integer> answer = List.of(1, 0, 3, 2, 1, -1);
        List<Integer> result = new ArrayList<>();
        for (String data : testdata) {
            result.add(uri.getFreeUrinals(data.trim().split("")));
        }
        Assertions.assertEquals(answer, result);
    }

    @Test
    void testReadSuccess() throws IOException {
        System.out.println("====== Hardik Sakhuja == TEST FOUR EXECUTED =======");
        System.out.println("testing File read successfully");
        List<String> answer = List.of("10001", "1001", "00000", "0000", "01000", "011");
        String testFileName = "urinal.dat";
        List<String> result = uri.read(testFileName);
        Assertions.assertEquals(answer, result);
    }

    @Test
    void testReadDoNotExist() {
        System.out.println("====== Hardik Sakhuja == TEST FIVE EXECUTED =======");
        System.out.println("testing read file - IOException and Do not Exist");
        String filename = "someFilename.txt";
        assertThrows(IOException.class, () -> uri.read(filename));
    }

    @Test
    void testReadEmptyFile() throws IOException {
        System.out.println("====== Hardik Sakhuja == TEST SIX EXECUTED =======");
        System.out.println("testing read file empty file");
        String testFilename = uri.generateFileName();
        List<String> emptydata = new ArrayList<>();
        uri.write(emptydata, testFilename);
        List<String> readData = uri.read(testFilename);
        Assertions.assertEquals(readData, emptydata);
    }

    @Test
    void testWrite() throws IOException {
        System.out.println("====== Hardik Sakhuja == TEST SEVEN EXECUTED =======");
        System.out.println("testing write file successfully");
        List<String> testdata = List.of("10001", "1001", "00000", "0000", "01000", "011");
        String testFilename = uri.generateFileName();
        uri.write(testdata, testFilename);
        List<String> readData = uri.read(testFilename);
        Assertions.assertEquals(readData, testdata);
    }

    @Test
    void testWriteIOExcepton() {
        System.out.println("====== Hardik Sakhuja == TEST EIGHT EXECUTED =======");
        System.out.println("testing write IO Exception");
        final String filename = "/someDir/abc.txt";
        assertThrows(IOException.class, () -> uri.write(new ArrayList<>(), filename));
    }
}
