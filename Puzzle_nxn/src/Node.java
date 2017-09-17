
public class Node 
{
	Board currentState;
	Node parentNode;
	int pathCost;
	String action;
	
	public Node()
	{
		this.parentNode = null;
		this.pathCost = 0;
	}

	public Node(Board currentState, Node parentNode, int pathCost, String action) 
	{
		this.currentState = currentState;
		this.parentNode = parentNode;
		this.pathCost = pathCost;
		this.action = action;
	}

	public Board getCurrentState() 
	{
		return currentState;
	}

	public Node getParentNode() 
	{
		return parentNode;
	}

	public int getPathCost() 
	{
		return pathCost;
	}

	public String getAction() 
	{
		return action;
	}

	public void setCurrentState(Board currentState) 
	{
		this.currentState = currentState;
	}

	public void setParentNode(Node parentNode) {
		this.parentNode = parentNode;
	}

	public void setPathCost(int pathCost) 
	{
		this.pathCost = pathCost;
	}

	public void setAction(String action) 
	{
		this.action = action;
	}

	@Override
	public String toString() {
		return "Node [currentState=" + currentState + ", parentNode=" + parentNode + ", pathCost=" + pathCost
				+ ", action=" + action + "]";
	}

	

}
