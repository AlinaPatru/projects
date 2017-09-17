import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class TreeMethods 
{
	
	Node initialNode;
	List<Node> fringe = new ArrayList<Node>();
	Hashtable<Board,Integer> hash = new Hashtable<Board, Integer>();
	BoardMethods bMeth = new BoardMethods();
	
	public void initialize()
	{
		bMeth.readFromFile();
		
		if(bMeth.isGoal(bMeth.getInitialBoard()))
		{
			System.out.println("The entered puzzle is the solution !");
		}
		else
		{
		
			if(bMeth.hasSolution())
			{
				System.out.println("solvable");	
				
				initialNode = createInitialNode(bMeth.getInitialBoard());
				
				search(initialNode);
			}
			else
			{
				System.out.println("not solvable");
			}
		}
			
	}
	
	public Node createInitialNode(Board board)
	{
		initialNode = new Node();
		initialNode.setCurrentState(board);
		initialNode.setParentNode(null);
		initialNode.setPathCost(1);
		initialNode.setAction("initial node");
		
		return initialNode;
	}
	
	public Node createNewNod(Node node, String action)
	{
		int size=node.getCurrentState().getSize();
		Board newBoard = new Board(node.getCurrentState().getBoard(), size);
		int newBlankPos;
		int blankPos = node.getCurrentState().getBlankPosition();
		int aux = -1;
		
		newBoard.setSize(size);
		newBoard.setBlankPosition(blankPos);
		
		if(action.equals("sus"))
		{
			aux = newBoard.getBoard().get(blankPos-size);
			
			newBoard.getBoard().set(blankPos-size, 0);
			
			newBlankPos=blankPos-size;		
			newBoard.setBlankPosition(newBlankPos);
		
		}
		if(action.equals("jos"))
		{
			aux = newBoard.getBoard().get(blankPos+size);
			
			newBoard.getBoard().set(blankPos+size, 0);
			
			newBlankPos=blankPos+size;		
			newBoard.setBlankPosition(newBlankPos);
			
		}
		if(action.equals("stanga"))
		{
			aux = newBoard.getBoard().get(blankPos-1);
			
			newBoard.getBoard().set(blankPos-1, 0);
			
			newBlankPos=blankPos-1;		
			newBoard.setBlankPosition(newBlankPos);
			
		}
		if(action.equals("dreapta"))
		{
			aux = newBoard.getBoard().get(blankPos+1);
			
			newBoard.getBoard().set(blankPos+1, 0);
			
			newBlankPos=blankPos+1;		
			newBoard.setBlankPosition(newBlankPos);	
			
		}
		
		newBoard.getBoard().set(blankPos, aux);
		Node newNode = new Node(newBoard,node,node.getPathCost()+1,action);
		return newNode;
	}
	
	
	public List<Node> expand(Node currentNode)
	{
		List<Node> succesors = new ArrayList<Node>();
		
		int boardSize = currentNode.currentState.getSize();
		int blankXPos = currentNode.currentState.getBlankPosition()/boardSize;
		int blankYPos = currentNode.currentState.getBlankPosition()%boardSize;
		
		
		if(blankXPos != boardSize-1)
		{
			if(blankXPos != 0)
			{

				succesors.add(createNewNod(currentNode, "sus"));
			}
			succesors.add(createNewNod(currentNode, "jos"));
		}
		else
		{
			succesors.add(createNewNod(currentNode, "sus"));
		}
		
		
		if(blankYPos != boardSize-1)
		{
			if(blankYPos != 0)
			{
				succesors.add(createNewNod(currentNode, "stanga"));
			}
			succesors.add(createNewNod(currentNode, "dreapta"));
		}
		else
		{
			succesors.add(createNewNod(currentNode, "stanga"));
		}
		
		return succesors;
	}
	
	
	public void search(Node initialNode)
	{
		
		fringe.add(initialNode);
		
		do
		{
			Node nod = new Node();
			nod = fringe.get(0);
			fringe.remove(0);
			
			
			if(bMeth.isGoal(nod.getCurrentState()))
			{
				recreateSolution(nod);
				break;
			}		
			
			if(hash.size() !=0)
			{
				if(!hash.containsKey(nod.getCurrentState()))
				{
					hash.put(nod.getCurrentState(), 1);
					fringe.addAll(expand(nod));
				}
			}
			
			else
			{	
				hash.put(initialNode.getCurrentState(), 1);
				
				fringe.addAll(expand(initialNode));	
			}
			if(fringe.size() == 0)
				System.out.println("failed");
				
		}while(fringe.size()!=0);		
	}
	
	public void recreateSolution(Node node)
	{
		String filename = "Solution.txt";
		int puzzleSize = bMeth.size;
		FileWriter fw;
		
		try 
		{
			fw = new FileWriter(filename);
			
			do
			{
				printNode(node,fw, puzzleSize);
				
				node = node.parentNode;
				
			}while(node.parentNode != null);
			
			printNode(node,fw, puzzleSize);
			
			fw.close();
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public void printNode(Node node, FileWriter fw, int puzzleSize)
	{
		try 
		{

			fw.write(System.getProperty( "line.separator" ));
			for(int i = 0; i < puzzleSize; i++)
			{
				for(int j = 0; j < puzzleSize; j++)
				{
					fw.write(node.getCurrentState().getBoard().get(i*puzzleSize+j)+ " ");
				}
				fw.write(System.getProperty( "line.separator" ));
				
			}
			fw.write(System.getProperty( "line.separator" ));
			fw.write(node.getAction());
			fw.write(System.getProperty( "line.separator" ));
			fw.write("Path cost =  "+node.getPathCost());
			fw.write(System.getProperty( "line.separator" ));
			fw.write(System.getProperty( "line.separator" ));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
}
