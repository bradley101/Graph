package com.bradley101.Graph;

/*
    @author Shantanu Banerjee
    email - shantanu.banerjeee@gmail.com
    date - 22 Jan 2019, 2:26:34 AM IST
    
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
	
  private WEIGH weigh; 
  private DIRECTION dir;
	private List<Node> nodeList;
	
	public Graph() {
		Graph(WEIGH.NON_WEIGHTED, DIRECTION.UNDIRECTED);
	}

  public Graph(WEIGH weigh, DIRECTION dir) {
    this.weigh = weigh;
    this.dir = dir;
    nodeList = new ArrayList<>();
  }
	
	public Node<T> newNode() {
		return new Node<>();
	}
	
	private class Node<U extends T> {
		private U val;
		private List<Node> adjacentNodes;
    private List<Edge> connectingEdges;
		
		private Node() {
			Node(null);
		}
		
		private Node(U val) {
			this.val = val;
			initializeAdjacentList();
		}
		
		private void initializeAdjacentList() {
			adjacentNodes = new ArrayList<>();
		}

    public void addEdge(Node adjacentNode) {
      if (adjacentNode == null) {
        throw new GraphException("Cannot add an edge to a null node");
      }  
    }
		
		public U getVal() {
			return val;
		}
		
		public void setVal(U val) {
			this.val = val;
		}
	}

  class Edge<E> {
    E data;
    Node connectorNode, connectingNode;

    Edge(Node connectorNode, Node connectingNode) {
      Edge(null, connectorNode, connectingNode);
    }

    Edge(E data, Node connectorNode, Node connectingNode) {
      if (connectorNode == null || connectingNode == null) {
        throw new GraphException("Connecting  nodes cannot be null");
      }
      this.data = data;
      this.connectingNode = connectingNode;
      this.connectorNode = connectorNode;
    }

    public Node[] getAdjacentNodes() {
      return new Node[] {connectorNode, connectingNode};
    }

    public E getData() {
      return data;
    }

    public void setData(E data) {
      this.data = data;
    }


  }

  protected class GraphException extends Exception {
    private static final long serialVersionUID = 1L;

    GraphException(String msg) {
      super(msg);
    }
  }
}
