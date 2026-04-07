public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // iterate through rows
        for (int i = 0; i < 9; i++) {
            Set<Character> rows = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (rows.contains(board[i][j])) {
                    return false;
                }

                rows.add(board[i][j]);
            }
        }

        // iterate through columns
        for (int j = 0; j < 9; j++) {
            Set<Character> columns = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (columns.contains(board[i][j])) {
                    return false;
                }

                columns.add(board[i][j]);
            }
        }

        // iterate through boxes
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                Set<Character> boxes = new HashSet<>();

                for (int i = k * 3; i < (k + 1) * 3 ; i++) {
                    for (int j = l * 3; j < (l + 1) * 3; j++) {
                        if (board[i][j] == '.') {
                            continue;
                        }

                        if (boxes.contains(board[i][j])) {
                            return false;
                        }

                        boxes.add(board[i][j]);
                    }
                }
            }
        }

        return true;
    }
}
