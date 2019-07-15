package net.mahtabalam.coloring1;

public class App {

	public static void main(String[] args) {
		
		int[][] adjacencyMatrix = new int[][] { 
			{ 0, 1, 0, 1, 0 }, 
			{ 1, 0, 1, 1, 0 }, 
			{ 0, 1, 0, 1, 0 }, 
			{ 1, 1, 1, 0, 1 },
			{ 0, 0, 0, 1, 0 } };

		GraphColoring graphColoring = new GraphColoring(adjacencyMatrix);
		graphColoring.setNumberOfColors(3);
		graphColoring.solveVertexColoring();
	}
}
