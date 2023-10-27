import java.util.Scanner;

public class WordSearchAlgo {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        //System.out.print("Enter target value: ");
        String target = "ABCE"; //scanner.nextLine();
        System.out.println(exist(board, target));
    }

    /* public static boolean exist(char[][] board, String word) {
        char[] wrd = word.toLowerCase().toCharArray();
        boolean out = false;
        for (int setOfChar = 0; setOfChar < board.length; setOfChar++) {
            int index =0;
            while(true){
                if(index < board[setOfChar].length-1){
                    if(board[setOfChar][index] == wrd[index]) {
                        out = true;
                        index++;
                        continue;
                    }else if(out && wrd[index]==board[setOfChar +1][index])
                }

            }

            
        }
    } */

    
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        // Iterate through each cell in the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            // We have found the complete word
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            // Out of bounds or the current cell doesn't match the current character in the word
            return false;
        }

        // Mark the current cell as visited by changing it to a special character
        char original = board[i][j];
        board[i][j] = '#';

        // Check adjacent cells in all four directions
        boolean found = dfs(board, i - 1, j, word, index + 1) ||  // Up
                        dfs(board, i + 1, j, word, index + 1) ||  // Down
                        dfs(board, i, j - 1, word, index + 1) ||  // Left
                        dfs(board, i, j + 1, word, index + 1);    // Right

        // Restore the original character in the cell
        board[i][j] = original;

        return found;
    }
    
    
}
