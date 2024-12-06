package com.aidan.traversalexperiments;

import com.aidan.traversalexperiments.common.*;
import com.aidan.traversalexperiments.graph.*;
import com.aidan.traversalexperiments.algorithms.*;
import com.aidan.traversalexperiments.utils.*;

import org.graphstream.graph.Graph;

public class App 
{
    public static void main(String[] args)
    {
    	ConnectedGraph cGraph = Generator.generateConnectedGraph(15, 4);
    	AdjacencyMatrix cGraphMatrix = cGraph.toAdjacencyMatrix();
    	Graph simplecGraph = Visualize.toSingleGraph(cGraphMatrix, "cGraph");
//    	DFS.search(cGraph.getNodes().getFirst(), cGraph.getNodes().getLast().getId(), simplecGraph);
    	BFS.search(cGraph.getNodes().getFirst(), cGraph.getNodes().get(10).getId(), simplecGraph);
//    	System.out.println(cGraphMatrix.toString());    	
    	
//    	Tree tree = Generator.generateBinaryTree(50);
//    	AdjacencyMatrix treeMatrix = tree.toAdjacencyMatrix();
////    	System.out.println(treeMatrix.toString());
//    	Graph simpleTree = Visualize.toSingleGraph(treeMatrix, "Tree");
//    	Visualize.displayGraph(simpleTree, true);
    	
//    	Graph simpleRootedTree = Visualize.toSingleGraph(treeMatrix, "Rooted Tree");
//   	Pipelines.speed();
//    	Pipelines.speedEdges();
//    	Pipelines.speedNodes();
//    	Visualize.displayGraph(simpleRootedTree);
//    	DFS.traverse(tree.getNodes().get(0), simpleRootedTree);
//    	BFS.traverse(tree.getNodes().get(0), simpleRootedTree);
    	
//    	Graph simpleConnectedGraph = Visualize.toSingleGraph(cGraphMatrix, "Connected Graph");
//    	Visualize.displayGraph(simpleConnectedGraph);
//    	DFS.traverse(cGraph.getNodes().get(0), simpleConnectedGraph);
//    	BFS.traverse(cGraph.getNodes().get(0), simpleConnectedGraph);
    }
}
