import java.util.*;

public class TicTacToe {
  // Variables ----------------------------------------------------------------
  private int rows, cols;
  private String[][] board = new String[rows][cols];
  private boolean game = false;
 
  public TicTacToe(){ // when called it starts a new game
    game = true;
  }  
  public int countEmpt(){ // counts the empty spaces left on the board
    int spaces = 0;
    for(int x = 0; x < board.length; x++){ //rows
        for(int y = 0; y < board[0].length; y ++){ //collums
          if(board[x][y].equals("")){
           spaces ++; 
          }
    }}
  }
   public boolean verticalWin()
  {
	  for(int c = 0; c < board[0].length; c++)
	  {
		  if(board[0][c].equals("X") && board[1][c].equals("X") && board[2][c].equals("X"))
		  {
			  aiWin = true;
			  return true;
		  }
		  else if(board[0][c].equals("O") && board[1][c].equals("O") && board[2][c].equals("O"))
		  {
			  playerWin = true; 
			  return true;
		  }
			  
	  }
 
	  return false;
}
  public void hCheck(){ // checks the board Horizontally for a win
    
  }
  public void sidewayCheck() {     
  }
  //AI ------------------------------------------------------------------------
  public void AiMove(){ //AI will pick from 3 random points and choose where to go
    int[] p1 = {0,0};
    int[] p2 = {0,0};
    int[] p3 = {0,0};
  for(int i = 0; i < board.length; i++) {
    for(int j = 0; j < board[].length; j++) {
    if
    }} 
   if() {
  } else if() 
    } else if(){
      for(int x = 0; x < board.length; x++){ //rows
        for(int y = 0; y < board[0].length; y ++){ //collums
    }}}// end of the 3 random point if statement
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
