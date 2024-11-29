package com.aidan.traversalexperiments.graph;

import java.util.ArrayList;
import java.util.List;

import com.aidan.traversalexperiments.common.Edge;
import com.aidan.traversalexperiments.common.Node;

public class ConnectedGraph extends Graph{
	private boolean directed;

	public ConnectedGraph(boolean directed) {
		this.directed = directed;
	}
	
	@Override
	public void addNode(Node node) {
		nodes.add(node);
	}
	
	@Override
	public void addEdge(Node fromNode, Node toNode) {
		fromNode.addEdge(new Edge(fromNode, toNode));
		if(!directed) {
			toNode.addEdge(new Edge(toNode, fromNode));	
		}
	}

	@Override
	public boolean containsNode(Node node) {
		return nodes.contains(node);
	}
	
	@Override
	public AdjacencyMatrix toAdjacencyMatrix() {
		AdjacencyMatrix aMatrix = new AdjacencyMatrix(nodes.size());
		for(Node node : nodes) {
			aMatrix.addNode(node);
			for(Node neighbor : node.getNeighbors()) {
				aMatrix.addEdge(node, neighbor, directed);
			}
		}
		return aMatrix;
	}

}
