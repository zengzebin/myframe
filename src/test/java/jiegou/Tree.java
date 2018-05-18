package jiegou;

import java.util.List;

public class Tree {
	private int CID;
	private List <Tree> nodes;
	public List<Tree> getNodes() {
		return nodes;
	}
	public void setNodes(List<Tree> nodes) {
		this.nodes = nodes;
	}
	public int getCID() {
		return CID;
	}
	public void setCID(int cID) {
		CID = cID;
	}
	public String getCNAME() {
		return CNAME;
	}
	public void setCNAME(String cNAME) {
		CNAME = cNAME;
	}
	public int getPID() {
		return PID;
	}
	public void setPID(int pID) {
		PID = pID;
	}
	private String CNAME;
	private int PID;
	
	

}
