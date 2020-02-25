import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Game {
    private WordsDatabase database = new WordsDatabase();
    private Scanner sc = new Scanner(System.in);

    public void hangmanGame() {
        final int EXIT = 0;
        final int PLAY = 1;
        String fileName = "words.txt";
        try (
                var fileReader = new FileReader(fileName);
                var bufferedReader = new BufferedReader(fileReader);
        ) {

            while (bufferedReader.readLine() != null) {
                database.addWord(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean isException = true;
        while (isException) {
            try {
                int option = -1;
                while (option != EXIT) {

                    System.out.println("Dostępne opcję:");
                    System.out.println("0 - wyjście z programu.");
                    System.out.println("1 - graj");
                    option = sc.nextInt();
                    sc.nextLine();

                    switch (option) {
                        case EXIT:
                            System.out.println("Koniec gry.");
                            sc.close();
                            break;
                        case PLAY:
                            guessCoveredWord();
                            break;
                        default:
                            System.out.println("Nie ma takiej opcji.");
                    }
                }
                isException = false;
            } catch (InputMismatchException e) {
                System.out.println("Podałeś niepoprawny znak.");
                sc.nextLine();
            }
        }
    }

    private void guessCoveredWord() {
        Hangman hangman = new Hangman();
        hangman.changeStringToChars(database.drawWord());
        hangman.changeCharByStars();
        int chances = 0;
        while (!hangman.isWordGuessed() && chances < 8) {
            System.out.println("Hasło:");
            hangman.printCoveredWord();
            System.out.println("Podaj literę:");
            char guessedChar = sc.next().charAt(0);
            if (!hangman.containsChar(guessedChar)) {
                chances++;
            }
            hangman.revealChar(guessedChar);
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



