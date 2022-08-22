
public class TicTacToeBoard
{
	private TicTacToeSpace[][] spaces;
	
	 public TicTacToeBoard()
	 {
		 spaces= new TicTacToeSpace [3][3];
		 
		 for (int row=0; row<spaces.length; row++)
		 {
			 
			 for (int col=0; col<spaces[row].length; col++)
			 {
				 spaces[row][col]=new TicTacToeSpace();
			 }
		 }
	 }
	 
	 public TicTacToeBoard(int[][] board)
	 {
		 
		 spaces = new TicTacToeSpace[3][3];
		
		for(int row = 0; row < spaces.length; row++)
		{
			for(int col = 0; col < spaces[row].length; col++)
			{
				this.spaces[row][col] = new TicTacToeSpace();
			}
		}
		 
		 boolean noError=errorCheck(board); 
		 
		 if(noError==true)
		 {
			 spaces= new TicTacToeSpace [board.length][board[0].length];
		
			 for (int row=0; row<spaces.length; row++)
			 {
				 
				 for (int col=0; col<spaces[row].length; col++)
				 {
					spaces[row][col]=new TicTacToeSpace(board[row][col]);
				 }
			 }
		}
	 }
	 
	 public TicTacToeBoard(TicTacToeSpace[][] board)
	 {
		 spaces = new TicTacToeSpace[3][3];
		
		for(int row = 0; row < spaces.length; row++)
		{
			for(int col = 0; col < spaces[row].length; col++)
			{
				this.spaces[row][col] = new TicTacToeSpace();
			}
		}
		 
		 boolean noError=errorCheck(board); 
		 
		 if(noError==true)
			spaces=board;
	 }
	 
	 public TicTacToeBoard(TicTacToeBoard board)
	 {
		 spaces = new TicTacToeSpace[3][3];
		
		for(int row = 0; row < spaces.length; row++)
		{
			for(int col = 0; col < spaces[row].length; col++)
			{
				this.spaces[row][col] = new TicTacToeSpace();
			}
		}
		 
		boolean noError=errorCheck(board); 
		 
		 if(noError==true)
		 {
			 spaces= new TicTacToeSpace [3][3];
			 
			 for (int row=0; row<spaces.length; row++)
			 {
				 
				 for (int col=0; col<spaces[row].length; col++)
				 {
					 this.spaces[row][col]=board.spaces[row][col];
				 }
			 }
		}
	 }
	 
	 public boolean isWin()
	 {
		for (int i=0; i<3;i++)
		{
				if(spaces[i][0].getValue()>0 && spaces[i][0].getValue()==spaces[i][1].getValue() && spaces[i][0].getValue()==spaces[i][2].getValue())
					return true;
				else if(spaces[0][i].getValue()>0 && spaces[0][i].getValue()==spaces[1][i].getValue() && spaces[0][i].getValue()==spaces[2][i].getValue())
					return true;
				else if(spaces[0][0].getValue()>0 && spaces[0][0].getValue()==spaces[1][1].getValue() && spaces[0][0].getValue()==spaces[2][2].getValue())
					return true;
				else if(spaces[0][2].getValue()>0 && spaces[0][2].getValue()==spaces[1][1].getValue() && spaces[0][2].getValue()==spaces[2][0].getValue())
					return true;
		}
		return false;
	 }
	 
	 
	 	 
	 public boolean isDraw()
	 {
		if (this.isWin()==true)
			return false;
		if (this.isWin()==false)
		{
			for (int row=0; row<spaces.length; row++)
		 {
			 
			 for (int col=0; col<spaces[row].length; col++)
			 {
				 if (this.spaces[row][col].getValue()==TicTacToeSpace.BLANK)
					return false;
			 }
		 }
		}
			
		return true;
	 }
	 
	  public TicTacToeSpace getSpace(int row, int col)
	  {
		 boolean noError=errorCheck(row, col);
		 if (noError==true)
			return spaces[row][col];
			
		return new TicTacToeSpace();
	  }
	  
	  public boolean setSpace(int row, int col, int value)
	  {
	
		if (row>=0 && row<3 && col>=0 && col<3 && value>=0 && value<3)
			{
				if(spaces[row][col].getValue()==0)
				{
					spaces[row][col]= new TicTacToeSpace(value);
					return true;
				}
				else
					return false;
			}
		else 
			return false;
	  }
	  
	  public void clear()
	  {
		 for (int row=0; row<spaces.length; row++)
		 {
			 for (int col=0; col<spaces[row].length; col++)
			 {
				spaces[row][col]=new TicTacToeSpace(0);
			 }
		 }
		  
	  }

	@Override
	public String toString()
	{
		String temp = "";
		temp+="   0 1 2\n";
		temp+="0 |";
		
		
		for (int i=0; i<3;i++)
		{
			temp += spaces[0][i] + "|";
			
		}
		
		temp+="\n";
		temp+="1 |";
		
		for (int i=0; i<3;i++)
		{
				
			temp += spaces[1][i] + "|";
			
		}
		
		temp+="\n";
		temp+="2 |";
		
		for (int i=0; i<3;i++)
		{
				
			temp += spaces[2][i] + "|";
			
		}
		
		return temp;
	}
	
	public boolean errorCheck(int[][] board)
	{
		if (board.length!=3 || board[0].length!=3)
		{
			return false;
		}
		for (int row=0; row<board.length; row++)
			 {
				 
			 for (int col=0; col<board[row].length; col++)
			 {
				if (board[row][col]<0)
				return false;
				
				else if (board[row][col]>2)
					return false;
			 }
		 }
	
		
		return true;
	}
	
	
	public boolean errorCheck(TicTacToeSpace[][] board)
	{
		if (board.length!=3 || board[0].length!=3)
		{
			return false;
		}
		for (int row=0; row<board.length; row++)
			 {
				 
			 for (int col=0; col<board[row].length; col++)
			 {
				if (board[row][col].getValue()<0)
				return false;
				
				else if (board[row][col].getValue()>2)
					return false;
			 }
		 }
		
		return true;
	}
	
	
		public boolean errorCheck(TicTacToeBoard board)
	{
		
		if (board.spaces.length!=3 || board.spaces[0].length!=3)
		{
			return false;
		}
		
		for(int row = 0; row < board.spaces.length; row++)
		{
			for(int col = 0; col < board.spaces[row].length; col++)
			{
				if (board.spaces[row][col].getValue()<0)
				return false;
				
				else if (board.spaces[row][col].getValue()>2)
					return false;
			}
		}
		
		return true;
	}
	
	public boolean errorCheck(int row, int col)
	{
		
		if (row>=0 && row<3 && col>=0 && col<3)
		{
			return true;
		}
		
		
		return false;
	}
	
}

