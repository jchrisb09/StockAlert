import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;


public class PersistentStorage {

    public static void persistentStorageTest() {

        // List of Strings to be used as the "key"
        ArrayList<String> listOfKeys = new ArrayList<>();
        listOfKeys.add("a");
        listOfKeys.add("b");
        listOfKeys.add("c");
        listOfKeys.add("d");
        listOfKeys.add("e");
        listOfKeys.add("f");

        // List of Strings to be used as the "values"
        ArrayList<String> listOfValues = new ArrayList<>();
        listOfValues.add("1");
        listOfValues.add("2");
        listOfValues.add("3");
        listOfValues.add("4");
        listOfValues.add("5");
        listOfValues.add("6");

        // Initialize object
        JSONObject jsonObject = new JSONObject();

        // Take the "keys" and "values" and put them into the JSON Object
        for (int i = 0; i < listOfValues.size(); i++) {
            jsonObject.put(listOfKeys.get(i), listOfValues.get(i));
        }

        // This is your user directory... pulled from the enviromental variable USERPROFILE
        String userprofile = System.getenv("USERPROFILE");

        // File writer, Make JSON file
        try {
            FileWriter file = new FileWriter(userprofile + "/Desktop/jsonObjectTest.json");
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
