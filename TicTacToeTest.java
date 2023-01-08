class TicTacToeTest
{
	public static void main(String[]args)
	{
		TicTacToeSpace[][] board1 = {	{new TicTacToeSpace(1),new TicTacToeSpace(1),new TicTacToeSpace(1)},
										{new TicTacToeSpace(2),new TicTacToeSpace(0),new TicTacToeSpace(2)},
										{new TicTacToeSpace(0),new TicTacToeSpace(0),new TicTacToeSpace(0)}};
		
		int[][] board2 = {	{2,1,0},
							{0,2,0},
							{1,1,2}};
							
		int[][] board3 = {	{2,1,2},
							{2,1,1},
							{1,2,1}};
		
		int[][] board4 = {	{8,0,1},
							{0,2,1},
							{0,2,1}};
							
							
		TicTacToeBoard b1 = new TicTacToeBoard();
		TicTacToeBoard b2 = new TicTacToeBoard(b1);

		System.out.println(b1.setSpace(0,0,1));
		System.out.println(b1.setSpace(0,1,1));
		System.out.println(b1.setSpace(0,2,1));
		System.out.println(b1.setSpace(0,4,1));
		System.out.println(b1.setSpace(1,1,4));
		
		System.out.println("\nb1:");
		System.out.println(b1);
		System.out.println("\nb2:");
		System.out.println(b2);

		TicTacToeBoard b3 = new TicTacToeBoard(board1);
		TicTacToeBoard b4 = new TicTacToeBoard(board2);
		
		System.out.println("\nb3:");
		System.out.println(b3);
		System.out.println("b3 isWin: " + b3.isWin());
		System.out.println("b3 isDraw: " + b3.isDraw());
		
		System.out.println("\nb4:");
		System.out.println(b4);
		System.out.println("b4 isWin: " + b4.isWin());
		System.out.println("b4 isDraw: " + b4.isDraw());
		
		TicTacToeBoard b5 = new TicTacToeBoard(board3);
		TicTacToeBoard b6 = new TicTacToeBoard(board4);
		
		System.out.println("\nb5:");
		System.out.println(b5);
		System.out.println("b5 isWin: " + b5.isWin());
		System.out.println("b5 isDraw: " + b5.isDraw());
		
		System.out.println("\nb6:");
		System.out.println(b6);
		System.out.println("b6 isWin: " + b6.isWin());
		System.out.println("b6 isDraw: " + b6.isDraw());
		
		
		
	}
}
