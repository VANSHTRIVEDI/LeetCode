package Medium.Miscellaneous;

//https://leetcode.com/problems/word-search/?envType=daily-question&envId=2024-04-03
public class Word_Search {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        boolean result = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = backtrack(board, word, visited, i, j, 0);
                    if (result)
                        return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]
                || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;

        if (backtrack(board, word, visited, i + 1, j, index + 1) ||
                backtrack(board, word, visited, i - 1, j, index + 1) ||
                backtrack(board, word, visited, i, j + 1, index + 1) ||
                backtrack(board, word, visited, i, j - 1, index + 1)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}

// https://www.naukri.com/code360/problems/word-search_892986?leftPanelTabValue=SUBMISSION
class word2 {

    public static boolean present(char[][] board, String word, int n, int m) {

        // Write your code here.

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {

                char ch = word.charAt(0);

                if (board[i][j] == ch) {

                    if (helper(i, j, board, word, 1)) {

                        return true;

                    }

                }

            }

        }

        return false;

    }

    private static boolean helper(int r, int c, char[][] board, String word, int count) {

        if (count == word.length()) {

            return true;

        }

        char currChar = board[r][c];

        board[r][c] = '!';

        char nextChar = word.charAt(count);

        // up

        if (r > 0 && board[r - 1][c] == nextChar) {

            if (helper(r - 1, c, board, word, count + 1))
                return true;

        }

        // down

        if (r < board.length - 1 && board[r + 1][c] == nextChar) {

            if (helper(r + 1, c, board, word, count + 1))
                return true;

        }

        // left

        if (c > 0 && board[r][c - 1] == nextChar) {

            if (helper(r, c - 1, board, word, count + 1))
                return true;

        }

        // right

        if (c < board[0].length - 1 && board[r][c + 1] == nextChar) {

            if (helper(r, c + 1, board, word, count + 1))
                return true;

        }

        board[r][c] = currChar;

        return false;

    }

}
