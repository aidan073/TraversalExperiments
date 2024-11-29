package com.aidan.traversalexperiments.algorithms;

import java.util.*;
import com.aidan.traversalexperiments.common.Node;

public class BFS {
    public void traverse(Node start) {
        if(start == null) {
            System.out.println("Start node is null. No traversal performed.");
            return;
        }

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        // start BFS from the given node
        queue.add(start);
        visited.add(start);

        System.out.println("BFS Traversal:");

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println("Visited: " + current);

            // add all unvisited neighbors to the queue
            for(Node neighbor : current.getNeighbors()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    // Find a specific target node using BFS
    public boolean search(Node start, String targetId) {
        if(start == null) return false;

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            if(current.getId() == targetId) {
                return true;
            }

            for(Node neighbor : current.getNeighbors()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
}
