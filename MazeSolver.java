// import libraries
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MazeSolver {
	
	// private class variables
	private Stack<Node> stack;
	private char[][] maze;
	private int eggFound;
	private int mHeight;
	private int mWidth;
	
	// constructor for instantiation
	public MazeSolver()
	{
		stack = new Stack<Node>();
		eggFound = 0;
	}
	
	// method that implements the depthFirstSearch traversal of the maze
	public void depthFirstSearch()
	{
		int h;
		int w;
		int h_orig;
		int w_orig;
		Node temp = new Node(0,0);
		stack.push(temp);
		
		// check while condition
		while (!stack.isEmpty())
		{	
			temp = stack.pop();
			h_orig = temp.getY();
			w_orig = temp.getX();
			
			// check if egg is there
			if (maze[h_orig][w_orig] == 'E')
				eggFound++;
			// mark it as visited
			maze[h_orig][w_orig] = 'x';
			
			// nodes to the south
			h = h_orig + 1;
			w = w_orig;
			
			// check if it is a legal location in the maze
			if (h < mHeight && w < mWidth && h >= 0 && w >= 0)
			{
				if (maze[h][w] == '.' || maze[h][w] == 'E')
				{
					// add to stack if criteria is met
					temp = new Node(w, h);
					stack.push(temp);
				}
			}
				
			
			// nodes to the north
			h = h_orig - 1;
			w = w_orig;
			
			// check if it is a legal location in the maze
			if (h < mHeight && w < mWidth && h >= 0 && w >= 0)
			{
				if (maze[h][w] == '.' || maze[h][w] == 'E')
				{
					// add to stack if criteria is met
					temp = new Node(w, h);
					stack.push(temp);
				}
			}
			
			// nodes to the west
			h = h_orig;
			w = w_orig - 1;
			
			// check if it is a legal location in the maze
			if (h < mHeight && w < mWidth && h >= 0 && w >= 0)
			{
				if (maze[h][w] == '.' || maze[h][w] == 'E')
				{
					// add to stack if criteria is met
					temp = new Node(w, h);
					stack.push(temp);
				}
			}
			
			// nodes to the east
			h = h_orig;
			w = w_orig + 1;
			
			// check if it is a legal location in the maze
			if (h < mHeight && w < mWidth && h >= 0 && w >= 0)
			{
				if (maze[h][w] == '.' || maze[h][w] == 'E')
				{
					// add to stack if criteria is met
					temp = new Node(w, h);
					stack.push(temp);
				}
			}
		}
		
	}
	
	// accessor/getter method
	public int getEggFound()
	{
		return this.eggFound;
	}
	
	// method to print the maze
	public void printMaze()
	{
		// iterate over the maze and print
		for (int i = 0; i < mHeight; i++)
		{
			for (int j = 0; j < mWidth; j++)
			{
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void readMaze() {

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Height of the maze: ");
			String line = reader.readLine();
			mHeight = Integer.parseInt(line);

			System.out.println("Width of the maze: ");
			line = reader.readLine();
			mWidth = Integer.parseInt(line);
			maze = new char[mHeight][mWidth];

			for (int i = 0; i < mHeight; i++) {
				line = reader.readLine();
				for (int j = 0; j < mWidth; j++) {
					maze[i][j] = line.charAt(j);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
