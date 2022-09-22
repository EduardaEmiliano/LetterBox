package letterbox;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LetterBox {
    public static void main(String[] args) throws IOException {
        ArrayList<String> lista = new ArrayList<>(List.of("Somos", "o", "grupo", "de", "tp2", "que", "esta", "implementando", "um", "fuzzing", "utilizndo", "python", "e", "scala"));
        var wfcontroller = new WordFrequencyController();
        
        wfcontroller.dispatch("init", lista);
        wfcontroller.dispatch("run", lista);
        
    }
    
}
