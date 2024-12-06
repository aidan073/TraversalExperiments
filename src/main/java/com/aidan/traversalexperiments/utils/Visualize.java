package com.aidan.traversalexperiments.utils;

import java.util.Map;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

import com.aidan.traversalexperiments.common.Node;
import com.aidan.traversalexperiments.graph.AdjacencyMatrix;

public class Visualize {
	// convert an adjacency matrix to SingleGraph
	public static Graph toSingleGraph(AdjacencyMatrix aM, String graphName) {
		Graph graph = new SingleGraph(graphName);
		boolean[][] adjacencyMatrix = aM.getMatrix();
		Map<Integer, Node> idMap = aM.getIdMap();

	    // add nodes
	    for (int i = 0; i < adjacencyMatrix.length; i++) {
	        graph.addNode(String.valueOf(idMap.get(i).getId()));
	    }

	    // add edges
	    for (int i = 0; i < adjacencyMatrix.length; i++) {
	        for (int j = i + 1; j < adjacencyMatrix[i].length; j++) {
	            if (adjacencyMatrix[i][j] == true) {
	                graph.addEdge(idMap.get(i).getId() + "-" + idMap.get(j).getId(), String.valueOf(idMap.get(i).getId()), String.valueOf(idMap.get(j).getId()));
	            }
	        }
	    }
	    return graph;
	}
	public static void displayGraph(Graph graph) {	  
		System.setProperty("org.graphstream.ui", "swing");
	    graph.setAttribute("ui.stylesheet", "node {fill-color: grey; size: 20px;} node.visited {fill-color: red;}");
	    graph.display();
	}
}
