package com.aidan.traversalexperiments;

import com.aidan.traversalexperiments.common.*;
import com.aidan.traversalexperiments.graph.*;
import com.aidan.traversalexperiments.algorithms.*;
import com.aidan.traversalexperiments.utils.*;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.reflect.Method;

import org.graphstream.graph.Graph;
import org.jfree.chart.util.ArrayUtils;

public class App 
{
    public static void main(String[] args)
    {	
    	// arg parsing
        Map<String, String[]> arguments = new HashMap<>();
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--traverse":
                    if (i + 2 < args.length) {
                        arguments.put("traverse", new String[]{args[i + 1], args[i + 2]});
                        i += 2;
                    } else {
                        System.err.println("Error: --traverse requires two arguments (traversal method, graph type)");
                        return;
                    }
                    break;

                case "--search":
                    if (i + 2 < args.length) {
                        arguments.put("search", new String[]{args[i + 1], args[i + 2]});
                        i += 2;
                    } else {
                        System.err.println("Error: --search requires two arguments (search method, graph type)");
                        return;
                    }
                    break;

                case "--pipeline":
                    if (i + 1 < args.length) {
                        arguments.put("pipeline", new String[]{args[i + 1]});
                        i++;
                    } else {
                        System.err.println("Error: --pipeline requires one argument (pipeline name)");
                        return;
                    }
                    break;

                default:
                    System.err.println("Unknown argument: " + args[i]);
                    return;
            }
        }
        Scanner traversalScanner = new Scanner(System.in); 
        // traversal
        if (arguments.containsKey("traverse")) {
        	com.aidan.traversalexperiments.graph.Graph cGraph = null;
            String[] traverseArgs = arguments.get("traverse");
            if(traverseArgs[1].toLowerCase().equals("connected-graph")) {
            	System.out.print("Enter node count: ");
            	int nodeCount = traversalScanner.nextInt();
            	System.out.print("Enter max-neighbor count: ");
            	int neighborCount = traversalScanner.nextInt();
            	cGraph = Generator.generateConnectedGraph(nodeCount, neighborCount);
            	traversalScanner.close();
            }
            else if(traverseArgs[1].toLowerCase().equals("binary-tree")) {
            	System.out.print("Enter node count: ");
            	int nodeCount = traversalScanner.nextInt();
            	cGraph = Generator.generateBinaryTree(nodeCount);
            	traversalScanner.close();
            }
            else {
            	traversalScanner.close();
            	System.err.println("Invalid graph type: " + traverseArgs[1]);
            	System.exit(1);
            }
            AdjacencyMatrix am = cGraph.toAdjacencyMatrix();
            Graph sg = Visualize.toSingleGraph(am, traverseArgs[1]);
            if(traverseArgs[0].toLowerCase().equals("dfs")){
            	DFS.traverse(cGraph.getNodes().getFirst(), sg);
            }
            else if(traverseArgs[0].toLowerCase().equals("bfs")) {
            	BFS.traverse(cGraph.getNodes().getFirst(), sg);
            }
            else {
            	System.err.println("Invalid traversal type: " + traverseArgs[0]);
            	System.exit(1);
            }
        }
        
        Scanner searchScanner = new Scanner(System.in);
        // search
        if (arguments.containsKey("search")) {
        	com.aidan.traversalexperiments.graph.Graph cGraph = null;
            String[] searchArgs = arguments.get("search");
            if(searchArgs[1].toLowerCase().equals("connected-graph")) {
            	System.out.print("Enter node count: ");
            	int nodeCount = searchScanner.nextInt();
            	System.out.print("Enter max-neighbor count: ");
            	int neighborCount = searchScanner.nextInt();
            	cGraph = Generator.generateConnectedGraph(nodeCount, neighborCount);
            	searchScanner.close();
            }
            else if(searchArgs[1].toLowerCase().equals("binary-tree")) {
            	System.out.print("Enter node count: ");
            	int nodeCount = searchScanner.nextInt();
            	cGraph = Generator.generateBinaryTree(nodeCount);
            	searchScanner.close();
            }
            else {
            	searchScanner.close();
            	System.err.println("Invalid graph type: " + searchArgs[1]);
            }
            AdjacencyMatrix am = cGraph.toAdjacencyMatrix();
            Graph sg = Visualize.toSingleGraph(am, searchArgs[1]);
            if(searchArgs[0].toLowerCase().equals("dfs")) {
            	DFS.search(cGraph.getNodes().getFirst(), 1+cGraph.getNodes().size()/2, sg);
            }
            else if(searchArgs[0].toLowerCase().equals("bfs")) {
            	BFS.search(cGraph.getNodes().getFirst(), 1+cGraph.getNodes().size()/2, sg);
            }
            else {
            	System.err.println("Invalid search type: " + searchArgs[0]);
            	System.exit(1);
            }
        }
        
        // pipelines
        if (arguments.containsKey("pipeline")) {
            String pipeline = arguments.get("pipeline")[0];
            try {
                Method method = App.class.getDeclaredMethod("Pipelines." + pipeline);
                method.invoke(null);
            } catch (NoSuchMethodException e) {
                System.err.println("Error: No pipeline named '" + pipeline + "' found.");
                System.exit(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//    	ConnectedGraph cGraph = Generator.generateConnectedGraph(15, 4);
//    	AdjacencyMatrix cGraphMatrix = cGraph.toAdjacencyMatrix();
//    	Graph simplecGraph = Visualize.toSingleGraph(cGraphMatrix, "cGraph");
//    	DFS.search(cGraph.getNodes().getFirst(), cGraph.getNodes().getLast().getId(), simplecGraph);
//    	BFS.search(cGraph.getNodes().getFirst(), cGraph.getNodes().get(10).getId(), simplecGraph);
//    	System.out.println(cGraphMatrix.toString());    	
//    	Pipelines.speedNodesSearch();
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
