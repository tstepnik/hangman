import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    WordsDatabase database = new WordsDatabase();
    Hangman hg = new Hangman();
    String randomWord = database.randomWord();
    List<Character> characters = hg.changeWordToList(randomWord);
    List<Character> coverByStars = hg.coverByStars(characters);
    List<Character> copy = new ArrayList<>(characters);

    public static final int exit = 0;
    public static final int play = 1;

    public void hangman() {
        database.setCharacters(characters);
        database.setStars(coverByStars);
        int option = play;

        while (option != exit) {

            switch (option) {
                case exit:
                    System.out.println("Koniec programu");
                    sc.close();
                    break;
                case play:
                    guessWord();
            }

            printInfo(option);
        }
    }

    private void printInfo(int option) {
        System.out.println(exit + " - wyjście z gry.");
        System.out.println(play + " - graj dalej");
        option = sc.nextInt();
        sc.nextLine();
    }

    private void guessWord() {
        int copyIndex = 0;
        int shots = 0;

        while (!database.guessWord() && shots < 8) {
            System.out.println("Hasło do zgadnięcia:");
            database.printCoveredWord();
            System.out.println("Podaj literę:");

            char letter = sc.next().charAt(0);

            while (copy.contains(letter)) {
                copyIndex = copy.indexOf(letter);
                coverByStars.set(copyIndex, letter);
                copy.set(copyIndex, 'x');
            }

            if (copy.contains(letter))
                shots--;
            shots++;
        }
        if (coverByStars.equals(characters)) {
            System.out.println("Brawo zgadłeś, szukane słowo to: ");
            System.out.println(randomWord);
        } else
            System.out.println("Niestety wykorzystałeś masymalną liczbę prób.");
    }

}
