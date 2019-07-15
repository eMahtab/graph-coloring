package net.mahtabalam.coloring2;

public class App {

	public static void main(String[] args) {

		int[][] adjacencyMatrix = new int[][] { 
			{ 0, 1, 0, 1, 0 }, 
			{ 1, 0, 1, 1, 0 }, 
			{ 0, 1, 0, 1, 0 }, 
			{ 1, 1, 1, 0, 1 },
			{ 0, 0, 0, 1, 0 } };
			
		GraphColoring graphColoring = new GraphColoring(adjacencyMatrix);
		
		for (int numOfColors = 1; numOfColors < adjacencyMatrix.length; numOfColors++) {
			graphColoring.setNumberOfColors(numOfColors);
			if(graphColoring.solveVertexColoring()) {
				System.out.println("Chromatic Number of Graph is "+numOfColors);
				break;
			}
		}		
		
	}
}
