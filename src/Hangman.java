import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hangman {

    private List<Character> characters = new ArrayList<>();
    private List<Character> coveredWord = new ArrayList<>();
    private List<Character> copyCharacters = new ArrayList<>();

    public Hangman() {
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public List<Character> getCoveredWord() {
        return coveredWord;
    }

    public void setCoveredWord(List<Character> coveredWord) {
        this.coveredWord = coveredWord;
    }

    public List<Character> getCopyCharacters() {
        return copyCharacters;
    }

    public void setCopyCharacters(List<Character> copyCharacters) {
        this.copyCharacters = copyCharacters;
    }

    public void changeStringToCharactersList(String randomWord) {
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
    
    boolean isLetterBeen(char c) {
        return characters.contains(c);
    }

    public void changeStarByCharacter(char c) {

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