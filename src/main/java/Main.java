import java.io.IOException;
import java.lang.String;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] search = CoreDB.findJournal("cancer", "journals");
        for (String item : search) {
            System.out.println(item);
        }
    }
}

