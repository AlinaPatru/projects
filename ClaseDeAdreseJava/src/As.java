
public class As {

	public static void main(String args[]){

	    int i;
	    byte y;
	    i = 1024;
	    for(i = 1024; i > 0; i-- ){

	      y = (byte)i;
	      System.out.print(i + " mod 128 = " + i%128 + " also ");
	      System.out.println(i + " cast to byte " + " = " + y);

	    }
	    
	    int a=-6;
	    String binaryString="11010011";
	    System.out.println(Integer.toBinaryString(a));
	    String b=Integer.toString(2014,2);
	    System.out.println(Integer.toString(2014,2));
	    System.out.println("Output: "+Integer.parseInt(binaryString,2));
	}

}
