import java.util.*;

public class TicTacToe {
	public static void main(String[] args) {
  int r = 0, c = 0;
		boolean a = false;
  TicTacToe b = new TicTacToe();
  Scanner in = new Scanner(System.in);
  
  System.out.println("Tic Tac Toe:");
  while(!a){
	b.print();
		System.out.print("Enter a row: ");
		int r = in.nextInt() - 1;
		System.out.print("Enter a column: ");
		int c = in.nextInt() - 1;
		b.mark(r,c);
		b.AIvCheck();
		b.AIhCheck();
		b.AIdCheck();
		if(b.getaiMove()== false){
		b.AiMove();	
		}
		b.vCheck();
		b.hCheck();
		b.dCheck();
		if(b.getaiWin() || b.getplayerWin()){
		a = true;	
		}
	}
	}
  // Variables ----------------------------------------------------------------
   private int rows, cols;
  private String[][] board;
  private boolean game;
  private boolean aiWin;
  private boolean playerWin;
  private boolean aiMove;
  private int[] p1;
  private int[] p2;
  private int[] p3;
  private Scanner in;
 
  public TicTacToe(){ // when called it starts a new game
    game = true;   
    board = new String[3][3];
    for(int r = 0; r < board.length; r++)
    {
    	for(int c = 0; c < board.length; c++)
    	{
    		board[r][c] = " ";
    	}
    }
    aiWin = false;
    playerWin = false;
    aiMove = false;
    in = new Scanner(System.in);
  }  
  public int countEmpt(){ // counts the empty spaces left on the board
    int spaces = 0;
    for(int x = 0; x < board.length; x++){ //rows
        for(int y = 0; y < board[0].length; y ++){ //collums
          if(board[x][y].equals(" ")){
           spaces ++; 
          }
    }}
	  return spaces;
   public int[][] getBoard(){
	return board;
   }
   public boolean getAIWin(){
	   return aiWin;
   }	
   public boolean getPlayerWin(){
	   return playerWin;
   }
   public boolean getaiMove(){
   return aiMove;
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
	int count = 0;
	for(int r = 0; r < board.length; r++)
	{
		for(int c = 0; c < board[0].length; c++)
		{
			if(!(board[r][c].equals("X") || board[r][c].equals("O")))
			{
				if(count == 0)
				{
					p1[0] = r;
					p1[1] = c;
					count++;
				}
				if(count == 1)
				{
					p2[0] = r;
					p2[1] = c;
					count++;
				}
				if(count == 2)
				{
					p3[0] = r;
					p3[1] = c;
					count++;
				}
			}
		}
	}
	int[][] points = {
			 {p1[0],p1[1]},
			 {p2[0],p2[1]},
			 {p3[0],p3[1]}
	};
	
   if(this.countEmpt() >= 3) {
	   board[points[choice][0]][points[choice][1]] = "X";
      } 
   else if(this.countEmpt() >= 2) { 
	   choice = n.nextInt(2);
	   board[points[choice][0]][points[choice][1]] = "X";
   	 } 
   else if(this.countEmpt() >= 1){
	   board[points[0][0]][points[0][1]] = "X";
      }// end of the 3 random point if statement
  }
  //Player methods ------------------------------------------------------------
  public void setBoard(int r, int c){ //Sets the size of the board
   rows = r;
   cols = c;
  }
   public void mark(int r, int c){ //Marks a certain spot. PLAYERS ARE Os
	boolean legal = true;   
   if(board[r][c].equals("X") || board[r][c].equals("O"))
   {
	   System.out.println("Illegal Move, try again");
	   System.out.print("Enter row: ");
	   int rNew = in.nextInt();
	   System.out.print("Enter column: ");
	   int cNew = in.nextInt();
	   legal = false;
	   mark(rNew,cNew);
	   
   }
   if(legal)
   {
   board[r][c] = "O";
   }
  }
}

public void print()
  {
	  for(int r = 0; r < board.length; r++)
	  {
		  for(int c = 0; c < board[0].length; c++)
		  {
			  System.out.print(board[r][c]);
			  if(c != board[0].length - 1)
			  {
				  System.out.print(" |");
			  }
		  }
		  System.out.println();
	  }
  }
