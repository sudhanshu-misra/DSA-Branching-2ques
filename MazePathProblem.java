import java.util.*;

class MazePathProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter the number of columns: ");
        int columns = sc.nextInt();

        int[][] maze = new int[rows][columns];

        System.out.println("Enter the maze layout (0 for empty path, 1 for blocked path):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        List<String> path = new ArrayList<>();
        boolean foundPath = findPath(maze, 0, 0, rows, columns, path);

        if (foundPath) {
            System.out.println("Path Found:");
            for (String step : path) {
                System.out.println(step);
            }
        } else {
            System.out.println("No path found!");
        }

        sc.close();
    }

    public static boolean findPath(int[][] maze, int row, int col, int rows, int columns, List<String> path) {
        if (row < 0 || row >= rows || col < 0 || col >= columns || maze[row][col] == 1) {
            return false;
        }

        if (row == rows - 1 && col == columns - 1) {
            path.add("(" + row + ", " + col + ")");
            return true;
        }

        if (findPath(maze, row + 1, col, rows, columns, path)
                || findPath(maze, row, col + 1, rows, columns, path)) {
            path.add("(" + row + ", " + col + ")");
            return true;
        }

        return false;
    }
} 