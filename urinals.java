import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author = Hardik Sakhuja (hsakhuja)
 * 
 */
class urinals {

    private static final String READ_FILE = "urinal.dat"; 
    private static final String WRITE_FILE = "rule";
    public static void main(String args[]) throws IOException {
        urinals urinal = new urinals();
        System.out.println("hello");
        System.out.println("Select input source:\n1.Keyboard\n2.File\n");
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if (choice == 1) {
            urinal.handleKeyboardInput();
        } else {
            List<String> data = urinal.handleFileInput();
            List<String> res = new ArrayList<>();
            for (int i=0; i < data.size(); i++ ) {
                int num = urinal.getFreeUrinals(data.get(i).split(""));
                res.add(String.valueOf(num));
                if(num == -1) {
                    break;
                }
           }
           try {
            urinal.write(res,WRITE_FILE);
            } catch (IOException e) {
                System.out.println("Error writing to file");
                e.printStackTrace();
        }
        }
    }

    public List<String> handleFileInput() {
        List<String> data = new ArrayList<>();
        try {
            data = read(READ_FILE);
        } catch (IOException e) {
            System.out.println("Error in reading file");
            e.printStackTrace();
        }
        return data;
    }

    public void handleKeyboardInput() {
        System.out.println(
                "Enter binary string representing urinal status\n(0 for unoccupied urinal and 1 for occupied urinals, space separated)");
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        String sequence = scan.nextLine();
        String[] sequenceArray = sequence.trim().split("");
        int freeUrinals = getFreeUrinals(sequenceArray);
        System.out.println(freeUrinals);
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

    public List<String> read(String filename) throws IOException {
        String filePath = filename;
        Path p = Paths.get(filePath);
        // Path path = Path.of(String.format("data%s%s", DBDriver.OSFileDelimiter,
        // filename));
        List<String> data = new ArrayList<>();
        try {
            data = Files.readAllLines(p);
        } catch (IOException e) {
            throw e;
        }
        return data;
    }

    public void write(List<String> data, String filePath) throws IOException {
        Path p = Paths.get(filePath);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            builder.append(data.get(i));
            builder.append('\n');
        }

        String string = builder.toString();

        try {
            Files.writeString(p, string,  StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw e;
        }
    }

    public String generateFileName() {
        String filename = WRITE_FILE;
        int suffix = 0;
        Path p = Paths.get(filename+".txt");
        while(Files.exists(p)) {
            suffix++;
            filename = WRITE_FILE + String.valueOf(suffix) + ".txt";
            p = Paths.get(filename);
        }
        return p.toString();
    }
}