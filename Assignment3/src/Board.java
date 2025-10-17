import java.util.Random;

public class Board {
    private final int size;
    private int[][] grid;
    private final Random random;

    public Board(int size) {
        this.size = size;
        this.grid = new int[size][size];
        this.random = new Random();
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] newGrid) {
        for (int i = 0; i < size; i++) {
            System.arraycopy(newGrid[i], 0, grid[i], 0, size);
        }
    }

    public void addRandomTile() {
        int value = random.nextInt(100) < 90 ? 2 : 4;
        int i, j;
        do {
            i = random.nextInt(size);
            j = random.nextInt(size);
        } while (grid[i][j] != 0);
        grid[i][j] = value;
    }

    public boolean contains2048() {
        for (int[] row : grid)
            for (int cell : row)
                if (cell == 2048)
                    return true;
        return false;
    }

    public boolean hasEmptyCell() {
        for (int[] row : grid)
            for (int cell : row)
                if (cell == 0)
                    return true;
        return false;
    }

    public void display() {
        System.out.println("---------------------------------");
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.printf("| %-5s", (cell == 0 ? "" : cell));
            }
            System.out.println("|");
            System.out.println("---------------------------------");
        }
    }

    public int getSize() {
        return size;
    }
}
