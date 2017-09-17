import java.util.Scanner;

public class StateMethods 
{
	public int m;
	public State initialState=new State();
	public State goalState=new State();
	
	
	public int getM() {
		return m;
	}

	public State getInitialState() {
		return initialState;
	}

	public State getGoalState() {
		return goalState;
	}

	public void setM(int m) {
		this.m = m;
	}

	public void setInitialState(State initialState) {
		this.initialState = initialState;
	}

	public void setGoalState(State goalState) {
		this.goalState = goalState;
	}

	public void constructStates()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the number of each missionaries and cannibals");
		m=in.nextInt();
		
		RiverBank left=new RiverBank(m,m,1);
		RiverBank right=new RiverBank();
		
		setInitialState(new State(left,right));
		
		setGoalState(new State(right,left));
		
		in.close();
		
	}
	
	public boolean isGoal(State state)
	{
		if(state.equals(goalState))
		{
			return true;
		}
		return false;
	}

}
