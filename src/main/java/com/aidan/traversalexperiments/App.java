package com.aidan.traversalexperiments;

import com.aidan.traversalexperiments.common.*;
import com.aidan.traversalexperiments.graph.*;
import com.aidan.traversalexperiments.algorithms.*;
import com.aidan.traversalexperiments.utils.*;

public class App 
{
    public static void main(String[] args)
    {
    	ConnectedGraph cGraph = Generator.generateConnectedGraph(100);
    	AdjacencyMatrix cGraphMatrix = cGraph.toAdjacencyMatrix();
    	System.out.println(cGraphMatrix.toString());
    	
    	Tree tree = Generator.generateBinaryRootedTree(9);
    	AdjacencyMatrix treeMatrix = tree.toAdjacencyMatrix();
    	System.out.println(treeMatrix.toString());
    	
    	Visualize.displayGraph(cGraphMatrix);
    }
}
