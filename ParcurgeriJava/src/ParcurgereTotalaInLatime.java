import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ParcurgereTotalaInLatime 
{

		public static void parcurgereTotalaInLatime(ArrayList<Arc> A,int nodSursa,int nrNoduri, ArrayList<Integer> U, ArrayList<Integer>  W, ArrayList<Integer>  V, ArrayList<Integer> l, ArrayList<Integer> p,ArrayList<Integer> N)
		{
			U.remove(U.indexOf(nodSursa));
			V.add(nodSursa);
			for(int y=0; y<nrNoduri; y++)
			{
				p.add(0);
			}
			
			for(int y=0; y<nrNoduri; y++)
			{
				l.add(-1);
			}
			l.set((nodSursa-1),0);
			
			System.out.println("U= "+U);
			System.out.println("V= "+V);
			System.out.println("p= "+p);
			System.out.println("l= "+l);
			System.out.println();
			
			while(W.size()!=N.size())
			{
				while(V.size()!=0)
				{
					Arc a=new Arc();
					int x = V.get(0);
					a.setX(x);
					for(int y=0; y<nrNoduri; y++)
					{
						a.setY(y+1);
						if( U.contains(y+1))
						{
							for(int i=0;i<A.size();i++)
							{
								if(A.get(i).getX()==a.getX() && A.get(i).getY()==a.getY())
								{
									System.out.println("x= "+x);
								    System.out.println("Exista arcul "+a+"  cu y= " +(y+1)+" apartine lui U");
									U.remove(U.indexOf(y+1));
									V.add(y+1);
									p.set(y,x);
									l.set(y, l.get(x-1)+1);
									System.out.println("U= "+U);
									System.out.println("V= "+V);
									System.out.println("p= "+p);
									System.out.println("l= "+l);
									System.out.println();
								}
							}
						}
					}
					
					System.out.println("x= "+x);
					V.remove(V.indexOf(x));
					W.add(x);
					System.out.println("V= "+V);
					System.out.println("W= "+W);
					System.out.println();
					
				}
				if(U.size()>0)
				{
					Random rand = new Random();
					int nr = rand.nextInt(U.size());
					nodSursa = U.get(nr);
					U.remove(U.indexOf(nodSursa));
					V.add(nodSursa);
					System.out.println("Nodul sursa este =  " +nodSursa);
					l.set((nodSursa-1),0);
					System.out.println("U= "+U);
					System.out.println("V= "+V);
					System.out.println("p= "+p);
					System.out.println("l= "+l);
					System.out.println();
				
				}
			}
			
		}

		public static void main(String[] args) 
		{
	        Scanner in=new Scanner(System.in);
	        ArrayList<Integer> N = new ArrayList<Integer> ();
	        ArrayList<Integer> U = new ArrayList<Integer> ();
	        ArrayList<Integer> W = new ArrayList<Integer> ();
	        ArrayList<Integer> V = new ArrayList<Integer> ();
	        ArrayList<Integer> l = new ArrayList<Integer> ();
	        ArrayList<Integer> p = new ArrayList<Integer> ();
	        ArrayList<Arc> A = new ArrayList<Arc> ();
	        int nodSursa,nrArce,nrNoduri;
	        
			System.out.println("Introduceti numarul de noduri :");
			nrNoduri=in.nextInt();
			
			System.out.println("Introduceti numarul de arce :");
			nrArce=in.nextInt();
			
			System.out.println("Introduceti arcele: ");
			try
			{
				citireArce(A,nrArce,nrNoduri,in);
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
			
			System.out.println("A= "+A);
			System.out.println("Introduceti nodul SURSA ");
			nodSursa=in.nextInt();
			System.out.println("Nodul sursa este =  " +nodSursa);
			parcurgereTotalaInLatime(A,nodSursa,nrNoduri,U,W,V,l,p,N);
		
	        in.close();

		}
		public static void citireArce(ArrayList<Arc> arc,int nrArce,int nrNoduri,Scanner in) throws Exception
		{
			int x,y;
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

}
