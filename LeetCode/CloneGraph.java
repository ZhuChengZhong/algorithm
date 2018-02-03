package com.zhu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
/*
 * 

Clone an undirected graph. Each node in the graph contains alabeland a list of itsneighbors.

OJ's undirected graph serialization:

Nodes are labeled uniquely.
We use#as a separator for each node, and,as a separator for node label and each neighbor of the node.


As an example, consider the serialized graph{0,1,2# 1,2# 2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by#.

    First node is labeled as0. Connect node0to both nodes1and2.
    Second node is labeled as1. Connect node1to node2.
    Third node is labeled as2. Connect node2to node2(itself), thus forming a self-cycle. 


Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/

 * */
public class CloneGraph {
	private HashMap<Integer,UndirectedGraphNode>map=new HashMap<Integer,UndirectedGraphNode>();
	static class UndirectedGraphNode {
		      int label;
		      ArrayList<UndirectedGraphNode> neighbors;
		      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
		  };
	 public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	     return clone(node);
	 }
	 private  UndirectedGraphNode clone(UndirectedGraphNode node){
		 if(node==null){
			 return null;
		 }
		 if(map.containsKey(node.label)){
			 return map.get(node.label);
		 }
		 UndirectedGraphNode cloneNode=new UndirectedGraphNode(node.label);
		 map.put(node.label, cloneNode);
		 for(int i=0;i<node.neighbors.size();i++){
			 UndirectedGraphNode n=clone(node.neighbors.get(i));
			 cloneNode.neighbors.add(n);
		 }
		 return cloneNode;
	 }
}
