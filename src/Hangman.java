import java.util.ArrayList;
import java.util.List;

public class Hangman {

    private List<Character> characters = new ArrayList<>();
    private List<Character> coveredWord = new ArrayList<>();
    private List<Character> copyCharacters = new ArrayList<>();

    public Hangman() {}

    public void changeStringToChars(String randomWord) {
        for (char c : randomWord.toCharArray()) {
            characters.add(c);
            copyCharacters.add(c);
        }
    }

    public void changeCharByStars() {
        characters.forEach(x -> coveredWord.add('*'));
    }

    public void printCoveredWord() {
        coveredWord.forEach(System.out::print);
        System.out.println();
    }

    public void printCharacters() {
        characters.forEach(System.out::print);
    }

    boolean containsChar(char c) {
        return characters.contains(c);
    }

    public void revealChar(char c) {

        while (copyCharacters.contains(c)) {
            int index = copyCharacters.indexOf(c);
            coveredWord.set(index, c);
            copyCharacters.set(index, 'x');
        }
    }

    public boolean isWordGuessed() {
        return coveredWord.equals(characters);
    }
}