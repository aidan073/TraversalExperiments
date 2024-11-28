package com.aidan.traversalexperiments.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String id; 
    private List<Edge> edges; // edges connected to this node
    
    public Node(String id) {
        this.id = id;
        this.edges = new ArrayList<>();
    }
    
    public String getId() {
        return id;
    }
    
    public void addEdge(Edge edge) {
        edges.add(edge);
    }
}
