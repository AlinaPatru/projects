import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BoardMethods 
{
	public Board initialBoard = new Board();
	public Board goalBoard = new Board();
	public int size;
	public int invertions;
	
	public Board getInitialBoard()
	{
		return this.initialBoard;
	}
	
	public void readFromFile()
	{
		
		String line;
		try 
		{
			BufferedReader bufRead=new BufferedReader(new FileReader("puzzle.txt"));
			List<Integer> input=new ArrayList<Integer>();
			try 
			{
				line = bufRead.readLine(); 
		        size=Integer.parseInt(line);
				while((line=bufRead.readLine())!=null)
				{
					StringTokenizer linieTok = new StringTokenizer(line);
					
					while(linieTok.hasMoreElements())
					{
						int tile=Integer.parseInt((String) linieTok.nextElement());
						input.add(tile);
						if(input.size()!=0 && tile==0)
							initialBoard.setBlankPosition(input.size()-1);
							
					}
				}
				
				constructBoards(input,size);
				invertions=countInvertions(input);
			}
			catch (IOException e) 
			{
				System.out.println(e.getMessage()+ " The file couldn't be read");
			}
			
			try 
			{
				bufRead.close();
			} 
			catch (IOException e) 
			{
				
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage()+ " The file was not found");
		}
	}
	
	public void constructBoards(List<Integer> input,int size)
	{
		initialBoard.setBoard(input);
		initialBoard.setSize(size);
		System.out.println("initialB"+initialBoard);

		
		for(int i=1;i<input.size();i++)
		{
			goalBoard.getBoard().add(i);
		}
		goalBoard.getBoard().add(0);
		goalBoard.setBlankPosition(input.size()-1);
		goalBoard.setSize(size);
		System.out.println("goalB"+goalBoard);
	}
	
	public int countInvertions(List<Integer> list)
	{
		int count = 0;
		
		for(int i = 0; i<list.size()-1; i++)
			for(int j = i+1; j< list.size(); j++)
				if(list.get(j) != 0)
					if(list.get(i)> list.get(j))
						count ++;
		System.out.println(count);
		return count;
	}
	
	public boolean isGoal(Board board)
	{
		if(board.equals(goalBoard))
			return true;
		return false;
	}
	
	public boolean hasSolution()
	{
		
		if( (size % 2 == 1) && (invertions % 2 == 0) )
			return true;
		
		if( (size % 2 == 0) && ( ((size - initialBoard.getBlankPosition()/size) % 2 == 0) && invertions % 2==1) )
			return true;
		
		if( (size % 2 == 0) && ( ((size - (initialBoard.getBlankPosition()/size)) % 2 == 1) && invertions % 2==0) )
			return true;
			
		return false;
	}

}
