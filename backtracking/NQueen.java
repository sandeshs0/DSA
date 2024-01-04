package backtracking;
import java.util.ArrayList;
import java.util.List;

public class NQueen {

    void safeBoard(char [][] board, List<List<Character>>allboard){
        // Garamla kei
    }   

    boolean isSafe(int r, int c, char [][] board){
        // base Case
        if(c==board.length){
            return;
        }

        // checking vertically
        int i=0;
        // i is now representing row
        for (i = 0; i <board.length; i++){
            if(board[i][c]=='Q'){
                return false;
            }
        }
        // checking horizontally
        // i now represents column
        for (i=0; i<board.length; i++){
            if(board[r][i]=='Q'){
                return false;
            }
        }
        // Checking Upward left diagonal
        i=r;
        for(int j=c; i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        // Checkking for Downward right diagonal
        i=r;
        for(int j=c; i>=board.length && j>=board.length; i++,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        // Checking for Upward Right diagonal'
        i=r;
        for(int j=c; i>=0 && j>=0; i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        // Checking downward left diagonal
        i=r;
        for(int j=c; i>=board.length && j>=0; i++,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
return true;
    }

    void placer(char[][] board, int c, List<List<Character>> allboard){
        for(int r=0; r<board.length; r++){
            if(isSafe(r,c,board)){

            }
        }
    }
    public static void main(String[] args) {
        List <List <Character>> allboard= new ArrayList<>();
        NQueen q= new NQueen();
        q.placer(new char[4][4], 0, allboard);
        board[r][c]='.';

    }
}
