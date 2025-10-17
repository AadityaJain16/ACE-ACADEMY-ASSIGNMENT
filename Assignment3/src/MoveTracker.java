public class MoveTracker {
    private int totalMoves;
    private int leftMoves;
    private int rightMoves;
    private int upMoves;
    private int downMoves;

    public void recordMove(char move) {
        totalMoves++;
        switch (move) {
            case 'A' -> leftMoves++;
            case 'D' -> rightMoves++;
            case 'W' -> upMoves++;
            case 'S' -> downMoves++;
        }
    }

    public int getTotalMoves() { return totalMoves; }
    public int getLeftMoves() { return leftMoves; }
    public int getRightMoves() { return rightMoves; }
    public int getUpMoves() { return upMoves; }
    public int getDownMoves() { return downMoves; }

    public void showMoveStats() {
        System.out.println("\n===== MOVE STATS =====");
        System.out.println("Total Moves: " + totalMoves);
        System.out.println("Left Moves:  " + leftMoves);
        System.out.println("Right Moves: " + rightMoves);
        System.out.println("Up Moves:    " + upMoves);
        System.out.println("Down Moves:  " + downMoves);
        System.out.println("=======================\n");
    }
}
