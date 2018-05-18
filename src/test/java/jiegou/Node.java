package jiegou;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	public Node(String name){
		this.name=name;
		
	}
	
	public List<Node> nodes=new ArrayList<Node>();
	 
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	public int id;
	public String name;
	public int parentId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

}
