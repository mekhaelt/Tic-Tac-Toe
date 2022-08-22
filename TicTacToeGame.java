import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

final class TicTacToeGame extends JFrame implements ActionListener
{
	
	
	private TicTacToeBoard g1 = new TicTacToeBoard();
	
	 public int turns = 1;
	
	//Some possible states the game can be in.  Add or delete as needed
	private static final int STOPPED = 0;
	private static final int RUNNING = 1;
	
	//some colors to use
	private static final Color lightBlue = new Color(204,204,255);
	private static final Color lightYellow = new Color(255,255,204);
	
	//some of the UI components used 
	private JButton[][] spaces;
	private JTextField msgArea;
	private Font msgFont;
	private Font buttonFont;
	private JButton resetButton;
	private int state = STOPPED;
	
	//Panels used to create the layout
	private JPanel buttonPanel;
	private JPanel UiPanel;
	private JPanel spacePanel;
	private JPanel basePanel;
	
	
	//CONSTRUCTOR (used to initialize the GUI)
	public TicTacToeGame()
	{
		//init the JButtons for the 9 spaces using 3x3 array
		spaces = new JButton[3][3];
		
		//font uses for the spaces
		buttonFont = new Font("Arial",Font.BOLD,14);
		
		//create each of the 9 space buttons and add a listener
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				spaces[i][j] = new JButton("-");
				spaces[i][j].setFont(buttonFont);
				spaces[i][j].addActionListener(this);
			}
		}
		
		
		//create the message box and set properties
		msgFont = new Font("Arial",Font.BOLD,20);
		msgArea = new JTextField("Welcome to TIC TAC TOE!");
		msgArea.setFont(msgFont);
		msgArea.setBackground(lightBlue);
		msgArea.setMargin(new Insets(10,5,10,5));
		msgArea.setHorizontalAlignment(JTextField.CENTER);
		msgArea.setEditable(false);
		
		//create the start/reset button and set properties
		resetButton = new JButton("Start Game");
		resetButton.setFont(msgFont);
		resetButton.addActionListener(this);
		
		//create the base panel 2 rows 1 col
		basePanel = new JPanel();
		basePanel.setLayout(new GridLayout(2,1));
		basePanel.setPreferredSize(new Dimension(300,400));
		
		//panel for the start/reset button
		buttonPanel = new JPanel();
		buttonPanel.add(resetButton);
		buttonPanel.setBackground(lightYellow);
		
		//panel to combine the message box and start/reset button
		UiPanel = new JPanel();
		UiPanel.setLayout(new BorderLayout());
		
		//panel to hold the 9 space buttons
		spacePanel = new JPanel();
		spacePanel.setLayout(new GridLayout(3,3));
		spacePanel.setBackground(lightYellow);
		
		//add each of the 9 buttons to the spacePanel grid
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				spacePanel.add(spaces[i][j]);
			}
		}
		
		//add message area and buttonPanel to the UiPanel
		UiPanel.add(msgArea,BorderLayout.CENTER);
		UiPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		//add the upper UiPanel and lower spacePanel to the base grid
		basePanel.add(UiPanel);
		basePanel.add(spacePanel);
		
		//add base panel to the JFrame
		add(basePanel);
		
		//make JFrame visible and set properties
        setResizable(false);
        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	//This method must be used to implement the ActionListener interface
	public void actionPerformed(ActionEvent e)
	{
		//System.out.println(e);
		
		if(e.getSource() == resetButton)
		{
			if(state == STOPPED)
			{
				state = RUNNING;
				g1.clear();
				
				
				for(int row = 0; row < 3; row++)
				{
					for(int col = 0; col < 3; col++)
					{
						XO(row, col);
					}
				}
				startGame();
				System.out.println("Game Starting...");
			}
			else if(state == RUNNING)
			{
				state = STOPPED;
				stopGame();
				g1.clear();

				
				for(int row = 0; row < 3; row++)
				{
					for(int col = 0; col < 3; col++)
					{
						
						XO(row, col);
					}
				}
				
				
				System.out.println("Game Stopping...");
			}
		}
		else if(e.getSource() instanceof JButton)
		{
			if (state==RUNNING)
			{
			
				for(int i = 0; i < 3; i++)
				{
					for(int j = 0; j < 3; j++)
					{
						if(e.getSource() == spaces[i][j])
							spaceButtonPressed(i,j);
					}
				}
			}
		}
		
			
	}
	
	//code to start a new game
	private void startGame()
	{
		turns=1;
		resetButton.setText("Reset Game");
	}
	
	//code to clear current game and stop
	private void stopGame()
	{
		state=STOPPED;
		turns=1;
		resetButton.setText("Start Game");
	}
	
	//this method will be sent the row and col of the space that was pressed
	private void spaceButtonPressed(int row, int col)
	{
		if(turns==1 && g1.setSpace(row, col, turns)==true)
		{
			g1.setSpace(row, col, turns);
			XO(row, col);
			checkWX();
			checkD();
			turns++;
		}
		
		else if(turns==2 && g1.setSpace(row, col, turns)==true)
		{
			g1.setSpace(row, col, turns);
			XO(row, col);
			checkWO();
			checkD();
			turns--;
		}
	}
	
	//Sets X, O, - for game
	public void XO(int row, int col)
	{
		
		if(g1.getSpace(row, col).getValue() == 1)
			spaces[row][col].setText("X");
		
		if(g1.getSpace(row, col).getValue() == 2)
			spaces[row][col].setText("O");
			
		if(g1.getSpace(row, col).getValue() == 0)
			spaces[row][col].setText("-");
	}
	
	public void checkWX()
	{
		if(g1.isWin() == true)
		{
			msgArea.setText("X WINS");
			stopGame();
		}
	}
	
	public void checkWO()
	{
		if(g1.isWin() == true)
		{
			msgArea.setText("O WINS");
			stopGame();
		}
	}
	
	public void checkD()
	{
		if(g1.isDraw() == true)
		{
			msgArea.setText("DRAW");
			stopGame();
		}
	}
	
	//start program by creating the frame
	public static void main(String[] args)
	{
		TicTacToeGame sample = new TicTacToeGame();
	}
	
}
