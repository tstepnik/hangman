import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordsDatabase {

   private  List<String> words = new ArrayList<>();
   private List<Character> characters;
   private List<Character> stars = new ArrayList<>();
   private Random random = new Random();

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public List<Character> getStars() {
        return stars;
    }

    public void setStars(List<Character> stars) {
        this.stars = stars;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public String randomWord(){
        int randomIndex = random.nextInt(words.size());
        return words.get(randomIndex);
    }
    public void add(String word){
        words.add(word);
    }
    public void printCoveredWord(){
       stars.forEach(x -> System.out.print('*'));
    }

    public boolean guessWord(){
        return stars.equals(characters);
    }
}
