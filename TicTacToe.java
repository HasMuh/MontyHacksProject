import java.util.*;

public class TicTacToe {
  // Variables ----------------------------------------------------------------
  private int rows, cols;
  private String[][] board = new String[rows][cols];
  private boolean game = false;
  private boolean aiWin = false;
  private boolean playerWin = false;
  private boolean aiMove = false;
 
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
   public boolean vCheck() {  // checks the board Vertically(row) for a win
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
  public boolean hCheck(){ // checks the board Horizontally(column) for a win
    
	  for(int r = 0; r < board.length; r++)
	  {
		  if(board[r][0].equals("X") && board[r][1].equals("X") && board[r][2].equals("X"))
		  {
			  aiWin = true;
			  return true;
		  }
		  else if(board[r][0].equals("O") && board[r][1].equals("O") && board[r][2].equals("O"))
		  {
			  playerWin = true; 
			  return true;
		  }
			  
	  }
 
	  return false;
  }
  public boolean dCheck() {  
	  	if((board[0][0].equals("X") || board[2][2].equals("X")) && board[1][1].equals("X")) {
			aiWin = true;
			return true;	
		} else if((board[0][2].equals("X") || board[2][0].equals("X")) && board[1][1].equals("X")) {
			aiWin = true;
			return true;	
		}
  }
  //AI ------------------------------------------------------------------------

   public boolean AIvCheck() {  // Makes a winning move if possible or blocks player if necessary
	  for(int c = 0; c < board[0].length; c++) {
		  if((board[0][c].equals("X") || board[2][c].equals("X")) && board[1][c].equals("X")) {
			  aiMove = true;
			  if(board[0][c].equals("X"))
			  {
				  board[2][c] = "X";
			  }
			  else
			  {
				  board[0][c] = "X";
			  }
		  }	  
	  }
	  return false;
  public boolean AIhCheck(){ // checks the board Horizontally(column)
	  for(int r = 0; r < board.length; r++)
	  {
		  if((board[r][0].equals("X") || board[r][2].equals("X")) && board[r][1].equals("X")) {
			  aiMove = true;
			  return true;
		  }
	  }
 
	  return false;
  }  
  public boolean AIdCheck() {     
  		if((board[0][0].equals("X") || board[2][2].equals("X")) && board[1][1].equals("X")) {
			aiWin = true;
			return true;	
		} else if((board[0][2].equals("X") || board[2][0].equals("X")) && board[1][1].equals("X")) {
			aiWin = true;
			return true;	
		}
  }
public void AiMove(){ //AI will pick from 3 random points and choose where to go
    int[] p1 = {0,0};
    int[] p2 = {0,0};
    int[] p3 = {0,0};
   if() {
  } else if() { 
    } else if(){
	
      }// end of the 3 random point if statement
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
