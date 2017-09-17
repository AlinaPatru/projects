import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class TreeMethods 
{

	StateMethods sMeth = new StateMethods();
	Node initialNode =  new Node();
	State goalState = new State();
	int size;
	List<Node> fringe = new ArrayList<Node>();
	Hashtable<State,Integer> hash = new Hashtable<State, Integer>();
	
	public void initialize()
	{
		sMeth.constructStates();
		initialNode = new Node(sMeth.getInitialState(),null,"initial");
		goalState = sMeth.getGoalState();
		size = sMeth.getM();
		
		search();
	}
	
	
	
	public boolean test(Node node)
	{
		int leftC = node.getState().getLeft().getCannibalsNumber();
		int leftM = node.getState().getLeft().getMissionariesNumber();
		
		int rightC = node.getState().getRight().getCannibalsNumber();
		int rightM = node.getState().getRight().getMissionariesNumber();
		
		if(leftC > size || leftC > size || rightC > size || rightM > size)
			return false;
		
		if(leftM < leftC)
			if(leftM != 0)
				return false;
		
		if(rightM < rightC)
			if(rightM != 0)
				return false;
		return true;
	}
	
	
	
	public void expand(Node node)
	{
		int cannibalsNumberL = node.getState().getLeft().getCannibalsNumber();
		int misionariesNumberL = node.getState().getLeft().getMissionariesNumber() ;
		
		int cannibalsNumberR = node.getState().getRight().getCannibalsNumber();
		int misionariesNumberR = node.getState().getRight().getMissionariesNumber() ;
		Node newNode;
		
		if(node.getState().getLeft().getBoat() == 1)
		{
			if(misionariesNumberL >= 2 )
			{
				if(cannibalsNumberL >= 2)
				{
					// 1C
					newNode = new Node(new State(new RiverBank(misionariesNumberL,cannibalsNumberL-1,0), new RiverBank(misionariesNumberR, cannibalsNumberR+1, 1)), node, "1C");
					if(test(newNode))
						fringe.add(newNode);
					
					// 1M
					newNode = new Node(new State(new RiverBank(misionariesNumberL-1,cannibalsNumberL,0), new RiverBank(misionariesNumberR+1, cannibalsNumberR, 1)), node, "1M");
					if(test(newNode))
						fringe.add(newNode);
					
					// 1C si 1M
					newNode = new Node(new State(new RiverBank(misionariesNumberL-1,cannibalsNumberL-1,0), new RiverBank(misionariesNumberR+1, cannibalsNumberR+1, 1)), node, "1M 1C");
					if(test(newNode))
						fringe.add(newNode);
					
					// 2C
					newNode = new Node(new State(new RiverBank(misionariesNumberL,cannibalsNumberL-2,0), new RiverBank(misionariesNumberR, cannibalsNumberR+2, 1)), node, "2C");
					if(test(newNode))
						fringe.add(newNode);
					
					// 2M
					newNode = new Node(new State(new RiverBank(misionariesNumberL-2,cannibalsNumberL,0), new RiverBank(misionariesNumberR+2, cannibalsNumberR, 1)), node, "2M");
					if(test(newNode))
						fringe.add(newNode);
				}
				else
				{
					// 1C
					newNode = new Node(new State(new RiverBank(misionariesNumberL,cannibalsNumberL-1,0), new RiverBank(misionariesNumberR, cannibalsNumberR+1, 1)), node, "1C");
					if(test(newNode))
						fringe.add(newNode);
	
					// 1M
					newNode = new Node(new State(new RiverBank(misionariesNumberL-1,cannibalsNumberL,0), new RiverBank(misionariesNumberR+1, cannibalsNumberR, 1)), node, "1M");
					if(test(newNode))
						fringe.add(newNode);
					
					// 1C si 1M
					newNode = new Node(new State(new RiverBank(misionariesNumberL-1,cannibalsNumberL-1,0), new RiverBank(misionariesNumberR+1, cannibalsNumberR+1, 1)), node, "1M 1C");
					if(test(newNode))
						fringe.add(newNode);
					
					// 2M
					newNode = new Node(new State(new RiverBank(misionariesNumberL-2,cannibalsNumberL,0), new RiverBank(misionariesNumberR+2, cannibalsNumberR, 1)), node, "2M");
					if(test(newNode))
						fringe.add(newNode);
				}
			}
			else if(cannibalsNumberL >=2)
				{
					// 1C
					newNode = new Node(new State(new RiverBank(misionariesNumberL,cannibalsNumberL-1,0), new RiverBank(misionariesNumberR, cannibalsNumberR+1, 1)), node, "1C");
					if(test(newNode))
						fringe.add(newNode);
					// 2C
					newNode = new Node(new State(new RiverBank(misionariesNumberL,cannibalsNumberL-2,0), new RiverBank(misionariesNumberR, cannibalsNumberR+2, 1)), node, "2C");
					if(test(newNode))
						fringe.add(newNode);
				}
			else
			{
				if(misionariesNumberL == 1)
					if(cannibalsNumberL == 1)
					{
						// 1C si 1M
						newNode = new Node(new State(new RiverBank(misionariesNumberL-1,cannibalsNumberL-1,0), new RiverBank(misionariesNumberR+1, cannibalsNumberR+1, 1)), node, "1M 1C");
						if(test(newNode))
							fringe.add(newNode);
						
						// 1M
						newNode = new Node(new State(new RiverBank(misionariesNumberL-1,cannibalsNumberL,0), new RiverBank(misionariesNumberR+1, cannibalsNumberR, 1)), node, "1M");
						if(test(newNode))
							fringe.add(newNode);
					}
				else
				{
					if(cannibalsNumberL == 1)
					{
						// 1C
						newNode = new Node(new State(new RiverBank(misionariesNumberL,cannibalsNumberL-1,0), new RiverBank(misionariesNumberR, cannibalsNumberR+1, 1)), node, "1C");
						if(test(newNode))
							fringe.add(newNode);
					}
				}
			}
		}
		else
		{
			if(misionariesNumberR >= 2 )
			{
				if(cannibalsNumberR >= 2)
				{
					// 1C
					newNode = new Node(new State(new RiverBank(misionariesNumberL,cannibalsNumberL+1,1), new RiverBank(misionariesNumberR, cannibalsNumberR-1, 0)), node, "1C");
					if(test(newNode))
						fringe.add(newNode);
					
					// 1M
					newNode = new Node(new State(new RiverBank(misionariesNumberL+1,cannibalsNumberL,1), new RiverBank(misionariesNumberR-1, cannibalsNumberR, 0)), node, "1M");
					if(test(newNode))
						fringe.add(newNode);
					
					// 1C si 1M
					newNode = new Node(new State(new RiverBank(misionariesNumberL+1,cannibalsNumberL+1,1), new RiverBank(misionariesNumberR-1, cannibalsNumberR-1, 0)), node, "1M 1C");
					if(test(newNode))
						fringe.add(newNode);
					
					// 2C
					newNode = new Node(new State(new RiverBank(misionariesNumberL,cannibalsNumberL+2,1), new RiverBank(misionariesNumberR, cannibalsNumberR-2, 0)), node, "2C");
					if(test(newNode))
						fringe.add(newNode);
					
					// 2M
					newNode = new Node(new State(new RiverBank(misionariesNumberL+2,cannibalsNumberL,1), new RiverBank(misionariesNumberR-2, cannibalsNumberR, 0)), node, "2M");
					if(test(newNode))
						fringe.add(newNode);
				}
				else
				{
					// 1C
					newNode = new Node(new State(new RiverBank(misionariesNumberL,cannibalsNumberL+1,1), new RiverBank(misionariesNumberR, cannibalsNumberR-1, 0)), node, "1C");
					if(test(newNode))
						fringe.add(newNode);
	
					// 1M
					newNode = new Node(new State(new RiverBank(misionariesNumberL+1,cannibalsNumberL,1), new RiverBank(misionariesNumberR-1, cannibalsNumberR, 0)), node, "1M");
					if(test(newNode))
						fringe.add(newNode);
					
					// 1C si 1M
					newNode = new Node(new State(new RiverBank(misionariesNumberL=1,cannibalsNumberL+1,1), new RiverBank(misionariesNumberR-1, cannibalsNumberR-1, 0)), node, "1M 1C");
					if(test(newNode))
						fringe.add(newNode);
					
					// 2M
					newNode = new Node(new State(new RiverBank(misionariesNumberL+2,cannibalsNumberL,1), new RiverBank(misionariesNumberR-2, cannibalsNumberR, 0)), node, "2M");
					if(test(newNode))
						fringe.add(newNode);
				}
			}
			else if(cannibalsNumberR >= 2)
				{
					// 1C
					newNode = new Node(new State(new RiverBank(misionariesNumberL,cannibalsNumberL+1,1), new RiverBank(misionariesNumberR, cannibalsNumberR-1, 0)), node, "1C");
					if(test(newNode))
						fringe.add(newNode);
					
					// 2C
					newNode = new Node(new State(new RiverBank(misionariesNumberL,cannibalsNumberL+2,1), new RiverBank(misionariesNumberR, cannibalsNumberR-2, 0)), node, "2C");
					if(test(newNode))
						fringe.add(newNode);
				}
			else
			{
				if(misionariesNumberR == 1)
					if(cannibalsNumberR == 1)
					{
						// 1C si 1M
						newNode = new Node(new State(new RiverBank(misionariesNumberL+1,cannibalsNumberL+1,1), new RiverBank(misionariesNumberR-1, cannibalsNumberR-1, 0)), node, "1M 1C");
						if(test(newNode))
							fringe.add(newNode);
						
						// 1M
						newNode = new Node(new State(new RiverBank(misionariesNumberL+1,cannibalsNumberL,1), new RiverBank(misionariesNumberR-1, cannibalsNumberR, 0)), node, "1M");
						if(test(newNode))
							fringe.add(newNode);
					}
				else
				{
					if(cannibalsNumberR == 1)
					{
						// 1C
						newNode = new Node(new State(new RiverBank(misionariesNumberL,cannibalsNumberL+1,1), new RiverBank(misionariesNumberR, cannibalsNumberR-1, 0)), node, "1C");
						if(test(newNode))
							fringe.add(newNode);
					}
				}
			}
		}
	}
	
	
	public void search()
	{
		
		fringe.add(initialNode);
		
		do
		{
			
			Node nod = new Node();
			nod = fringe.get(0);
			fringe.remove(0);
			
			
			if(sMeth.isGoal(nod.getState()))
			{
				recreateSolution(nod);
				break;
			}		
			
			if(hash.size() !=0)
			{
				if(!hash.containsKey(nod.getState()))
				{
					hash.put(nod.getState(), 1);
					expand(nod);
				}
			}
			
			else
			{	
				hash.put(initialNode.getState(), 1);
				
				expand(initialNode);	
			}
			if(fringe.size() == 0)
				System.out.println("failed");
				
		}while(fringe.size()!=0);		
	}
	
	public void recreateSolution(Node node)
	{
		String filename = "Solution.txt";
		FileWriter fw;
		
		try 
		{
			fw = new FileWriter(filename);
			
			do
			{
				printNode(node,fw, size);
				
				node = node.getParentNode();
				
			}while(node.getParentNode() != null);
			
			printNode(node,fw, size);
			
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

			fw.write(node.toString());
			fw.write(System.getProperty( "line.separator" ));
			fw.write(System.getProperty( "line.separator" ));
			fw.write(System.getProperty( "line.separator" ));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
}
