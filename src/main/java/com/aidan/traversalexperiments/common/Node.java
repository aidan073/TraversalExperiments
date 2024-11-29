package com.aidan.traversalexperiments.common;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String id; 
    private List<Edge> edges; // edges connected to this node
    private List<Node> neighbors; // neighbors of this node (connected by edge)
    
    public Node(String id) {
        this.id = id;
        this.edges = new ArrayList<>();
        this.neighbors = new ArrayList<>();
        }
    
    public String getId() {
        return id;
    }
    
    public void addEdge(Edge edge) {
        edges.add(edge);
        neighbors.add(edge.getToNode());
    }
    
    public List<Edge> getEdges(){
    	return edges;
    }
    
    public List<Node> getNeighbors(){
    	return neighbors;
    }
}
