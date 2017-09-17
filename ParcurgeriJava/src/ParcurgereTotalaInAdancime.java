import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ParcurgereTotalaInAdancime 
{
	public static void parcurgereTotalaInAdancime(ArrayList<Arc> arc,int nodSursa,int nrNoduri, ArrayList<Integer> U, ArrayList<Integer>  W, ArrayList<Integer>  V, ArrayList<Integer> t1,ArrayList<Integer> t2, ArrayList<Integer> p,ArrayList<Integer> N)
	{
		int t=1;
		U.remove(U.indexOf(nodSursa));
		V.add(nodSursa);
		for(int y=0; y<nrNoduri; y++)
		{
			p.add(0);
		}
		
		for(int y=0; y<nrNoduri; y++)
		{
			t1.add(-1);
		}
		t1.set((nodSursa-1),1);
		
		for(int y=0; y<nrNoduri; y++)
		{
			t2.add(-1);
		}
		
		System.out.println("U= "+U);
		System.out.println("V= "+V);
		System.out.println("p= "+p);
		System.out.println("t1= "+t1);
		System.out.println("t2= "+t2);
		System.out.println();
		
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
						for(int i=0;i<arc.size();i++)
						{
							if(arc.get(i).getX()==a.getX() && arc.get(i).getY()==a.getY() )
							{
								System.out.println("x= "+x);
							    System.out.println("Exista arcul "+a+"  cu y= " +(y+1));
								U.remove(U.indexOf(y+1));
								V.add(y+1);
								p.set(y,x);
								t++;
								t1.set(y, t);
								System.out.println("U= "+U);
								System.out.println("V= "+V);
								System.out.println("p= "+p);
								System.out.println("t= "+t);
								System.out.println("t1= "+t1);
								System.out.println();
								ok=1;
							}
						}
					}
					y++;
			
				}
				if(y==nrNoduri)
				{
				System.out.println("x= "+x);
				V.remove(V.indexOf(x));
				W.add(x);
				t++;
				t2.set(x-1, t);
				System.out.println("V= "+V);
				System.out.println("W= "+W);
				System.out.println("t= "+t);
				System.out.println("t2= "+t2);
				System.out.println();
				}
			}
			if(U.size()>0)
			{
				Random rand = new Random();
				int nr = rand.nextInt(U.size());
				nodSursa = U.get(nr);
				U.remove(U.indexOf(nodSursa));
				V.add(nodSursa);
				System.out.println("Nodul sursa este :   " +nodSursa);
				t++;
				t1.set((nodSursa-1),t);
				System.out.println("U= "+U);
				System.out.println("V= "+V);
				System.out.println("p= "+p);
				System.out.println("t1= "+t1);
				System.out.println();
			
			}
		}
		
	}
	
	public static void citireArce(ArrayList<Arc> arc,int nrArce,int nrNoduri,Scanner in) throws Exception
	{
		int x,y;
	    System.out.println("Introduceti arcele: ");
		for(int i=0; i<nrArce; i++)
		{
			Arc a=new Arc();
			x=in.nextInt();
			y=in.nextInt();
			if(x<=0 ||x>nrNoduri ||y<=0 ||y>nrNoduri)
				throw new Exception("Eroare la introducere arce");
			a.setX(x);
			a.setY(y);
			arc.add(a);
		}
		
	}

	public static void main(String[] args) 
	{
	    Scanner in=new Scanner(System.in);
        ArrayList<Integer> U = new ArrayList<Integer> ();
        ArrayList<Integer> W = new ArrayList<Integer> ();
        ArrayList<Integer> N = new ArrayList<Integer> ();
        ArrayList<Integer> V = new ArrayList<Integer> ();
        ArrayList<Integer> t1 = new ArrayList<Integer> ();
        ArrayList<Integer> t2 = new ArrayList<Integer> ();
        ArrayList<Integer> p = new ArrayList<Integer> ();
        ArrayList<Arc> arc = new ArrayList<Arc> ();
        int nodSursa,nrArce,nrNoduri;
        
		System.out.println("Introduceti numarul de noduri :");
		nrNoduri=in.nextInt();
		
		System.out.println("Introduceti numarul de arce :");
		nrArce=in.nextInt();
		
		try
		{
			citireArce(arc,nrArce,nrNoduri,in);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			
		}
		
		for(int i=0; i<nrNoduri; i++)
		{
			U.add(i+1);
		}
		
		for(int i=0; i<nrNoduri; i++)
		{
			N.add(i+1);
		}
		
		System.out.println("A= "+arc);
		System.out.println("Citeste nodul SURSA ");
		nodSursa=in.nextInt();
		
		parcurgereTotalaInAdancime(arc,nodSursa,nrNoduri,U,W,V,t1,t2,p,N);
		
        in.close();

	}

}
