import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordsDatabase {

    private List<String> words = new ArrayList<>();
    private Random random = new Random();

    public WordsDatabase() {
    }

    public void addWord(String word) {
        words.add(word);
    }

    public String drawWord() {
        return words.get(random.nextInt(words.size()));
    }
}