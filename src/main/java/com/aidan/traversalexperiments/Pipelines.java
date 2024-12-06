package com.aidan.traversalexperiments;

import com.aidan.traversalexperiments.graph.*;
import com.aidan.traversalexperiments.utils.*;
import com.aidan.traversalexperiments.algorithms.*;

import org.graphstream.graph.Graph;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;

public class Pipelines {
	public static void speed() {
		Tree tree = Generator.generateBinaryTree(5);
		ConnectedGraph cGraph = Generator.generateConnectedGraph(5);
		
		AdjacencyMatrix treeAM = tree.toAdjacencyMatrix();
		Graph simpleTree = Visualize.toSingleGraph(treeAM, "Tree");
		Visualize.displayGraph(simpleTree);
		
		AdjacencyMatrix cGraphAM = cGraph.toAdjacencyMatrix();
		Graph simplecGraph = Visualize.toSingleGraph(cGraphAM, "Connected Graph");
		Visualize.displayGraph(simplecGraph);
		
		long startTime = System.nanoTime();
		DFS.traverse(tree.getNodes().getFirst());
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		System.out.println("Tree DFS: " + elapsedTime);
		
		startTime = System.nanoTime();
		DFS.traverse(cGraph.getNodes().getFirst());
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		System.out.println("cGraph DFS: " + elapsedTime);
		
		startTime = System.nanoTime();
		BFS.traverse(tree.getNodes().getFirst());
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		System.out.println("Tree BFS: " + elapsedTime);
		
		startTime = System.nanoTime();
		BFS.traverse(cGraph.getNodes().getFirst());
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		System.out.println("cGraph BFS: " + elapsedTime);
	}
	// test the speed of BFS and DFS with respect to edge counts
	public static void speedEdges() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i = 0; i < 2000; i+=100) {
			ConnectedGraph cGraph = Generator.generateConnectedGraph(2000, i);
			long startTime = System.nanoTime();
			DFS.traverse(cGraph.getNodes().getFirst());
			long endTime = System.nanoTime();
			long elapsedTime = endTime - startTime;
	        dataset.addValue(elapsedTime, "Elapsed Time", (Integer) i);
		}
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Edge Count vs Elapsed Time",
                "Number of Edges",
                "Elapsed Time (nanoseconds)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // display graph with swing
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Connected Graph DFS Traversal Speed");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 600);
            frame.add(new ChartPanel(lineChart));
            frame.setVisible(true);
        });
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
		for(int i = 0; i < 2000; i+=100) {
			ConnectedGraph cGraph = Generator.generateConnectedGraph(2000, i);
			long startTime = System.nanoTime();
			BFS.traverse(cGraph.getNodes().getFirst());
			long endTime = System.nanoTime();
			long elapsedTime = endTime - startTime;
	        dataset2.addValue(elapsedTime, "Elapsed Time", (Integer) i);
		}
        JFreeChart lineChart2 = ChartFactory.createLineChart(
                "Edge Count vs Elapsed Time",
                "Number of Edges",
                "Elapsed Time (nanoseconds)",
                dataset2,
                PlotOrientation.VERTICAL,
                true, true, false);

        // display graph with swing
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Connected Graph BFS Traversal Speed");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 600);
            frame.add(new ChartPanel(lineChart2));
            frame.setVisible(true);
        });
	}
	// test the speed of DFS and BFS with respect to node counts
	public static void speedNodes() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i = 1; i < 2000; i+=100) {
			ConnectedGraph cGraph = Generator.generateConnectedGraph(i, 4);
			long startTime = System.nanoTime();
			DFS.traverse(cGraph.getNodes().getFirst());
			long endTime = System.nanoTime();
			long elapsedTime = endTime - startTime;
	        dataset.addValue(elapsedTime, "Elapsed Time", (Integer) i);
		}
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Node Count vs Elapsed Time",
                "Number of Nodes",
                "Elapsed Time (nanoseconds)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // display graph with swing
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Connected Graph DFS Traversal Speed");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 600);
            frame.add(new ChartPanel(lineChart));
            frame.setVisible(true);
        });
        
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
		for(int i = 1; i < 2000; i+=100) {
			ConnectedGraph cGraph = Generator.generateConnectedGraph(i, 4);
			long startTime = System.nanoTime();
			BFS.traverse(cGraph.getNodes().getFirst());
			long endTime = System.nanoTime();
			long elapsedTime = endTime - startTime;
	        dataset2.addValue(elapsedTime, "Elapsed Time", (Integer) i);
		}
        JFreeChart lineChart2 = ChartFactory.createLineChart(
                "Node Count vs Elapsed Time",
                "Number of Nodes",
                "Elapsed Time (nanoseconds)",
                dataset2,
                PlotOrientation.VERTICAL,
                true, true, false);

        // display graph with swing
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Connected Graph BFS Traversal Speed");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 600);
            frame.add(new ChartPanel(lineChart2));
            frame.setVisible(true);
        });
        
		DefaultCategoryDataset dataset3 = new DefaultCategoryDataset();
		for(int i = 1; i < 2000; i+=100) {
			ConnectedGraph cGraph = Generator.generateConnectedGraph(i);
			long startTime = System.nanoTime();
			DFS.traverse(cGraph.getNodes().getFirst());
			long endTime = System.nanoTime();
			long elapsedTime = endTime - startTime;
	        dataset3.addValue(elapsedTime, "Elapsed Time", (Integer) i);
		}
        JFreeChart lineChart3 = ChartFactory.createLineChart(
                "Node Count vs Elapsed Time",
                "Number of Nodes",
                "Elapsed Time (nanoseconds)",
                dataset3,
                PlotOrientation.VERTICAL,
                true, true, false);

        // display graph with swing
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Binary Tree DFS Traversal Speed");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 600);
            frame.add(new ChartPanel(lineChart3));
            frame.setVisible(true);
        });
        
		DefaultCategoryDataset dataset4 = new DefaultCategoryDataset();
		for(int i = 1; i < 2000; i+=100) {
			ConnectedGraph cGraph = Generator.generateConnectedGraph(i);
			long startTime = System.nanoTime();
			BFS.traverse(cGraph.getNodes().getFirst());
			long endTime = System.nanoTime();
			long elapsedTime = endTime - startTime;
	        dataset4.addValue(elapsedTime, "Elapsed Time", (Integer) i);
		}
        JFreeChart lineChart4 = ChartFactory.createLineChart(
                "Node Count vs Elapsed Time",
                "Number of Nodes",
                "Elapsed Time (nanoseconds)",
                dataset4,
                PlotOrientation.VERTICAL,
                true, true, false);

        // display graph with swing
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Binary Tree BFS Traversal Speed");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 600);
            frame.add(new ChartPanel(lineChart4));
            frame.setVisible(true);
        });
	}
}
