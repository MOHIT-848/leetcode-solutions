class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int r = 0;
        int c = col-1;

        while (r<= row-1 && c>=0) {
            if (matrix[r][c] == target) {
                return true;
            }
            else if (matrix[r][c] > target) {
                c--;
            }
            else {
                r++;
            }
        }
        return false;
    }
}