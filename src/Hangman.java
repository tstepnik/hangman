import java.util.List;

public class Hangman {

    private List<Character> characters;
    private List<Character> coveredWord;
    private List<Character> copyCharacters;

    public Hangman(List<Character> characters, List<Character> coveredWord, List<Character> copyCharacters) {
        this.characters = characters;
        this.coveredWord = coveredWord;
        this.copyCharacters = copyCharacters;
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
        for (int i = 0; i < characters.size(); i++) {
            coveredWord.add('*');
        }
    }

    public void printCoverWord() {
        coveredWord.forEach(System.out::print);
        System.out.println();
    }

    public void printCharacters() {
        characters.forEach(System.out::print);
    }

    boolean containChar(char c) {
        return copyCharacters.contains(c);
    }

    boolean ignoreChosenChar(char c) {
        return coveredWord.contains(c);
    }

    public void changeStarByCharacter(char c) {

        while (copyCharacters.contains(c)) {
            int index = copyCharacters.indexOf(c);
            coveredWord.set(index, c);
            copyCharacters.set(index, 'x');
        }
    }

    public boolean wordIsGuessed() {
        boolean isEquals = coveredWord.equals(characters);
        return isEquals;
    }
}