public class Main {
    public static void main(String[] args) {
        System.out.println("====== Welcome to 2048 ======");
        Game game = new Game(4); // 4x4 board
        game.start();
    }
}
