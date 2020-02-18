import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hangman {

    List<Character> changeWordToList (String word){
        char[] chars = word.toCharArray();
        List<Character> characters = new ArrayList<>();
        for (char aChar : chars) {
            characters.add(aChar);
        }
        return characters;
    }

    public List<Character> coverByStars(List<Character> characters){
        List<Character> stars = new ArrayList<>();
        for (int i = 0; i < characters.size(); i++) {
            stars.add('*');
        }
        return stars;
    }
}
