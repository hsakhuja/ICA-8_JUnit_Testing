import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * @author = Hardik Sakhuja (hsakhuja)
 * 
 */
class urinals {
    public static void main(String args[]) throws IOException {
        System.out.println("hello");
        List<String> data = read("testfile.txt");
        System.out.println(data.toString());
    }

    public int getFreeUrinals(String[] arr) {
        if (!valid(arr)) {
            return -1;
        }
        int i = 0;
        int count = 0;
        while(i<arr.length) {
            // System.out.println(i);
            if(i==0 && arr[i].equals("0") && arr[i+1].equals("0")) {
                count++;
                arr[i] = "1";
                i++;
            } else if (i==arr.length-1 && arr[i].equals("0") && arr[i-1].equals("0")) {
                count++;
                arr[i] = "1";
                i++;
                break;
            } else if ( i < arr.length- 1 && arr[i].equals("0") && arr[i+1].equals("0") && arr[i-1].equals("0")) {
                count++;
                arr[i] = "1";
                i++;
            } else {
                i++;
            }
            }
            return count;
        }

    public boolean valid(String[] seq) {
        for (int i = 0; i < seq.length - 1; i++) {
            if (seq[i].equals("1") && seq[i + 1].equals("1")) {
                return false;
            }
        }
        return true;
    }

    public Boolean goodString(String str) { // checks to see if valid string
        System.out.println("====== Hardik Sakhuja == TEST TWO EXECUTED =======");
        return true;
    }

    public static List<String> read(String filename) throws IOException {
        String filePath = filename;
        Path p = Paths.get(filePath);
        // Path path = Path.of(String.format("data%s%s", DBDriver.OSFileDelimiter,
        // filename));
        if (Files.exists(p)) {
            return Files.readAllLines(p);
        }
        return null;
    }

    public static void write(List<String> data, String filename) throws IOException {
        String filePath = filename + ".txt";
        Path p = Paths.get(filePath);
        int suffix = 1;
        while(Files.exists(p)) {
            filePath = filename + String.valueOf(suffix) + ".txt";
            p = Paths.get(filePath);
            suffix++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            builder.append(data.get(i));
            builder.append('\n');
        }

        String string = builder.toString();

        Files.writeString(p, string,  StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}