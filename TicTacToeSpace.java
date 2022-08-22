
public class TicTacToeSpace
{
	private int value;
	public static final int BLANK = 0;
	public static final int X = 1;
	public static final int O = 2;
	
	public TicTacToeSpace()
	{
		value=BLANK;
	}
	
	public TicTacToeSpace(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void setValue(int value)
	{
		this.value=value;
	}
	
	public String toString()
	{
		String spot="";
		if (value==O)
		{
			spot="O";
			return spot;
		}
		else if (value==X)
		{
			spot="X";
			return spot;
		}
		else
		{
			spot="-";
			return spot;
		}
	}
}
