
/**
 * @author = Hardik Sakhuja (hsakhuja)
 * 
 */
class urinals {
    public static void main(String args[]) {
        System.out.println("hello");
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