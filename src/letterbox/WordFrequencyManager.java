package letterbox;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class WordFrequencyManager {
    HashMap<String, Integer> word_freqs = new HashMap<>();

    // CONSTRUTOR
    public WordFrequencyManager() {
    }
    
    // MÉTODOS
    public void dispatch(String message, String word){
        switch (message) {
            case "increment_count" -> increment_count(word);
            case "sorted" -> sorted();
            default -> throw new UnsupportedOperationException("Message not understood " + word);
        }
    }

    private void increment_count(String word) {
        if (word_freqs.containsKey(word)){
            word_freqs.replace(word, word_freqs.get(word) + 1);
        } else {
            word_freqs.put(word, 1);
        }
    }

    private void sorted() {
        List<Entry<String, Integer>> list = new ArrayList<>(word_freqs.entrySet());
        list.sort(Entry.comparingByValue());
	list.forEach(System.out::println);
    }
    
}
