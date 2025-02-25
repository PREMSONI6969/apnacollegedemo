public class MatrixChecker {

    public static boolean canBeResultMatrix(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Reverse the first step
        int[][] step1Matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            int minRow = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                minRow = Math.min(minRow, matrix[i][j]);
            }
            for (int j = 0; j < n; j++) {
                step1Matrix[i][j] = matrix[i][j] + minRow;
            }
        }

        // Step 2: Reverse the second step
        int[][] originalMatrix = new int[n][n];
        for (int j = 0; j < n; j++) {
            int minCol = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                minCol = Math.min(minCol, step1Matrix[i][j]);
            }
            for (int i = 0; i < n; i++) {
                originalMatrix[i][j] = step1Matrix[i][j] + minCol;
            }
        }

        // Check if all elements in the original matrix are non-negative
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (originalMatrix[i][j] < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {2, 3, 4},
            {3, 4, 5}
        };

        if (canBeResultMatrix(matrix)) {
            System.out.println("The given matrix can be the result of the described algorithm.");
        } else {
            System.out.println("The given matrix cannot be the result of the described algorithm.");
        }
    }
}
