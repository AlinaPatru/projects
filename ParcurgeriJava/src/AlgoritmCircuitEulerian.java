import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AlgoritmCircuitEulerian 
{
	public static void parcurgereTotalaInAdancime(ArrayList<Arc> A1,ArrayList<Arc> A,int rad,int nrNoduri, ArrayList<Integer> U, ArrayList<Integer>  W, ArrayList<Integer>  V, ArrayList<Integer> p,ArrayList<Integer> N)
	{
		U.remove(U.indexOf(rad));
		V.add(rad);
		for(int y=0; y<nrNoduri; y++)
		{
			p.add(0);
		}
		
		while(W.size()!=N.size())
		{
			while(V.size()!=0)
			{
				int x = V.get(V.size()-1);
				Arc a=new Arc();
				a.setX(x);
				int ok=0,y=0;
				while(ok==0 && y<nrNoduri)
				{
					a.setY(y+1);
					if( U.contains(y+1))
					{
						for(int i=0;i<A.size();i++)
						{
							if(A.get(i).getX()==a.getX() && A.get(i).getY()==a.getY() )
							{
								A1.add(a);
								U.remove(U.indexOf(y+1));
								V.add(y+1);
								p.set(y,x);
								ok=1;
							}
						}
					}
					y++;
			
				}
				if(y==nrNoduri)
				{
				V.remove(V.indexOf(x));
				W.add(x);
				}
			}
			if(U.size()>0)
			{
				Random rand = new Random();
				int nr = rand.nextInt(U.size());
				rad = U.get(nr);
				U.remove(U.indexOf(rad));
				V.add(rad);
			}
		}
		System.out.println("A'= "+A1);
		
	}
	
	public static boolean contine(ArrayList<Arc> A,Arc b)
	{
		for(int i=0;i<A.size();i++)
		{
			if(A.get(i).getX()==b.getX() && A.get(i).getY()==b.getY())
				return true;
		}
		return false;
	}
	
	public static void afisareMatrice(int a[][], int m)
	{
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<m;j++)
			{
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static void circuitEulerian(int b[][],ArrayList<Arc> A,ArrayList<Arc> A1,int rad,int nrNoduri, ArrayList<Integer> U, ArrayList<Integer>  W, ArrayList<Integer>  V, ArrayList<Integer> p,ArrayList<Integer> N)
	{
		parcurgereTotalaInAdancime(A1,A,rad,nrNoduri,U,W,V,p,N);
		ArrayList<Integer> pminus = new ArrayList<Integer> ();
		ArrayList<ArrayList<Integer>> Vminus = new ArrayList<ArrayList<Integer>> ();
		ArrayList<Integer> Vminus2 = new ArrayList<Integer> ();
		ArrayList<Integer> W1 = new ArrayList<Integer> ();
		ArrayList<Integer> k = new ArrayList<Integer> ();
		for(int i=0;i<nrNoduri;i++)
		{
			Vminus.add(new ArrayList<Integer> ());
		}
		
		for(int i=0;i<A.size();i++)
		{
			Arc a=new Arc();
			a.setX(A.get(i).getX());
			a.setY(A.get(i).getY());
			if(contine(A1,a))
				b[A.get(i).getX()-1][A.get(i).getY()-1]=1;
			else
				b[A.get(i).getX()-1][A.get(i).getY()-1]=0;				
		}
		for(int j=0;j<nrNoduri;j++)
		{
			pminus.add(0);
			k.add(0);
		}
		
		for(int j=0;j<A.size();j++)
		{
			int y=A.get(j).getY();
			if(b[A.get(j).getX()-1][A.get(j).getY()-1]==0)
			{
				Vminus.get(y-1).add(0,A.get(j).getX());
				pminus.set(y-1, pminus.get(y-1)+1);
				
			}
			else
			{
				Vminus.get(y-1).add(A.get(j).getX());
				pminus.set(y-1, pminus.get(y-1)+1);
			}
		}
		System.out.println(pminus);
		System.out.println(Vminus);
		int x=rad;
		while(k.get(x-1)<=pminus.get(x-1))
		{
			System.out.println("x= "+x);
			W1.add(0,x);
			System.out.println("i= "+k);
			System.out.println();
			k.set(x-1, k.get(x-1)+1);
			if(k.get(x-1)<=pminus.get(x-1))
			{
				System.out.println("W= "+W1);
				Vminus2=Vminus.get(x-1);
				x=Vminus2.get(k.get(x-1)-1);
			}
		}
		System.out.println("W= "+W1);

		
				
	}

	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		ArrayList<Arc> A=new ArrayList<Arc>();
		ArrayList<Arc> A1=new ArrayList<Arc>();
		ArrayList<Integer> U = new ArrayList<Integer> ();
        ArrayList<Integer> W = new ArrayList<Integer> ();
        ArrayList<Integer> N = new ArrayList<Integer> ();
        ArrayList<Integer> V = new ArrayList<Integer> ();
        ArrayList<Integer> p = new ArrayList<Integer> ();
		int nrNoduri,nrArce,x,y,rad;
		
		System.out.println("Introduceti numarul de noduri:");
		nrNoduri=in.nextInt();
		
		int [][] b=new int[nrNoduri][nrNoduri];
		
		System.out.println("Introduceti numarul de arce:");
		nrArce=in.nextInt();
		
		System.out.println("Introduceti arcele:");
		for(int i=0;i<nrArce;i++)
		{
			x=in.nextInt();
			y=in.nextInt();
			Arc arc=new Arc(x,y);
			A.add(arc);
		}
		
		for(int i=0; i<nrNoduri; i++)
		{
			U.add(i+1);
		}
		
		for(int i=0; i<nrNoduri; i++)
		{
			N.add(i+1);
		}
		
		System.out.println("Introduceti radacina:");
		rad=in.nextInt();
	
		circuitEulerian(b,A,A1,rad,nrNoduri,U,W,V,p,N);
		
		in.close();

	}

}
