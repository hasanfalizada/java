package devjava;

import java.util.ArrayList;
import java.util.List;

public class LatticePaths {

	static class Graph {
		int X;

		int Y;

		Graph(int X, int Y) {
			this.X = X;
			this.Y = Y;
		}

		public int getX() {
			return X;
		}

		public int getY() {
			return Y;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.X + "" + this.Y;
		}

	}

	static final int GRID_SIZE_X = 20;
	static final int GRID_SIZE_Y = 20;
	static long counter = 0;

	static void printPaths(Graph startingGraph, List<Graph> path) {

		path.add(startingGraph);

		if (startingGraph.getX() + 1 > GRID_SIZE_Y && startingGraph.getY() + 1 > GRID_SIZE_Y) {
			System.out.println(path.toString());
			counter++;
			return;
		}

		if (startingGraph.getX() + 1 <= GRID_SIZE_X) {
			printPaths(new Graph(startingGraph.getX() + 1, startingGraph.getY()), new ArrayList<>(path));
		}

		if (startingGraph.getY() + 1 <= GRID_SIZE_Y) {
			printPaths(new Graph(startingGraph.getX(), startingGraph.getY() + 1), new ArrayList<>(path));
		}
	}

	static void countPaths(int X, int Y) {

		if (X + 1 > GRID_SIZE_X && Y + 1 > GRID_SIZE_Y) {
			counter++;
			return;
		}

		if (X + 1 <= GRID_SIZE_X) {
			countPaths(X + 1, Y);
		}

		if (Y + 1 <= GRID_SIZE_Y) {
			countPaths(X, Y + 1);
		}
	}

	static void countPathsDP() {

		final int NUMBER = 20;

		final long[][] grid = new long[NUMBER + 1][NUMBER + 1];

		grid[0][0] = 0;

		for (int i = 1; i <= NUMBER; i++) {
			grid[i][0] = 1;
			grid[0][i] = 1;
		}

		for (int i = 1; i <= NUMBER; i++) {
			for (int j = 1; j <= i; j++) {
				grid[i][j] = grid[j][i] = grid[j - 1][i] + grid[j][i - 1];
			}
		}

		System.out.println(grid[NUMBER][NUMBER]);

	}

	public static void main(String[] args) {
		Graph graph = new Graph(0, 0);
		List<Graph> path = new ArrayList<>();
		// printPaths(graph, path);
		// countPaths(0, 0);
		countPathsDP();
	}
}
