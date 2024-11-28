package com.aidan.traversalexperiments.graph;

import java.util.List;
import java.util.ArrayList;

public abstract class Graph {
    protected List<Node> nodes;
    protected List<Edge> edges;

    public Graph() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public abstract void addNode(Node node);
    public abstract void addEdge(Node from, Node to);
    public abstract List<Node> getNeighbors(Node node);
    public abstract boolean containsNode(Node node); // check if graph contains specified node

    public int size() {
        return nodes.size();
    }
}

