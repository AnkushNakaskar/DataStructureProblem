package array.hard;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.isEmpty()) {
            return false;
        }
        char[] chars = word.toCharArray();
        int m = 0;
        int i = 0;
        int j = 0;
        boolean isFoundFirst = false;
        for (; i < board.length; i++) {
            j = 0;
            for (; j < board[i].length; j++) {
                if (chars[m] == board[i][j]) {
                    isFoundFirst = true;
                    m++;
                    break;
                }
            }
            if(isFoundFirst){
                System.out.println("Ankush");
                break;
            }

        }
        if (isFoundFirst) {
            while (m < chars.length) {
                if (i < 0 && i > board.length && j < 0 && j > board[i].length) {
                    break;
                }

                if (checkForword(chars[m], i, j, board)) {
                    m++;
                    j++;
                }
                if (checkBackword(chars[m], i, j, board)) {
                    m++;
                    j--;
                }
                if (checkUpword(chars[m], i, j, board)) {
                    m++;
                    i--;
                }
                if (checkDownWord(chars[m], i, j, board)) {
                    m++;
                    i++;
                }

            }
        }
        System.out.println("Length Search:::" + m);
        if (m == chars.length) {
            return true;
        }
        return false;
    }

    private boolean checkForword(char m, int i, int j, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 && j > board[i].length - 1) {
            return false;
        } else {
            if (board[i][j + 1] == m) {
                System.out.println("Moving forword : "+m );
                return true;
            }
        }
        return false;
    }

    private boolean checkBackword(char m, int i, int j, char[][] board) {
        if (i < 0 || i >= board.length || j <= 0 || j > board[i].length) {
            return false;
        } else {
            if (board[i][j - 1] == m) {
                System.out.println("Moving backword : "+m);
                return true;
            }
        }
        return false;
    }

    private boolean checkUpword(char m, int i, int j, char[][] board) {
        if (i <= 0 || i >= board.length || j < 0 || j > board[i].length) {
            return false;
        } else {
            if (board[i - 1][j] == m) {
                System.out.println("Moving upword :" +m);
                return true;
            }
        }
        return false;
    }

    private boolean checkDownWord(char m, int i, int j, char[][] board) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[i].length) {
            return false;
        } else {
            if (board[i + 1][j] == m) {
                System.out.println("Moving downword : "+m);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };
        String word = "ABCCED";
        String word1 = "SEE";
        String word2 = "ABCB";
        new WordSearch().exist(board,word1);
    }
}
