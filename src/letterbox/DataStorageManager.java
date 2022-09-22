package letterbox;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class DataStorageManager {
    String data;
    
    // CONSTRUTOR
    public DataStorageManager() {
    }
    
    // MÉTODOS
    public ArrayList dispatch(String message, ArrayList<String> lista){
        
        if ("init".equals(message)){
            return init(lista);
        } else if ("words".equals(message)) {
            return lista;
        } else {
            throw new UnsupportedOperationException("Message not understood " + message);
        }   

    }

    private ArrayList init(ArrayList<String> lista) {
        var pattern = Pattern.compile("[\\W_]+");
        
        for (String word : lista){
            data += word + " ";
        }
        
        data = data.replaceAll(String.valueOf(pattern), " ");
        return null;
    }
}
