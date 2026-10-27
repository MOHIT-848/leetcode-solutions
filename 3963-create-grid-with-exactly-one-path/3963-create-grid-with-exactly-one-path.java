class Solution {
    public String[] createGrid(int m, int n) {
        StringBuilder[] grid = new StringBuilder[m];
        
        // Step 1: Initialize all cells with '#' (obstacles)
        for (int i = 0; i < m; i++) {
            grid[i] = new StringBuilder();
            for (int j = 0; j < n; j++) {
                grid[i].append('#');
            }
        }
        
        // Step 2: Create a single valid path of '.'
        // Go right along the top row (row 0)
        for (int j = 0; j < n; j++) {
            grid[0].setCharAt(j, '.');
        }
        
        // Go down along the last column (column n - 1)
        for (int i = 0; i < m; i++) {
            grid[i].setCharAt(n - 1, '.');
        }
        
        // Step 3: Convert StringBuilder array to String array
        String[] result = new String[m];
        for (int i = 0; i < m; i++) {
            result[i] = grid[i].toString();
        }
        
        return result;
    }
}