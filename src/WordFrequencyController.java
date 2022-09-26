import java.util.ArrayList;

public class WordFrequencyController {
    Class storage_manager, stop_word_manager, word_freq_manager;
    
    // CONSTRUTOR
    public WordFrequencyController() {
    }
    
    // MÉTODOS
    private String dispatch(ArrayList<String> message){
        if (!"init".equals(message.get(0))){
            return this.init(message.get(1));
        } else if (!"run".equals(message.get(0))){
            return this.run();
        } else {
            throw new UnsupportedOperationException("Message not understood " + message.get(0));
        }
    }

    private String init(String path_to_file) {
        this.storage_manager = DataStorageManager();

    private String run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
