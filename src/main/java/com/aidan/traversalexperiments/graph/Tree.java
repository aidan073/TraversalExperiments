package com.aidan.traversalexperiments.graph;

import java.util.List;

import com.aidan.traversalexperiments.common.Edge;
import com.aidan.traversalexperiments.common.Node;

public class Tree extends Graph{
	private boolean rooted = false;
	
	public Tree() {
		super();
	}
	
    public Tree(boolean rooted) {
        super();
        this.rooted = rooted;
    }

	@Override
	public void addNode(Node node) {
		nodes.add(node);
	}
	
	@Override
	public void addEdge(Node fromNode, Node toNode) {
		fromNode.addEdge(new Edge(fromNode, toNode));
		if(!this.rooted) {
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
	            adjMatrix.addEdge(node, neighbor, this.rooted);
	        }
	    }
	    return adjMatrix;
	}
	
    public List<Node> getNodes() {
        return nodes;
    }
	// ensure graph is still a tree after changing structure
//	public boolean ensureTree() {
//		return false;
//	}
}
