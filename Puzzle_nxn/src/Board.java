import java.util.ArrayList;
import java.util.List;

public class Board 
{
	private List<Integer> board;
	private int blankPosition;
	private int size;
	
	public Board()
	{
		this.size=0;
		board=new ArrayList<Integer>();
	}
	
	public Board(List<Integer> board, int size) 
	{
		this.size = size;
		this.board=new ArrayList<Integer>(board);
	}

	public List<Integer> getBoard() 
	{
		return board;
	}

	public int getBlankPosition() 
	{
		return blankPosition;
	}

	public int getSize() 
	{
		return size;
	}

	public void setBoard(List<Integer> board) 
	{
		this.board = board;
	}

	public void setBlankPosition(int blankPosition) 
	{
		this.blankPosition = blankPosition;
	}

	public void setSize(int size) 
	{
		this.size = size;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + blankPosition;
		result = prime * result + ((board == null) ? 0 : board.hashCode());
		result = prime * result + size;
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (blankPosition != other.blankPosition)
			return false;
		if (board == null) 
		{
			if (other.board != null)
				return false;
		}
		else if (!board.equals(other.board))
			return false;
		if (size != other.size)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Board [board=" + board + ", blankPosition=" + blankPosition + ", size=" + size + "]";
	}
	
	
	

}
