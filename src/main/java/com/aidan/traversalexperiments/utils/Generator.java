package com.aidan.traversalexperiments.utils;

import java.util.List;
import java.util.Random;

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
	    List<Node> nodes = tree.getNodes();
	    for(int i = 0; i < nodes.size()-1; i++) {
	    	Node curr = nodes.get(i);
	    	tree.addEdge(curr, nodes.get(i+1));
	    	// add second child if available
	    	if(i+2 < nodes.size()) {
	    		tree.addEdge(curr, nodes.get(i+2));
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
	    	for(int j = i+2; j < nodes.size()-1; j++) {
		    	if(rand.nextInt(2) == 1) {
		    		cGraph.addEdge(nodes.get(i), nodes.get(j));
		    	}
	    	}
	    } 
		return cGraph;
	}

}