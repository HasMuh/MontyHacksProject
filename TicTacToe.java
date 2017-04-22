import java.util.*;

public class TicTacToe {
  // Variables ----------------------------------------------------------------
  private int rows, cols;
  private String[][] board = new String[rows][cols];
  private boolean game = false;
  private Scanner in = new Scanner(System.in);
 
  public TicTacToe(){ // when called it starts a new game
    game = true;
  }  
  //AI ------------------------------------------------------------------------
  public void AiMove(){
   //if() 
  }
  //Player methods ------------------------------------------------------------
  public void setBoard(int r, int c){ //Sets the size of the board
   rows = r;
   cols = c;
  }
   public void mark(int r, int c){ //Marks a certain spot. PLAYERS ARE Os
	   if(board[r][c].equals("X") || board[r][c].equals("O"))
	   {
		   System.out.println("Illegal Move, try again");
		   System.out.print("Enter row: ");
		   int rNew = in.nextInt();
		   System.out.print("Enter column: ");
		   int cNew = in.nextInt();
		   mark(rNew,cNew);
	   }
	   board[r][c] = "O";   
  }
  
  public static void main(String[] args) {
  int x;    
  }
}
