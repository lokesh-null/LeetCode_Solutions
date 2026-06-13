class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int column) {
        if ( row == board.length) {
            return true;
        }

        if (column == board[0].length) {
            return solve(board, row + 1, 0);
        }

        if (board[row][column] != '.') {
            return solve(board, row, column + 1);
        }

        for (char num = '1'; num <= '9'; num++) {
            if (isValid(board, row, column, num)) {
                board[row][column] = num;


                if (solve(board, row, column + 1)) {
                return true;
                
                }

                 board[row][column] = '.';
            }

        }

        return false;
    }

    private boolean isValid(char[][] board, int row, int column, char num) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] == num) {
                return false;
            }

            if (board[row][i] == num) {
                return false;
            }

            int subgridRow = 3 * (row / 3) + i / 3;
            int subgridColumn = 3 * (column / 3) + i % 3;

            if ( board[subgridRow][subgridColumn] == num) {
                return false;
            }
        }

        return true;
    }
}