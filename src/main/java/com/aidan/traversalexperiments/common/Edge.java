package com.aidan.traversalexperiments.common;

public class Edge {
    private Node fromNode; // node edge comes from
    private Node toNode; // node edge leads into
    private int weight;
    
    public Edge(Node fromNode, Node toNode) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.weight = 0;
    }

    public Edge(Node fromNode, Node toNode, int weight) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.weight = weight;
    }

    public Node getFromNode() {
        return fromNode;
    }

    public Node getToNode() {
        return toNode;
    }
    
    public int getWeight() {
        return weight;
    }
    
    @Override
    public String toString() {
        return fromNode + " -> " + toNode + " (weight: " + weight + ")";
    }
}
