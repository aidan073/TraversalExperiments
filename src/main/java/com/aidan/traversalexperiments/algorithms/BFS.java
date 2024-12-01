package com.aidan.traversalexperiments.algorithms;

import java.util.*;
import com.aidan.traversalexperiments.common.Node;

public class BFS {
    public void traverse(Node start) {
        if(start == null) {
        	System.out.println("Start node is null. No traversal performed");
            return;
        }

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
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

    // find target node
    public boolean search(Node start, int targetId) {
        if(start == null) {
            System.out.println("Start node is null. No search performed.");
        	return false;
        }

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
