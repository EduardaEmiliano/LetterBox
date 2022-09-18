package letterbox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DataStorageManager {
    String data;
    
    // CONSTRUTOR
    public DataStorageManager() {
    }
    
    // MÉTODOS
    public ArrayList dispatch(ArrayList<String> message){
        
        if ("init".equals(message.get(0))){
            return init(message.get(1));
        } else if ("words".equals(message.get(0))) {
            return words();
        } else {
            throw new UnsupportedOperationException("Message not understood " + message.get(0));
        }   
    }

    private ArrayList init(String message) {
        var pattern = Pattern.compile("[\\W_]+");
        data = message;
        data = data.replaceAll(String.valueOf(pattern), " ");
        return null;
    }

    private ArrayList words() {
        String[] strSplit = data.split(" ");
        ArrayList<String> strList = new ArrayList<>(Arrays.asList(strSplit));
        return strList;
        }
}
