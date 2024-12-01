package com.aidan.traversalexperiments.graph;

import com.aidan.traversalexperiments.common.Node;

import java.util.List;
import java.util.ArrayList;

public abstract class Graph{
    protected List<Node> nodes;

    public Graph() {
        nodes = new ArrayList<>();
    }

    public abstract void addNode(Node node);
    public abstract void addEdge(Node fromNode, Node toNode);
    public abstract boolean containsNode(Node node); // check if graph contains specified node
    public abstract AdjacencyMatrix toAdjacencyMatrix();

    public int size() {
        return nodes.size();
    }
}

