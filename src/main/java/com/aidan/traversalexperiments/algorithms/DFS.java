package com.aidan.traversalexperiments.algorithms;

import java.util.HashSet;
import java.util.Set;

import com.aidan.traversalexperiments.common.Node;

public class DFS {
	public void traverse(Node start) {
		if(start == null) {
			System.out.println("Start node is null. No traversal performed");
			return;
		}
		Set<Node> visited = new HashSet<>();
		System.out.println("DFS Traversal:");
		recursiveTraverse(start, visited);
	}
	
	private void recursiveTraverse(Node curr, Set<Node> visited) {
		if(curr == null) {
			return;
		}
		System.out.println("Visited: " + curr);
		if(visited.add(curr)) {
			for(Node neighbor : curr.getNeighbors()) {
				recursiveTraverse(neighbor, visited);
			}
		}
		return;
	}
	
	// traversal specifically for search function
	private boolean searchTraverse(Node curr, Set<Node> visited, int targetId) {
		if(curr == null) {
			return false;
		}
		else if(curr.getId() == targetId) {
			return true;
		}
		else if(visited.add(curr)) {
			for(Node neighbor : curr.getNeighbors()) {
				if(searchTraverse(neighbor, visited, targetId)) {
					return true;
				}
			}
		}
		return false;
		
	}
	
	// find target node
	public boolean search(Node start, int targetId) {
        if(start == null) {
            System.out.println("Start node is null. No search performed.");
        	return false;
        }
        Set<Node> visited = new HashSet<>();
        return searchTraverse(start, visited, targetId);
	}
}
