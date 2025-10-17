import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    public char getUserMove() {
        System.out.print("Enter move (W/A/S/D): ");
        String moveInput = scanner.nextLine().trim().toUpperCase();

        if (moveInput.isEmpty()) return getUserMove();

        char move = moveInput.charAt(0);
        if ("WASD".indexOf(move) != -1)
            return move;

        System.out.println("❌ Invalid move! Use W/A/S/D.");
        return getUserMove();
    }
}
