import java.lang.Math;
import java.util.Arrays;

public class NeedlemanWunsch {

    public static final int START = 0;
    public static final int MATCH = 1;
    public static final int MISMATCH = -1;
    public static final int INDEL = -1;

    public static int[][] findSolution(String strand1, String strand2) {
        int[][] solution = new int[strand1.length()+1][strand2.length()+1];

        solution[0][0] = START;

        for (int i = 1; i < strand2.length()+1; i++) {
            solution[0][i] = solution[0][i-1] - 1;
        }

        for (int i = 1; i < strand1.length()+1; i++) {
            solution[i][0] = solution[i-1][0] - 1;
        }

        for (int i = 1; i < strand1.length()+1; i++) {
            for (int j = 1; j < strand2.length()+1; j++) {

                int matchValue;

                if (strand1.charAt(i-1) == strand2.charAt(j-1)) matchValue = MATCH;
                else matchValue = MISMATCH;

                solution[i][j] = max(solution[i][j-1] + INDEL, solution[i-1][j] + INDEL,  solution[i-1][j-1] + matchValue);
            }
        }

        return solution;
    }

    private static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
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
    
    public static String findPath(int[][] solution, String format) {
        if (format == "staggered") {
            return findPath(solution).replaceAll("(.)(\\1)", "$1");
        } else if (format == "standard") {
            return findPath(solution);
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(findSolution("AGCT", "AGCT")));
    }
}
