
public class Node 
{
	
	private State state;
	private Node parentNode;
	private String action;
	private int pathCost;
	private int h;
	private int fFunction;
	
	public Node(State state, Node parentNode, String action) 
	{
		this.state = state;
		this.parentNode = parentNode;
		this.action = action;
	}
	
	public Node()
	{
		
	}

	public State getState() 
	{
		return state;
	}

	public Node getParentNode() 
	{
		return parentNode;
	}

	public String getAction() 
	{
		return action;
	}

	public int getPathCost() 
	{
		return pathCost;
	}

	public int getH() {
		return h;
	}

	public int getfFunction() 
	{
		return fFunction;
	}

	public void setState(State state) 
	{
		this.state = state;
	}

	public void setParentNode(Node parentNode) 
	{
		this.parentNode = parentNode;
	}

	public void setAction(String action) 
	{
		this.action = action;
	}

	public void setPathCost(int pathCost) 
	{
		this.pathCost = pathCost;
	}

	public void setH(int h) 
	{
		this.h = h;
	}

	public void setfFunction(int fFunction) 
	{
		this.fFunction = fFunction;
	}

	@Override
	public String toString() 
	{
		return "Node         state=" + state +  ", action=" + action ;
	}
}
