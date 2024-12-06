package com.aidan.traversalexperiments.algorithms;

import java.util.*;

import org.graphstream.graph.Graph;

import com.aidan.traversalexperiments.common.Node;

public class BFS {
	public static void traverse(Node start) {
		traverse(start, null);
	}
    public static void traverse(Node start, Graph graph) {
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
            Node curr = queue.poll();
//            System.out.println("Visited: " + curr);
            // update node appearance to visited, if graph is supplied
 			if(graph != null) {
 				graph.getNode(String.valueOf(curr.getId())).setAttribute("ui.class", "visited"); // change node appearance
 		        try {
 		            Thread.sleep(2000);
 		        } catch (InterruptedException e) {
 		            System.out.println("Traversal interrupted.");
 		            Thread.currentThread().interrupt();
 		        }
 			}

            // add all unvisited neighbors to the queue
            for(Node neighbor : curr.getNeighbors()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    // find target node
    public static boolean search(Node start, int targetId) {
        if(start == null) {
            System.out.println("Start node is null. No search performed.");
        	return false;
        }

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            if(curr.getId() == targetId) {
                return true;
            }

            for(Node neighbor : curr.getNeighbors()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
}
