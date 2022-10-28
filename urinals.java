
/**
 * @author = Hardik Sakhuja (hsakhuja)
 * 
 */
class urinals {
    public static void main(String args[]) {
        System.out.println("hello");
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
}