package letterbox;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class StopWordManager {
    ArrayList<String> stop_words = new ArrayList<>();

    // CONSTRUTOR
    public StopWordManager() {
    }
    
    // MÉTODOS
    public boolean dispatch(ArrayList<String> message) throws IOException{
        if ("init".equals(message.get(0))){
           this.init();
        } else if ("is_stop_word".equals(message.get(0))){
            return is_stop_word(message.get(1));
        } else {
            throw new UnsupportedOperationException("Message not understood " + message.get(0));
        }
        
        return true;
    }

    private void init() throws FileNotFoundException, IOException {
        File arquivo = new File("stop_words.txt");
        FileReader fr = new FileReader(arquivo);
        BufferedReader br = new BufferedReader(fr);
        
        String[] strSplit = br.readLine().split(" ");
        stop_words = new ArrayList<>(Arrays.asList(strSplit));
        
        fr.close();
        br.close();
    }

    private boolean is_stop_word(String word) {
        return stop_words.contains(word);
    }
}
