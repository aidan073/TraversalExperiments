package com.aidan.traversalexperiments.graph;

import java.util.List;

import com.aidan.traversalexperiments.common.Edge;
import com.aidan.traversalexperiments.common.Node;

public class ConnectedGraph extends Graph{
	private boolean directed = false;
	
	public ConnectedGraph() {
		super();
	}

	public ConnectedGraph(boolean directed) {
		super();
		this.directed = directed;
	}
	
	@Override
	public void addNode(Node node) {
		nodes.add(node);
	}
	
	@Override
	public void addEdge(Node fromNode, Node toNode) {
		fromNode.addEdge(new Edge(fromNode, toNode));
		if(!this.directed) {
			toNode.addEdge(new Edge(toNode, fromNode));	
		}
	}

	@Override
	public boolean containsNode(Node node) {
		return nodes.contains(node);
	}
	
	@Override
	public AdjacencyMatrix toAdjacencyMatrix() {
	    AdjacencyMatrix adjMatrix = new AdjacencyMatrix(getNodes().size());

	    // add nodes
	    for (Node node : getNodes()) {
	        adjMatrix.addNode(node);
	    }

	    // add edges
	    for (Node node : getNodes()) {
	        for (Node neighbor : node.getNeighbors()) {
	            adjMatrix.addEdge(node, neighbor, this.directed);
	        }
	    }
	    return adjMatrix;
	}
	
    public List<Node> getNodes() {
        return nodes;
    }

}
