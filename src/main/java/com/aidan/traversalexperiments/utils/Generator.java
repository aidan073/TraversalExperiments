package com.aidan.traversalexperiments.utils;

import java.util.List;
import java.util.Random;
import java.util.Iterator;

import com.aidan.traversalexperiments.common.*;
import com.aidan.traversalexperiments.graph.Tree;
import com.aidan.traversalexperiments.graph.ConnectedGraph;

public class Generator {
	public static Tree generateBinaryRootedTree(int nodeCount) {
	    if(nodeCount <= 0){
	        throw new IllegalArgumentException("Node count must be positive.");
	    }
	    
	    // generate nodes
	    Tree tree = new Tree(true);
	    for(int i = 1; i <= nodeCount; i++) {
	    	tree.addNode(new Node(i));
	    }
	    
	    // generate edges
	    int childrenCount = 1; // track which node idx was connected last
	    List<Node> nodes = tree.getNodes();
	    for(int i = 0; childrenCount < nodes.size(); i++) {
	    	Node curr = nodes.get(i);
	    	tree.addEdge(curr, nodes.get(childrenCount));
	    	childrenCount++;
	    	// add second child if available
	    	if(childrenCount < nodes.size()) {
	    		tree.addEdge(curr, nodes.get(childrenCount));
	    		childrenCount++;
	    	}
	    }
	    return tree;
	}
	public static ConnectedGraph generateConnectedGraph(int nodeCount) {
	    if(nodeCount <= 0){
	        throw new IllegalArgumentException("Node count must be positive.");
	    }
	    
	    // generate nodes
	    ConnectedGraph cGraph = new ConnectedGraph();
	    for(int i = 1; i <= nodeCount; i++) {
	    	cGraph.addNode(new Node(i));
	    }
	    // generate edges
	    Random rand = new Random();
	    List<Node> nodes = cGraph.getNodes();
	    for(int i = 0; i < nodes.size()-2; i++) {
	    	cGraph.addEdge(nodes.get(i), nodes.get(i+1)); // add 1 edge for connectedness
	    	// randomly add more edges
	    	for(int j = i+2; j < nodes.size(); j++) {
		    	if(rand.nextInt(2) == 1 && !nodes.get(j).getNeighbors().contains(nodes.get(i))) { // gen edge if rand and doesn't already exist
		    		cGraph.addEdge(nodes.get(i), nodes.get(j));
		    	}
	    	}
	    }
	    // add connection from last node to first node (if doesn't exist) to ensure connectedness
	    if(!nodes.get(0).getNeighbors().contains(nodes.get(nodes.size()-1))) {
	    	cGraph.addEdge(nodes.get(0), nodes.get(nodes.size()-1));
	    }
		return cGraph;
	}

}