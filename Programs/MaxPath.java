import java.lang.Math;
import java.util.Arrays;

public class MaxPath {
    public static int[][] findSolution(int[][] grid) {
        int[][] solution = new int[grid.length][grid[0].length];
        String path = "";

        solution[0][0] = grid[0][0];

        for (int i = 1; i < grid[0].length; i++) {
            solution[0][i] = grid[0][i] + solution[0][i-1];
        }

        for (int i = 1; i < grid.length; i++) {
            solution[i][0] = grid[i][0] + solution[i-1][0];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                solution[i][j] = grid[i][j] + Math.max(solution[i-1][j], solution[i][j-1]);
            }
        }

        return solution;
    }

    public static String findPath(int[][] solution) {
        String path = "";
        int i = solution.length - 1;
        int j = solution[0].length - 1;
        int pathLength = i + j;

        while (i != 0 && j != 0) {
            if (solution[i][j-1] > solution[i-1][j]) {
                path = "R" + path;
                j -= 1;
            } else {
                path = "D" + path;
                i -= 1;
            }
        }

        int currentPathLength = path.length();

        if (i == 0) {
            for (int k = 0; k < pathLength - currentPathLength; k++) {
                path = "R" + path;
            }
        } else {
            for (int k = 0; k < pathLength - currentPathLength; k++) {
                path = "D" + path;
            }
        }

        return path;
    }

    public static void main(String[] args) {
        // Walls
        int x = Integer.MIN_VALUE;
        int[][] grid1 = {{1, 6, 3, 5},
                        {2, 9, 7, 2},
                        {3, 4, 10, 4}};
        int[][] grid2 = {{0, 3, 0, 2, 0, 4, 0, 1, 0},
                        {1, x, 0, x, 2, x, 4, x, 4},
                        {0, 3, 0, 2, 0, 5, 0, 2, 0},
                        {3, x, 6, x, 8, x, 6, x, 8},
                        {0, 5, 0, 7, 0, 3, 0, 4, 0},
                        {6, x, 4, x, 5, x, 2, x, 1},
                        {0, 3, 0, 7, 0, 0, 0, 2, 0},
                        {7, x, 6, x, 3, x, 4, x, 3},
                        {0, 1, 0, 3, 0, 2, 0, 2, 0}};

        System.out.println(findPath(findSolution(grid1)));
        System.out.println(findPath(findSolution(grid2)));
    }
}
