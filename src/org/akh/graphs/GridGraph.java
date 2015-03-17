package org.akh.graphs;

import java.util.HashMap;

public class GridGraph {

	public int N;
	private HashMap<Integer, GVertex> graph;

	public GridGraph(String[][] grid, int n) {
		this.N = n;
		graph = new HashMap<Integer, GVertex>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				GVertex vertex = getOrCreateVertex(grid, i, j);

				// previous in both directions vertexes are definitely already
				// created
				if (i > 0)
					vertex.getAdjList().add(graph.get(N * (i - 1) + j));

				if (j > 0)
					vertex.getAdjList().add(graph.get(N * i + j - 1));

				if (i < N - 1) {
					GVertex newVertex = getOrCreateVertex(grid, i + 1, j);
					vertex.getAdjList().add(newVertex);
				}

				if (j < N - 1) {
					GVertex newVertex = getOrCreateVertex(grid, i, j + 1);
					vertex.getAdjList().add(newVertex);
				}

			}

		}

	}

	private GVertex getOrCreateVertex(String[][] grid, int i, int j) {
		int number = N * i + j;
		GVertex vertex = graph.get(number);
		if (vertex == null) {
			vertex = new GVertex(number, grid[i][j]);
			graph.put(number, vertex);
		}

		return vertex;
	}

	public boolean containsWord(String word) {

		boolean result = false;
		for (int i = 0; (i < N * N) && !result; i++) {
			GVertex startVertex = graph.get(i);
			if (!startVertex.getValue().equals(String.valueOf(word.charAt(0))))
				continue;

			result = visit(startVertex, word, 1);

		}

		return result;
	}

	protected boolean visit(GVertex vertex, String word, int level) {
		// exceeding method call, result be defined in the previous invocation
		if (level == word.length())
			return true;

		for (GVertex adjVertex : vertex.getAdjList()) {
			if (adjVertex.getValue().equals(String.valueOf(word.charAt(level))))
				return visit(adjVertex, word, level + 1);

		}
		return false;
	}

	public static void main(String[] args) {
		String[][] grid = new String[4][];

		grid[0] = new String[] { "A", "D", "I", "T" };
		grid[1] = new String[] { "L", "O", "G", "Q" };
		grid[2] = new String[] { "H", "E", "L", "R" };
		grid[3] = new String[] { "M", "O", "L", "S" };

		GridGraph gridGraph = new GridGraph(grid, 4);

		System.out.println(gridGraph.containsWord("OGLEOGI"));
		System.out.println(gridGraph.containsWord("OGLEOGI"));
		System.out.println(gridGraph.containsWord("HELLO"));
		System.out.println(gridGraph.containsWord("DOG"));
		System.out.println(gridGraph.containsWord("HAT"));

	}

}
