package net.mahtabalam.coloring2;

import java.util.Arrays;

public class GraphColoring {
	
	private int[][] adjacencyMatrix;
	private int numOfVertices;
	
	private int numOfColors;
	private int[] colors;
	
	
	public GraphColoring(int[][] adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
		this.numOfVertices = adjacencyMatrix.length;
		this.colors = new int[numOfVertices];
	}

	public void setNumberOfColors(int numOfColors) {
		this.numOfColors = numOfColors;
	}

	public boolean solveVertexColoring() {
		if(	colorVertex(0) ) {
			printVertexColoring();
			return true;
		} else {
			System.out.println("Not possible to color entire graph with just "+ this.numOfColors + " color");
			return false;
		} 
	}

	public boolean colorVertex(int vertexIndex) {
		//Base case : If we were able to color all the vertices, it means we got our solution
		if (vertexIndex == numOfVertices) {
			return true;
		}

		//try all colors, starting from first color
		for (int colorIndex = 1; colorIndex <= numOfColors; colorIndex++) {
			
			//try to assign the color to the node
			if (isColorValid(vertexIndex, colorIndex)) {
				//If color is valid, assign that color to the vertex
				colors[vertexIndex] = colorIndex;
				System.out.println("Assigned color "+colorIndex+" to vertex "+vertexIndex);
				// Color the next Vertex
				if( colorVertex(vertexIndex + 1) ) {
					return true;
				}
				// !!! Backtrack	
				colors[vertexIndex] = 0;
				System.out.println("Backtracking for vertex "+vertexIndex+"-"+Arrays.toString(colors));
			}
		}
		
		//return false, as it was not feasible to color the vertex using any of the colors
		return false;
	}

	public boolean isColorValid(int vertexIndex, int colorIndex) {
		for (int i = 0; i < numOfVertices; i++) {
			//if the adjacent vertex has the same color then return false
			if (adjacencyMatrix[vertexIndex][i] == 1 && colors[i] == colorIndex) {
				return false;
			}
		}
		return true;
	}

	public void printVertexColoring() {
		for (int i = 0; i < numOfVertices; i++)
			System.out.println("Vertex " + (i) + " has color : " + colors[i] + " ");
		System.out.println();

	}
}
