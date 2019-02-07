package com.bradley101.Graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
	
	@org.junit.jupiter.api.Test
	void getDir() {
		Graph<Object, Object> graph = new Graph<>();
		Assertions.assertEquals(Graph.DIRECTION.UNDIRECTED, graph.getDir());
	}
	
	@Test
	void getDir1() {
		Graph<Object, Object> graph = new Graph<>(Graph.WEIGH.NON_WEIGHTED, Graph.DIRECTION.DIRECTED);
		Assertions.assertEquals(Graph.DIRECTION.DIRECTED, graph.getDir());
	}
	
	@org.junit.jupiter.api.Test
	void getWeigh() {
		Graph<Object, Object> graph = new Graph<>();
		Assertions.assertEquals(Graph.WEIGH.WEIGHTED, graph.getWeigh());
	}
	
	@org.junit.jupiter.api.Test
	void newNode() {
		Graph<Object, Object> graph = new Graph<>();
		Graph.Node node = graph.newNode();
		Assertions.assertNotNull(node);
	}
	
	@org.junit.jupiter.api.Test
	void newNode1() {
		Graph<Integer, Object> graph = new Graph<>();
		Graph.Node node = graph.newNode(10);
		Assertions.assertNotNull(node);
		Assertions.assertEquals(10, node.getVal());
	}
	
	@Test
	void getWeigh1() {
		Graph<Object, Object> graph = new Graph<>(Graph.WEIGH.WEIGHTED, Graph.DIRECTION.UNDIRECTED);
		Assertions.assertEquals(Graph.WEIGH.WEIGHTED, graph.getWeigh());
	}
	
	@Test
	void newNode2() {
	}
	
	@Test
	void newNode3() {
	}
	
	@Test
	void getData() {
		Graph<Integer, Integer> graph = new Graph<>();
		Graph.Node node1 = graph.newNode(10);
		Graph.Node node2 = graph.newNode(20);
		try {
			Graph.Edge edge = node1.connectTo(node2, 100);
			Assertions.assertEquals(100, edge.getData());
		} catch (GraphException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void getNumNodes() {
		Graph<Integer, Integer> graph = new Graph<>();
		Graph.Node node1 = graph.newNode(10);
		Graph.Node node2 = graph.newNode(20);
		try {
			Graph.Edge edge = node1.connectTo(node2, 100);
		} catch (GraphException e) {
			e.printStackTrace();
		}
		Assertions.assertEquals(2, graph.getNodeList().size());
	}
	
	@Test
	void getAdjacentConnectedNode() {
		Graph<Integer, Integer> graph = new Graph<>();
		Graph.Node node1 = graph.newNode(10);
		Graph.Node node2 = graph.newNode(20);
		try {
			Graph.Edge edge = node1.connectTo(node2, 100);
		} catch (GraphException e) {
			e.printStackTrace();
		}
		Assertions.assertEquals(node2, node1.getAdjacentNodes().get(0));
		Assertions.assertEquals(node1, node2.getAdjacentNodes().get(0));
	}
	
	@Test
	void toString1() {
		Graph<Integer, Integer> graph = new Graph<>();
		Graph.Node node1 = graph.newNode(10);
		Graph.Node node2 = graph.newNode(20);
		String str1 = null, str2 = null, str3 = null;
		try {
			Graph.Edge edge = node1.connectTo(node2, 100);
			str3 = edge.toString();
		} catch (GraphException e) {
			e.printStackTrace();
		}
		str1 = graph.toString();
		str2 = node1.toString();
		
		Assertions.assertEquals("Graph: 2 nodes\n", str1);
		Assertions.assertEquals("Node: val = 10\n" +
						"Adjacent nodes: 1\n" +
						"Connecting edges: 1\n", str2);
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
	}
}