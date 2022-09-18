package letterbox;
import java.util.ArrayList;
import java.util.HashMap;

public class WordFrequencyManager {
    HashMap<String, Integer> word_freqs = new HashMap<>();

    // CONSTRUTOR
    public WordFrequencyManager() {
    }
    
    // MÉTODOS
    public void dispatch(ArrayList<String> message){
        switch (message.get(0)) {
            case "increment_count" -> increment_count(message.get(1));
            case "sorted" -> sorted();
            default -> throw new UnsupportedOperationException("Message not understood " + message.get(0));
        }
    }

    private void increment_count(String word) {
        if (word_freqs.containsKey(word)){
            word_freqs.replace(word, word_freqs.get(word) + 1);
        } else {
            word_freqs.put(word, 1);
        }
    }

    private void sorted() {}
}
