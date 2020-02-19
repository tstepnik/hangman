public class Main{
    public static void main(String[] args) {
        Game game = new Game();
        game.database.addWord("drzewo");
        game.database.addWord("zamek");
        game.database.addWord("kwiatek");
        game.database.addWord("programowanie");

        game.hangman();
    }
}