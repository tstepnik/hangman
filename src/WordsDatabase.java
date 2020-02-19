import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordsDatabase {

    private List<String> words;
    private Random random;

    public WordsDatabase() {
        this.words = new ArrayList<>();
        this.random = new Random();
    }

    public void addWord(String word) {
        words.add(word);
    }

    public String drawWord() {
        return words.get(random.nextInt(words.size()));
    }
}