package com.aidan.traversalexperiments.graph;

import java.util.HashMap;
import java.util.Map;

import com.aidan.traversalexperiments.common.Node;

public class AdjacencyMatrix {
    private boolean[][] matrix;
    private Map<Node, Integer> nodeIndexMap; // map between nodes and their matrix idx
    private int capacity; // matrix capacity
    private int size; // nodes in matrix

    public AdjacencyMatrix(int initialCapacity) {
        this.capacity = initialCapacity;
        this.size = 0;
        this.matrix = new boolean[capacity][capacity];
        this.nodeIndexMap = new HashMap<>();
    }

    public void addNode(Node node) {
        if (nodeIndexMap.containsKey(node)) {
            throw new IllegalArgumentException("Node already exists in the matrix.");
        }

        // expand capacity when needed
        if (size == capacity) {
            expandMatrix();
        }

        nodeIndexMap.put(node, size++);
    }

    public void addEdge(Node fromNode, Node toNode, boolean directed) {
        Integer fromIndex = nodeIndexMap.get(fromNode);
        Integer toIndex = nodeIndexMap.get(toNode);

        if (fromIndex == null || toIndex == null) {
            throw new IllegalArgumentException("Both nodes must be added before creating an edge.");
        }

        matrix[fromIndex][toIndex] = true;

        if (!directed) {
            matrix[toIndex][fromIndex] = true;
        }
    }
    
    // not needed as Node stores neighbors, but could be useful for custom Node classes
    public Map<Node, Boolean> getNeighbors(Node node) {
        Integer nodeIndex = nodeIndexMap.get(node);

        if (nodeIndex == null) {
            throw new IllegalArgumentException("Node does not exist in the graph.");
        }

        Map<Node, Boolean> neighbors = new HashMap<>();
        for (Map.Entry<Node, Integer> entry : nodeIndexMap.entrySet()) {
            if (matrix[nodeIndex][entry.getValue()]) {
                neighbors.put(entry.getKey(), true);
            }
        }

        return neighbors;
    }

    // check if two nodes share an edge (are connected)
    public boolean isConnected(Node fromNode, Node toNode) {
        Integer fromIndex = nodeIndexMap.get(fromNode);
        Integer toIndex = nodeIndexMap.get(toNode);

        if (fromIndex == null || toIndex == null) {
            throw new IllegalArgumentException("Both nodes must be added before checking connectivity.");
        }

        return matrix[fromIndex][toIndex];
    }

    // expand matrix in case capacity is exceeded
    private void expandMatrix() {
        int newCapacity = capacity * 2;
        boolean[][] newMatrix = new boolean[newCapacity][newCapacity];

        for (int i = 0; i < capacity; i++) {
            System.arraycopy(matrix[i], 0, newMatrix[i], 0, capacity);
        }

        this.matrix = newMatrix;
        this.capacity = newCapacity;
    }
    // print readable visualization of matrix
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Adjacency Matrix:\n");

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(matrix[i][j] ? "1 " : "0 ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
