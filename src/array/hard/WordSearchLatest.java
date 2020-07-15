package array.hard;

public class WordSearchLatest {

    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.isEmpty()) {
            return false;
        }
        visited = new boolean[board.length][];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j] && searchWord(i, j, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(int i, int j, int index, char[][] board, String word) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length ||word.charAt(index)!=board[i][j]|| visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (searchWord(i + 1, j, index + 1, board, word) ||
                searchWord(i + 1, j, index + 1, board, word) ||
                searchWord(i + 1, j, index + 1, board, word) ||
                searchWord(i + 1, j, index + 1, board, word)
        ) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
