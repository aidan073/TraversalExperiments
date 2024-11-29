package com.aidan.traversalexperiments.graph;

import java.util.List;

import com.aidan.traversalexperiments.common.Edge;
import com.aidan.traversalexperiments.common.Node;

import java.util.ArrayList;

public class Tree extends Graph{

	@Override
	public void addNode(Node node) {
		nodes.add(node);
	}
	
	@Override
	public void addEdge(Node fromNode, Node toNode) {
		// add to both Nodes because undirected
		fromNode.addEdge(new Edge(fromNode, toNode));
		toNode.addEdge(new Edge(toNode, fromNode));
	}

	@Override
	public boolean containsNode(Node node) {
		return nodes.contains(node);
	}
	
	@Override
	public AdjacencyMatrix toAdjacencyMatrix() {
		// TODO Auto-generated method stub
		return null;
	}
	// ensure graph is still a tree after changing structure
//	public boolean ensureTree() {
//		return false;
//	}
}
