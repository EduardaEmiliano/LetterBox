package letterbox;
import java.io.IOException;
import java.util.ArrayList;

public class WordFrequencyController {
    DataStorageManager   storage_manager   = new DataStorageManager();
    StopWordManager      stop_word_manager = new StopWordManager();
    WordFrequencyManager word_freq_manager = new WordFrequencyManager();
    
    ArrayList<String> initList = new ArrayList<>();
    ArrayList<String> stopList = new ArrayList<>();
    ArrayList<String> runList  = new ArrayList<>();
    ArrayList<String> freqList = new ArrayList<>();
    
    // CONSTRUTOR
    public WordFrequencyController() {
    }
    
    // MÉTODOS
    public void dispatch(String init, ArrayList<String> message) throws IOException{
        switch (init) {
            case "init" -> init(message);
            case "run" -> run();
            default -> throw new UnsupportedOperationException("Message not understood " + message.get(0));
        } 
    }

    private void init(ArrayList<String> lista) throws IOException {
        
        for (String word : lista){
            initList.add(word);}
        
        storage_manager.dispatch("init", initList);
        stop_word_manager.dispatch("init", null);
    }
        

    private void run() throws IOException {
        
        ArrayList<String> dataWords = storage_manager.dispatch("words", initList);
        for (String word : dataWords){
            if (stop_word_manager.dispatch("is_stop_word", word).equals("true")){
                word_freq_manager.dispatch("increment_count", word);
            }
        }
        
        word_freq_manager.dispatch("sorted", null);
    }
}
