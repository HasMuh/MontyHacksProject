import java.util.*;

public class TicTacToe {
  // Variables ----------------------------------------------------------------
  private int rows, cols;
  private String[][] board = new String[rows][cols];
  private boolean game = false;
 
  public TicTacToe(){ // when called it starts a new game
    game = true;
  }  
  //AI ------------------------------------------------------------------------
  public void AiMove(){
   if() 
  }
  //Player methods ------------------------------------------------------------
  public void setBoard(int r, int c){ //Sets the size of the board
   rows = r;
   cols = c;
  }
   public void mark(int r, int c){ //Marks a certain spot. PLAYERS ARE Os
   board[r][c] = "O";
  }
  
  public static void main(String[] args) {
  int x;
  Scanner in = new Scanner(System.in);
    
    
  }
}
