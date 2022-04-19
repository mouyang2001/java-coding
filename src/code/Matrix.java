package code;

public class Matrix {
    /**
     * Transpose 2d array.
     * @param matrix 2 dimensional array.
     */
    public static void transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for (int r = 0; r < rows; r++) {
            for (int c = r; c < cols; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
    }

    public static void reflectVertical(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols/2; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[r][cols-1-c];
                matrix[r][cols-1-c] = temp;
            }
        }
    }

    public static void rotate(int[][] matrix) {
        transpose(matrix);
        reflectVertical(matrix);
    }
}
