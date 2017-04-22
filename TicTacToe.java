import java.util.*;

public class TicTacToe {
  // Variables ----------------------------------------------------------------
  private int rows, cols;
  private String[][] board = new String[rows][cols];
  private boolean game = false;
  private boolean aiWin = false;
  private boolean playerWin = false;
  private boolean aiMove = false;
  private int[] p1 = {0,0};
  private int[] p2 = {0,0};
  private int[] p3 = {0,0};
 
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
	  return spaces;
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
	  	if((board[0][0].equals("X") && board[2][2].equals("X")) && board[1][1].equals("X")) {
			aiWin = true;
			return true;	
		} else if((board[0][2].equals("X") && board[2][0].equals("X")) && board[1][1].equals("X")) {
			aiWin = true;
			return true;	
		}
  }
  //AI ------------------------------------------------------------------------

    public void AIvCheck() {  // Makes a winning move if possible or blocks player if necessary
	  for(int c = 0; c < board[0].length; c++) {
		  if((board[0][c].equals("X") || board[2][c].equals("X")) && board[1][c].equals("X")) {
			  aiMove = true;
			  if(board[0][c].equals("X")) //Winning Play
			  {
				  board[2][c] = "X";
			  }
			  else
			  {
				  board[0][c] = "X";
			  }
		  }
		  if((board[0][c].equals("O") || board[2][c].equals("O")) && board[1][c].equals("O")) {
			  aiMove = true;
			  if(board[0][c].equals("O")) //Block
			  {
				  board[2][c] = "X";
			  }
			  else
			  {
				  board[0][c] = "X";
			  }
		  }
	  }
}
 
    public void AIhCheck(){ //Win/block function
	  for(int r = 0; r < board.length; r++)
	  {
		  if((board[r][0].equals("X") || board[r][2].equals("X")) && board[r][1].equals("X")) {
			  aiMove = true;
			  if(board[r][0].equals("X"))
			  {
				  board[r][2] = "X";
			  }
			  else
			  {
				  board[r][0] = "X";
			  }
		  }
		  if((board[r][0].equals("O") || board[r][2].equals("O")) && board[r][1].equals("O")) {
			  aiMove = true;
			  if(board[r][0].equals("O"))
			  {
				  board[r][2] = "X";
			  }
			  else
			  {
				  board[r][0] = "X";
			  }
		  }
	  }
  } 
  public void AIdCheck() {     
  		if((board[0][0].equals("X") || board[2][2].equals("X")) && board[1][1].equals("X")) {
			aiMove = true;
			if(board[0][0].equals("X")) //Left-Right Win
			{
				board[2][2] = "X";
			}
			else
			{
				board[0][0] = "X";
			}
		} 
  		else if((board[0][2].equals("X") || board[2][0].equals("X")) && board[1][1].equals("X")) {
			aiMove = true;
			if(board[0][2].equals("X")) //Right-Left Win
			{
				board[2][0] = "X";
			}
			else
			{
				board[0][2] = "X";
			}	
		}
  		else if((board[0][0].equals("O") || board[2][2].equals("O")) && board[1][1].equals("O")) {
			aiMove = true;
			if(board[0][0].equals("O")) //Left Right Block
			{
				board[2][2] = "X";
			}
			else
			{
				board[0][0] = "X";
			}
		} 
  		else if((board[0][2].equals("O") || board[2][0].equals("O")) && board[1][1].equals("O")) {
			aiWin = true;
			if(board[0][2].equals("O")) //Right-Left Block
			{
				board[2][0] = "X";
			}
			else
			{
				board[0][2] = "X";
			}	
		}
  }
public void AiMove(){ //AI will pick from 3 random points and choose where to go
	Random n = new Random();
	int choice = n.nextInt(3); // picks one of the random points to be used by ai
	int[][] points = {
			 {p1},
			 {p2},
			 {p3}
	};
	
   if(board.spaces >= 3) {
  	board[points[choice]] = "X";
      } e/lse if(board.spaces >= 2) { 
	   choice = n.nextInt(2);
	   board[points[choice]] = "X";
   	 } else if(board.spaces >= 1){
	   board[points[1]] = "X";
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
