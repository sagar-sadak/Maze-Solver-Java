public class Main {
	// main method
	public static void main(String[] args) {
		// read user Maze
		MazeSolver mazeSolver = new MazeSolver();
		mazeSolver.readMaze();

		// Maze read from the user
		System.out.println("Original maze: ");
		mazeSolver.printMaze();

		// implement depthFirstSearch on the maze
		mazeSolver.depthFirstSearch();

		// Maze after traversal
		System.out.println("Maze after Easter Bunny traverse: ");
		mazeSolver.printMaze();

		// print statement based on eggs found or not
		if (mazeSolver.getEggFound() == 0)
			System.out.println("The Bunny was unable to recover the eggs, Easter is cancelled!");
		else
			System.out.println("The Easter Bunny found " + mazeSolver.getEggFound() + " egg(s)!");
	}
}