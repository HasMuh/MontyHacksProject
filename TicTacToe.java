import java.util.*;

public class TicTacToe {
	public static void main(String[] args) {
  int rows = 0, columns = 0;
		boolean a = false;
  TicTacToe b = new TicTacToe();
  Scanner in = new Scanner(System.in);
  System.out.println("Tic Tac Toe:");
  while(!a){
	b.print();
		System.out.print("Enter a row (rows go from 1-3): ");
		int r = in.nextInt() - 1;
		System.out.print("Enter a column (columns go from 1-3): ");
		int c = in.nextInt() - 1;
		b.mark(r,c);
		b.AIvCheck();
		if(b.getaiMove()== false){
		b.AIhCheck();
		}
		if(b.getaiMove()== false){
		b.AIdCheck();
		}
		if(b.getaiMove()== false){
		b.AiMove();	
		}
		b.vCheck();
		b.hCheck();
		b.dCheck();
		if(b.getaiWin() || b.getPlayerWin() || b.countEmpt() == 0){
		a = true;	
		}
		b.sendMessage();
	}
  b.print();
  if(b.getaiWin())
  {
	  System.out.println("The computer wins");
  }
  else if(b.getPlayerWin())
  {
	  System.out.println("You win!");
	  System.out.println("YOU CHEATER, YOU USED A HACK TO WIN!");
  }
  else
  {
	  System.out.println("It's a tie!");
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
  private int messageNum;
 
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
    p1 = new int[2];
    p2 = new int[2];
    p3 = new int[2];
  }  
  public int countEmpt(){ // counts the empty spaces left on the board
    int spaces = 0;
    for(int x = 0; x < board.length; x++){ //rows
        for(int y = 0; y < board[0].length; y ++){ //columns
          if(board[x][y].equals(" ")){
           spaces ++; 
          }
    }
    }
        return spaces;
    
   }
   public String[][] getBoard(){
	return board;
   }
   public boolean getaiWin(){
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
	  	if((board[0][0].equals("O") && board[2][2].equals("O")) && board[1][1].equals("O")) {
			aiWin = true;
			return true;	
		} else if((board[0][2].equals("O") && board[2][0].equals("O")) && board[1][1].equals("O")) {
			aiWin = true;
			return true;	
		}
	  	return false;
  }
  //AI ------------------------------------------------------------------------

    public void AIvCheck() {  // Makes a winning move if possible or blocks player if necessary
	  for(int c = 0; c < board[0].length; c++) {
		  if((board[0][c].equals("X") || board[2][c].equals("X")) && board[1][c].equals("X")) {
			  if(board[0][c].equals("X") && !board[2][0].equals("O")) //Winning Play
			  {
				  board[2][c] = "X";
				  aiMove = true;
			  }
			  else if(board[2][c].equals("X") && !board[2][0].equals("O"))
			  {
				  board[0][c] = "X";
				  aiMove = true;
			  }
		  }
		  if((board[0][c].equals("O") || board[2][c].equals("O")) && board[1][c].equals("O")) {
			  if(board[0][c].equals("O") && !board[2][0].equals("O")) //Block
			  {
				  board[2][c] = "X";
				  aiMove = true;
			  }
			  else if(board[2][c].equals("O") && !board[2][0].equals("O"))
			  {
				  board[0][c] = "X";
				  aiMove = true;
			  }
		  }
	  }
}
 
    public void AIhCheck(){ //Win/block function
	  for(int r = 0; r < board.length; r++)
	  {
		  if((board[r][0].equals("X") || board[r][2].equals("X")) && board[r][1].equals("X")) {
			  if(board[r][0].equals("X") && !board[2][0].equals("O"))
			  {
				  board[r][2] = "X";
				  aiMove = true;
			  }
			  else if(board[r][2].equals("X") && !board[2][0].equals("O"))
			  {
				  board[r][0] = "X";
				  aiMove = true;
			  }
		  }
		  if((board[r][0].equals("O") || board[r][2].equals("O")) && board[r][1].equals("O")) {
			  if(board[r][0].equals("O") && !board[2][0].equals("O"))
			  {
				  board[r][2] = "X";
				  aiMove = true;
			  }
			  else if(board[r][2].equals("O") && !board[2][0].equals("O"))
			  {
				  board[r][0] = "X";
				  aiMove = true;
			  }
		  }
	  }
  } 
  public void AIdCheck() {     
  		if((board[0][0].equals("X") || board[2][2].equals("X")) && board[1][1].equals("X")) {			
			if(board[0][0].equals("X") && !board[2][2].equals("O")) //Left-Right Win
			{
				board[2][2] = "X";
				aiMove = true;
			}
			else if(board[2][2].equals("X") && !board[0][0].equals("O"));
			{
				board[0][0] = "X";
				aiMove = true;
			}
		} 
  		else if((board[0][2].equals("X") || board[2][0].equals("X")) && board[1][1].equals("X")) {
			if(board[0][2].equals("X") && !board[2][0].equals("O")) //Right-Left Win
			{
				board[2][0] = "X";
				aiMove = true;
			}
			else if(board[2][0].equals("X") && !board[0][2].equals("O"))
			{
				board[0][2] = "X";
				aiMove = true;
			}	
		}
  		else if((board[0][0].equals("O") || board[2][2].equals("O")) && board[1][1].equals("O")) {
			aiMove = true;
			if(board[0][0].equals("O") && !board[2][0].equals("O")) //Left Right Block
			{
				board[2][2] = "X";
				aiMove = true;
			}
			else if(board[2][2].equals("O") && !board[2][0].equals("O"))
			{
				board[0][0] = "X";
				aiMove = true;
			}
		} 
  		else if((board[0][2].equals("O") || board[2][0].equals("O")) && board[1][1].equals("O")) {
			if(board[0][2].equals("O") && !board[2][0].equals("O")) //Right-Left Block
			{
				board[2][0] = "X";
				aiMove = true;
			}
			else if(board[2][0].equals("O") && !board[2][0].equals("O"))
			{
				board[0][2] = "X";
				aiMove = true;
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
	   int rNew = in.nextInt() - 1;
	   System.out.print("Enter column: ");
	   int cNew = in.nextInt() - 1;
	   legal = false;
	   mark(rNew,cNew);
	   
   }
   if(legal)
   {
   board[r][c] = "O";
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
public void sendMessage()
{
	if(messageNum == 0)
	{
		System.out.println("Bot: Is this your first time or something?");
		messageNum++;
	}
	else if(messageNum == 1)
	{
		System.out.println("Bot: I am unbeatable");
		messageNum++;
	}
	else if(messageNum == 2)
	{
		System.out.println("Bot: Is that all?");
		messageNum++;
	}
	else if(messageNum == 3)
	{
		System.out.println("Bot: Stop boring me");
		messageNum++;
	}
	else if(messageNum == 4)
	{
		System.out.println("Bot: Booooo!");
		messageNum++;
	}
	else if(messageNum == 5)
	{
		System.out.println("Bot: Now restarting conversation.exe");
		messageNum++;
	}
}
}
