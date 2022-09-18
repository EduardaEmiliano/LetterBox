package letterbox;
import java.io.IOException;
import java.util.ArrayList;

public class LetterBox {
    public static void main(String[] args) throws IOException {
        ArrayList<String> lista = new ArrayList<>();
        var wfcontroller = new WordFrequencyController();
        
        lista.add("init");
        lista.add("stop");
        wfcontroller.dispatch(lista);
        
        lista.clear();
        lista.add("run");
        wfcontroller.dispatch(lista);
        
         
         
    }
    
}
