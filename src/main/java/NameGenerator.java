import java.util.Arrays;
import java.util.Collections;

public class NameGenerator {
    private static String[] firstNames = new String[]{"Walter","Umayr","Cai","Carrie","Tala","Eira","Mateo","Amar","Axl","Mica"};
    private static String[] surnames = new String[]{"Cortez","Nguyen","Greaves","Barrow","Brady","Broughton","Holt","Wharton","Reed","Smith"};

    public static String[] generateName(){
        String[] generatedNames = new String[2];

        Collections.shuffle(Arrays.asList(firstNames));
        Collections.shuffle(Arrays.asList(surnames));

        generatedNames[0] = firstNames[0];
        generatedNames[1] = surnames[0];
        return generatedNames;
    }
}