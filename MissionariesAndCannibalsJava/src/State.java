
public class State 
{
	private RiverBank left;
	private RiverBank right;
	
	public State()
	{
		left=new RiverBank();
		right=new RiverBank();
	}
	
	public State(RiverBank left, RiverBank right) 
	{
		this.left = left;
		this.right = right;
	}

	public RiverBank getLeft() {
		return left;
	}

	public RiverBank getRight() {
		return right;
	}

	public void setLeft(RiverBank left) {
		this.left = left;
	}

	public void setRight(RiverBank right) {
		this.right = right;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (left == null) 
		{
			if (other.left != null)
				return false;
		} 
		else if (!left.equals(other.left))
			return false;
		if (right == null) 
		{
			if (other.right != null)
				return false;
		} 
		else if (!right.equals(other.right))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "State [left=" + left + ", right=" + right + "]";
	}
	
	
}
