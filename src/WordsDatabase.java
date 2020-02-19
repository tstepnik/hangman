import java.util.List;
import java.util.Random;

public class WordsDatabase {

    private List<String> words;
    private Random random;

    public WordsDatabase(List<String> words, Random random) {
        this.words = words;
        this.random = random;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public void addWord(String word) {
        words.add(word);
    }

    public String drawWord() {
        return words.get(random.nextInt(words.size()));
    }
}