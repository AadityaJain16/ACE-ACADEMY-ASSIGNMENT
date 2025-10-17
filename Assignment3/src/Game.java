public class Game {
    private final Board board;
    private final InputHandler input;
    private final MoveTracker tracker;
    private int score;

    public Game(int size) {
        this.board = new Board(size);
        this.input = new InputHandler();
        this.tracker = new MoveTracker();
        this.score = 0;
    }

    public void start() {
        board.addRandomTile();
        board.addRandomTile();

        while (true) {
            board.display();
            System.out.println("Score: " + score);
            tracker.showMoveStats();

            char move = input.getUserMove();
            tracker.recordMove(move);

            boolean moved = processMove(move);
            if (moved) board.addRandomTile();

            if (board.contains2048()) {
                board.display();
                System.out.println("🎉 You WIN! Final Score: " + score);
                tracker.showMoveStats();
                break;
            }
            if (!board.hasEmptyCell() && !canMerge()) {
                board.display();
                System.out.println("💀 Game Over! Final Score: " + score);
                tracker.showMoveStats();
                break;
            }
        }
    }

    private boolean canMerge() {
        int[][] grid = board.getGrid();
        int n = board.getSize();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (i < n - 1 && grid[i][j] == grid[i + 1][j]) return true;
                if (j < n - 1 && grid[i][j] == grid[i][j + 1]) return true;
            }
        return false;
    }

    private boolean processMove(char move) {
        int[][] grid = board.getGrid();
        int[][] oldGrid = copyGrid(grid);

        switch (move) {
            case 'A' -> moveLeft(grid);
            case 'D' -> moveRight(grid);
            case 'W' -> moveUp(grid);
            case 'S' -> moveDown(grid);
        }

        boolean changed = !areSame(oldGrid, grid);
        if (changed) board.setGrid(grid);
        return changed;
    }

    private void moveLeft(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int[] row = new int[n];
            int pos = 0;

            // shift non-zero values
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) row[pos++] = grid[i][j];
            }

            // merge
            for (int j = 0; j < n - 1; j++) {
                if (row[j] != 0 && row[j] == row[j + 1]) {
                    row[j] *= 2;
                    score += row[j];
                    row[j + 1] = 0;
                }
            }

            // shift again
            int[] newRow = new int[n];
            pos = 0;
            for (int j = 0; j < n; j++) {
                if (row[j] != 0) newRow[pos++] = row[j];
            }
            grid[i] = newRow;
        }
    }

    private void moveRight(int[][] grid) {
        reverseRows(grid);
        moveLeft(grid);
        reverseRows(grid);
    }

    private void moveUp(int[][] grid) {
        grid = transpose(grid);
        moveLeft(grid);
        grid = transpose(grid);
        board.setGrid(grid);
    }

    private void moveDown(int[][] grid) {
        grid = transpose(grid);
        moveRight(grid);
        grid = transpose(grid);
        board.setGrid(grid);
    }

    private int[][] transpose(int[][] grid) {
        int n = grid.length;
        int[][] newGrid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                newGrid[i][j] = grid[j][i];
        return newGrid;
    }

    private void reverseRows(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = grid[i][j];
                grid[i][j] = grid[i][n - j - 1];
                grid[i][n - j - 1] = temp;
            }
        }
    }

    private boolean areSame(int[][] oldgrid, int[][] grid) {
        for (int i = 0; i < oldgrid.length; i++)
            for (int j = 0; j < oldgrid.length; j++)
                if (oldgrid[i][j] != grid[i][j])
                    return false;
        return true;
    }

    private int[][] copyGrid(int[][] source) {
        int n = source.length;
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++)
            System.arraycopy(source[i], 0, copy[i], 0, n);
        return copy;
    }
}
