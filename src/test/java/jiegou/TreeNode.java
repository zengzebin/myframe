package jiegou;

import java.util.ArrayList;
import java.util.List;

import ssxt.com.jdbc.jdbcAonotaion;

public class TreeNode {
	private Node node;

	public TreeNode(Node node) {
		this.node = node;
	}

	public static void getName(Node node) {
		List<Node> nodes = node.getNodes();
		for (int i = 0; i < nodes.size(); i++) {
			Node n = nodes.get(i);
			System.out.print(n.getName());
			getName(n);
		}

	}
	
	
	public static void getTreeName(Tree node) {
		if(node.getNodes()==null)
			return;
		List<Tree> nodes = node.getNodes();
		for (int i = 0; i < nodes.size(); i++) {
			Tree n = nodes.get(i);
			System.out.print(n.getCNAME());
			getTreeName(n);
		}

	}


	public static  Tree  init(List<Tree> list){
	 
		Tree tree = new Tree();

		for (Tree node1 : list) {
			boolean mark = false;
			System.out.println(node1.getCNAME());
			for (Tree node2 : list) {
				if (node1.getPID() != 0
						&& node1.getPID()==node2.getCID()) {
					mark = true;
					if (node2.getNodes() == null) {
						node2.setNodes((new ArrayList<Tree>()));
					}
					node2.getNodes().add(node1);
					break;
				}
			}
			if (!mark) {
				System.out.println("mark");
				tree.setNodes((new ArrayList<Tree>()));
				tree.getNodes().add(node1);
			}
		}

 
		return tree;
	}

	public static void main(String[] args) {
		Node nodes = new Node("父");
		Node node1 = new Node("子1");
		Node node2 = new Node("子2");
		Node node3 = new Node("叶1");
		Node node4 = new Node("叶2");
		Node node5 = new Node("叶叶2");
		nodes.getNodes().add(node1);
		nodes.getNodes().add(node2);
		node2.getNodes().add(node3);
		node2.getNodes().add(node4);
		node3.getNodes().add(node5);

		TreeNode.getName(nodes);

		Object[] o = {};
		List<Tree> list = jdbcAonotaion.get2("jiegou.Tree", "select CID, CNAME, PID from tb_tree", o);
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getCNAME());
//		}
		Tree tree=	TreeNode.init(list);
		TreeNode.getTreeName(tree);
		
	 
		
		
		
	}

}
