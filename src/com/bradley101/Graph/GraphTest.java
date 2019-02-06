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
	}
	
	@org.junit.jupiter.api.Test
	void newNode1() {
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
}