package letterbox;
import java.io.IOException;
import java.util.ArrayList;

public class WordFrequencyController {
    DataStorageManager storage_manager = new DataStorageManager();
    StopWordManager stop_word_manager = new StopWordManager();
    WordFrequencyManager word_freq_manager = new WordFrequencyManager();
    ArrayList<String> initList = new ArrayList<>();
    ArrayList<String> stopList = new ArrayList<>();
    ArrayList<String> runList = new ArrayList<>();
    ArrayList<String> freqList = new ArrayList<>();
    
    // CONSTRUTOR
    public WordFrequencyController() {
    }
    
    // MÉTODOS
    public void dispatch(ArrayList<String> message) throws IOException{
        switch (message.get(0)) {
            case "init" -> init(message.get(1));
            case "run" -> run();
            default -> throw new UnsupportedOperationException("Message not understood " + message.get(0));
        } 
    }

    private void init(String message) throws IOException {
        initList.add("init");
        initList.add(message);
        storage_manager.dispatch(initList);
        
        stopList.add("init");
        stop_word_manager.dispatch(stopList);
    }
        

    private void run() throws IOException {
        runList.add("words");
        
        stopList.clear();
        stopList.add("is_stop_word");
        
        ArrayList<String> a = storage_manager.dispatch(runList);
        for (int i = 0; i < a.size(); i++){
            String w = a.get(i);
            stopList.add(w);
            if (stop_word_manager.dispatch(stopList)){
                freqList.clear();
                freqList.add("increment_count");
                freqList.add(w);
                word_freq_manager.dispatch(freqList);
            }
            
            stopList.remove(1);
        }
        }
    
}
