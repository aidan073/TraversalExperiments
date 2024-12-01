package com.aidan.traversalexperiments.utils;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

import com.aidan.traversalexperiments.graph.AdjacencyMatrix;

public class Visualize {
	public static void displayGraph(AdjacencyMatrix aM) {
	    Graph graph = new SingleGraph("Graph Visualization");
	    boolean[][] adjacencyMatrix = aM.getMatrix();

	    // add nodes
	    for (int i = 0; i < adjacencyMatrix.length; i++) {
	        graph.addNode(String.valueOf(i));
	    }

	    // add edges
	    for (int i = 0; i < adjacencyMatrix.length; i++) {
	        for (int j = i + 1; j < adjacencyMatrix[i].length; j++) {
	            if (adjacencyMatrix[i][j] == true) {
	                graph.addEdge(i + "-" + j, String.valueOf(i), String.valueOf(j));
	            }
	        }
	    }
	    System.setProperty("org.graphstream.ui", "swing"); 
	    graph.display();
	}
}
