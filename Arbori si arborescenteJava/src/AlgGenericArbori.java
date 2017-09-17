import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AlgGenericArbori 
{
	public static Muchie minim(ArrayList<Muchie> A)
	{
		int min=9999;
		Muchie m=new Muchie();
		for(int y=0;y<A.size();y++)
		{
			if(A.get(y).getValoare()<=min)
			{
				min=A.get(y).getValoare();
				m.setX(A.get(y).getX());
				m.setY(A.get(y).getY());
				m.setValoare(A.get(y).getValoare());
			}
		}
		return m;
	}
	
	public static boolean contine(ArrayList<Muchie> A,Muchie b)
	{
		for(int i=0;i<A.size();i++)
		{
			if(A.get(i).getX()==b.getX() && A.get(i).getY()==b.getY())
				return true;
		}
		return false;
	}
	
	public static void programGeneric(ArrayList<Muchie> A,int nrNoduri,int nrMuchii,ArrayList<ArrayList<Integer>> N)
	{
		ArrayList<Integer> Ni,Nj ;
		
		
		for(int i=0;i<nrNoduri;i++)
		{
			Ni = new ArrayList<Integer>();
			Ni.add(i+1);
			N.add(Ni);
		}
		
		ArrayList<ArrayList<Muchie>> Ap = new ArrayList<ArrayList<Muchie>>();
		for(int i=0; i<nrNoduri; i++)
		{
			Ap.add(new ArrayList<Muchie> ());
		}
			
		for(int i=0;i<nrNoduri-1;i++)
		{
			ArrayList<Muchie> af=new ArrayList<Muchie>();
			ArrayList<Muchie> ai=new ArrayList<Muchie>();
			Random rand=new Random();
			int nr = rand.nextInt(N.size());
			Ni=N.get(nr);
			ai=Ap.get(nr);
			System.out.println("N= "+N);
			System.out.println("Ni = " + Ni);
		
			for(int j=0;j<A.size();j++)
			{
				for(int k=0;k<Ni.size();k++)
				{
					if(Ni.get(k)==A.get(j).getX() && !Ni.contains(A.get(j).getY()))
					{
						af.add(A.get(j));
					}
				}
			}
			Muchie m=new Muchie();
			
			System.out.println("Muchii " + af);
			m=minim(af);
			System.out.println("Muchia minima = " + m);
			
			int yb=m.getY();
			System.out.println("y barat =" + yb);
			
			int poz=-1;
			for(int p=0; p<N.size(); p++)
			{
				if(N.get(p).contains(yb))
				poz=p;
			}
			
			Nj = new ArrayList<Integer>();
			Nj=N.get(poz);
			System.out.println("Nj="+Nj);
			for(int j=0; j<Nj.size(); j++)
			{
				Ni.add(Nj.get(j));
			}
		    N.remove(poz);
		    System.out.println("Ni = "+ Ni);
		    Ap.get(nr).add(m);
		    for(int j=0; j<Ap.get(poz).size(); j++)
		    {
		    	m=Ap.get(poz).get(j);
		    	Ap.get(nr).add(m);
		    }
		    Ap.remove(poz);
		    System.out.println("Ai'="+ai);
		    System.out.println();
			
		}
		System.out.println("A'="+Ap);
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int nrNoduri,nrMuchii,valoare,x,y;
		ArrayList<Muchie> m=new ArrayList<Muchie>();
		Muchie mu;
		ArrayList<ArrayList<Integer>> N = new ArrayList<ArrayList<Integer>>();
	
		System.out.println("Introduceti numarul de noduri:");
		nrNoduri=in.nextInt();
		
		System.out.println("Introduceti numarul de muchii:");
		nrMuchii=in.nextInt();
		System.out.println("Introduceti muchiile : x  y  valoare");
		for(int i=0;i<nrMuchii;i++)
		{
			x=in.nextInt();
			y=in.nextInt();
			valoare=in.nextInt();
			mu=new Muchie(x,y,valoare);
			m.add(mu);
			mu=new Muchie(y,x,valoare);
			m.add(mu);
		}
		
		programGeneric(m,nrNoduri, nrMuchii, N);
		in.close();

	}

}
