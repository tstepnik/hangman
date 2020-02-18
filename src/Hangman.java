import java.util.*;

public class Hangman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int exit = 0;
        final int play = 1;

        List<String> words = new ArrayList<>();
        words.add("java");
        words.add("drzewo");
        words.add("zamek");

        int option = play;

        while (option != exit) {

            switch (option) {

                case exit:
                    System.out.println("wyjście z programu.");
                    break;
                case play:
                    game(words, sc);
            }
            System.out.println("dostępne opcje:");
            System.out.println(exit + " - wyjście z gry.");
            System.out.println(play + " - graj dalej.");
            option = sc.nextInt();
            sc.nextLine();
        }
    }

    private static void game(List<String> list, Scanner scanner) {
        Random random = new Random();
        int index = random.nextInt(list.size());
        String word = list.get(index);
        List<Character> characters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            characters.add(c);
        }
        List<Character> coveredWord = new ArrayList<>();
        for (int i = 0; i < characters.size(); i++) {
            coveredWord.add('*');
        }
        int number = 0;
        while (number < 8 && !coveredWord.equals(characters)) {
            System.out.println("Hasło do zgadnięcia:");
            coveredWord.forEach(System.out::print);
            System.out.println();
            System.out.println("Podaj literę:");
            char c = scanner.next().charAt(0);
            int copyIndex = 0;
            List<Character> copylist = new ArrayList<>(characters);
            if (copylist.contains(c)){
                number--;
            }
            while (copylist.contains(c)) {
                    copyIndex = copylist.indexOf(c);
                    coveredWord.set(copyIndex, c);
                    copylist.set(copyIndex, 'x');
                }
            number++;

        }
        if (characters.equals(coveredWord)) {
            System.out.println("Brawo zgadłeś");
            System.out.println("twoje słowo to : " + word);
        }else {
            System.out.println("Niestety wyczerpałeś limit prób, słowo którego szukałeś to:" + word);
        }
    }
}