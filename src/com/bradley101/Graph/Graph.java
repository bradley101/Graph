package com.bradley101.Graph;

/*
    @author Shantanu Banerjee
    email - shantanu.banerjeee@gmail.com
    date - 22 Jan,  2019, 02:26:34 AM IST
    updated - 6 Feb, 2019, 09:14:10 PM IST
    
 */

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {
	public static enum WEIGH {
		WEIGHTED,
		NON_WEIGHTED
	}
	
	public static enum DIRECTION {
		DIRECTED,
		UNDIRECTED
	}
	
	private List<Node> nodeList;
	
	public Graph() {
		nodeList = new ArrayList<>();
	}
	
	public Node<T> newNode() {
		return new Node<>();
	}
	
	private class Node<U extends T> {
		private U val;
		private List<Node> adjacentNodes;
		
		private Node() {
			initializeAdjacentList();
		}
		
		private Node(U val) {
			this.val = val;
			initializeAdjacentList();
		}
		
		private void initializeAdjacentList() {
			adjacentNodes = new ArrayList<>();
		}
		
		public U getVal() {
			return val;
		}
		
		public void setVal(U val) {
			this.val = val;
		}
	}
}
