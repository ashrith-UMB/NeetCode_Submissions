import java.util.HashSet;
import java.util.Set;

public class ValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        //Row
        for(int row = 0; row < 9; row++){
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i < 9; i++){
                if(board[row][i] == '.')
                    continue;
                if(seen.contains(board[row][i]))
                    return false;
                seen.add(board[row][i]);
            }
        }
        //Column
        for(int col = 0; col < 9; col++){
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i < 9; i++){
                if(board[i][col] == '.')
                    continue;
                if(seen.contains(board[i][col]))
                    return false;
                seen.add(board[i][col]);
            }
        }

        //Squares
        for(int square = 0; square < 9; square++){
            Set<Character> seen = new HashSet<>();

            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if(board[row][col] == '.')
                        continue;
                    if(seen.contains(board[row][col]))
                        return false;
                    seen.add(board[row][col]);
                }
            }
        }
        return true;

    }

    public static void main(String[] args){

        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        ValidSudoku36 validator = new ValidSudoku36();
        boolean result = validator.isValidSudoku(board);
        System.out.println("Is the Sudoku board valid? " + result);
        /*int col = 8/3;
        System.out.println(col);*/

    }
}
