public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.database.add("kwiatek");
        game.database.add("drzewo");
        game.database.add("ptak");
        game.database.add("programowanie");
        game.hangman();
    }
}
