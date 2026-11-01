class Solution {
    public boolean isValidSudoku(char[][] board) {
        // iterate thru every row
        for (int row = 0; row < 9; row++) {
            Set<Character> set = new HashSet<>();

            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    if (set.contains(board[row][col])) {
                        return false;
                    } else {
                        set.add(board[row][col]);
                    }
                }
            }
        }

        // iterate thru every column
        for (int col = 0; col < 9; col++) {
            Set<Character> set = new HashSet<>();

            for (int row = 0; row < 9; row++) {
                if (board[row][col] != '.') {
                    if (set.contains(board[row][col])) {
                        return false;
                    } else {
                        set.add(board[row][col]);
                    }
                }
            }
        }

        // iterate thru every box
        for (int box = 1; box <= 9; box++) {
            Set<Character> set = new HashSet<>();

            int row = (box - 1) / 3 * 3;
            int col = (box - 1) % 3 * 3;

            for (int r = row; r < row + 3; r++) {
                for (int c = col; c < col + 3; c++) {
                    if (board[r][c] != '.') {
                        if (set.contains(board[r][c])) {
                            return false;
                        } else {
                            set.add(board[r][c]);
                        }
                    }
                }
            }
        }

        return true;
    }
}
