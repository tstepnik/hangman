import java.util.*;

public class Game {
    private List<String> words = new ArrayList<>();
    Random random = new Random();
    WordsDatabase database = new WordsDatabase(words, random);
    public final int exit = 0;
    public final int play = 1;
    private int opition = 1;
    Scanner sc = new Scanner(System.in);

    public void hangman() {
        try {
            while (opition != exit) {


                switch (opition) {
                    case exit:
                        System.out.println("Koniec gry.");
                        sc.close();
                        break;
                    case play:
                        game();
                        break;
                    default:
                        System.out.println("Nie ma takiej opcji.");
                }
                System.out.println("Dostępne opcję:");
                System.out.println("0 - wyjście z programu.");
                System.out.println("1 - graj dalej");
                opition = sc.nextInt();
                sc.nextLine();

            }
        } catch (InputMismatchException e) {
            System.out.println("Nie mozna podawać znaków niezgodnych z poleceniem.");
        }
    }

    private void game() {
        Hangman hangman = new Hangman(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        hangman.changeStringToCharactersList(database.drawWord());
        hangman.changeCharByStars();
        int chances = 0;
        while (!hangman.wordIsGuessed() && chances < 8) {
            System.out.println("Hasło:");
            hangman.printCoverWord();
            System.out.println("Podaj literę:");
            char guessedChar = sc.next().charAt(0);
            if (hangman.containChar(guessedChar) || hangman.ignoreChosenChar(guessedChar)) {
                chances--;
            }
            hangman.changeStarByCharacter(guessedChar);
            chances++;
        }
        if (hangman.wordIsGuessed()) {
            System.out.println("brawo zgadłeś, hasło którego szukałeś to:");
            hangman.printCharacters();
            System.out.println();
        } else if (chances >= 8) System.out.println("Niestety przekroczyłeś limit dostępnych zgadnięć.");
        else System.out.println("coś poszło nie tak.");
    }
}

