import java.util.*;

public class Game {
    WordsDatabase database = new WordsDatabase();
    public final int EXIT = 0;
    public final int PLAY = 1;
    Scanner sc = new Scanner(System.in);

    public void hangmanGame() {
        database.addWord("drzewo");
        database.addWord("zamek");
        database.addWord("kwiatek");
        database.addWord("programowanie");
        boolean tryCatchIsUsed = true;
        while (tryCatchIsUsed) {
            try {
                int option = -1;
                while (option != EXIT) {

                    System.out.println("Dostępne opcję:");
                    System.out.println("0 - wyjście z programu.");
                    System.out.println("1 - graj.");
                    option = sc.nextInt();
                    sc.nextLine();

                    switch (option) {
                        case EXIT:
                            System.out.println("Koniec gry.");
                            sc.close();
                            break;
                        case PLAY:
                            operationsOnCoveredCharacterLists();
                            break;
                        default:
                            System.out.println("Nie ma takiej opcji.");
                    }
                }
                tryCatchIsUsed = false;
            } catch (InputMismatchException e) {
                System.out.println("Podałeś niepoprawny znak.");
                sc.nextLine();
            }
        }
    }

    private void operationsOnCoveredCharacterLists() {
        Hangman hangman = new Hangman();
        hangman.changeStringToCharactersList(database.drawWord());
        hangman.changeCharByStars();
        int chances = 0;
        while (!hangman.isWordGuessed() && chances < 8) {
            System.out.println("Hasło:");
            hangman.printCoveredWord();
            System.out.println("Podaj literę:");
            char guessedChar = sc.next().charAt(0);
            if (!hangman.isLetterBeen(guessedChar)) {
                chances++;
            }
            hangman.changeStarByCharacter(guessedChar);
        }
        if (hangman.isWordGuessed()) {
            System.out.println("brawo zgadłeś, hasło którego szukałeś to:");
            hangman.printCharacters();
            System.out.println();
        } else if (chances >= 8) {
            System.out.println("Niestety przekroczyłeś limit dostępnych zgadnięć.");
        } else {
            System.out.println("coś poszło nie tak.");
        }
    }
}


