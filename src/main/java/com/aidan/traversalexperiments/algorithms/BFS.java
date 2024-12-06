package com.aidan.traversalexperiments.algorithms;

import java.util.*;

import org.graphstream.graph.Graph;

import com.aidan.traversalexperiments.common.Node;
import com.aidan.traversalexperiments.utils.Visualize;

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

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
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
    public static boolean search(Node start, int targetId) {
    	return search(start, targetId, null);
    }
    // find target node
    public static boolean search(Node start, int targetId, Graph graph) {
        if(start == null) {
            System.out.println("Start node is null. No search performed.");
        	return false;
        }
        if(graph != null) {
        	graph.getNode(String.valueOf(targetId)).setAttribute("ui.class", "target");
        	Visualize.displayGraph(graph);
        }
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            if(curr.getId() == targetId) {
            	if(graph != null) {
            		graph.getNode(String.valueOf(curr.getId())).setAttribute("ui.class", "found");
            	}
                return true;
            }
            if(graph != null) {
            	graph.getNode(String.valueOf(curr.getId())).setAttribute("ui.class", "visited");
 		        try {
 		            Thread.sleep(2000);
 		        } catch (InterruptedException e) {
 		            System.out.println("Traversal interrupted.");
 		            Thread.currentThread().interrupt();
 		        }
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
