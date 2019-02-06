package com.bradley101.Graph;

/*
    @author Shantanu Banerjee
    email - shantanu.banerjeee@gmail.com
    date - 22 Jan,  2019, 02:26:34 AM IST
    updated - 6 Feb, 2019, 09:14:10 PM IST
    
 */

import java.util.ArrayList;
import java.util.List;

public class Graph<T, E> {
	public static enum WEIGH {
		WEIGHTED, NON_WEIGHTED
	}

	public static enum DIRECTION {
		DIRECTED, UNDIRECTED
	}

	private WEIGH weigh;
	private DIRECTION dir;
	private List<Node> nodeList;

	public Graph() {
		this(WEIGH.WEIGHTED, DIRECTION.UNDIRECTED);
	}

	public Graph(WEIGH weigh, DIRECTION dir) {
		this.weigh = weigh;
		this.dir = dir;
		nodeList = new ArrayList<>();
	}

	public DIRECTION getDir() {
		return dir;
	}

	public WEIGH getWeigh() {
		return weigh;
	}

	public Node<T, E> newNode() {
		return newNode(null);
	}

	public Node<T, E> newNode(T val) {
		return new Node<>(val);
	}

	class Node<U extends T, F extends E> {
		private U val;
		private List<Node> adjacentNodes;
		private List<Edge> connectingEdges;

		private Node() {
			this(null);
		}

		private Node(U val) {
			this.val = val;
			initializeAdjacentList();
		}

		private void initializeAdjacentList() {
			adjacentNodes = new ArrayList<>();
			connectingEdges = new ArrayList<>();
		}

		private void addAdjacentNode(Node node) {
			adjacentNodes.add(node);
		}

		public void connectTo(Node adjacentNode) throws GraphException {
			connectTo(adjacentNode, null);
		}

		public void connectTo(Node adjacentNode, F data) throws GraphException {
			if (adjacentNode == null) {
				throw new GraphException("Cannot add an edge to a null node");
			}
			Edge<F> edge = new Edge(data, this, adjacentNode);
			connectingEdges.add(edge);
		}

		public U getVal() {
			return val;
		}

		public void setVal(U val) {
			this.val = val;
		}
		
		public List<Node> getAdjacentNodes() {
			return adjacentNodes;
		}
		
		public List<Edge> getConnectingEdges() {
			return connectingEdges;
		}
	}

	class Edge<E> {
		E data;
		Node connectorNode, connectingNode;

		Edge(Node connectorNode, Node connectingNode) throws GraphException {
			this(null, connectorNode, connectingNode);
		}

		Edge(E data, Node connectorNode, Node connectingNode) throws GraphException {
			if (connectorNode == null || connectingNode == null) {
				throw new GraphException("Connecting  nodes cannot be null");
			}
			this.data = data;
			this.connectingNode = connectingNode;
			this.connectorNode = connectorNode;

			connectorNode.addAdjacentNode(connectingNode);
			if (Graph.this.getDir() == Graph.DIRECTION.UNDIRECTED) {
				connectingNode.addAdjacentNode(connectorNode);
			}
		}

		public Node[] getAdjacentNodes() {
			return new Node[] { connectorNode, connectingNode };
		}

		public E getData() {
			return data;
		}

		public void setData(E data) {
			this.data = data;
		}

	}
}
