import java.io.File;
import java.io.*;

public class Driver {
	public static void main(String [] args) throws FileNotFoundException {
		//Polynomial p = new Polynomial();
		//System.out.println(p.evaluate(3));
		double [] c1 = {6,5,-12,1};
		int [] e1 = {2,0,1,5};
		Polynomial p1 = new Polynomial(c1,e1);
		double [] c2 = {-2,-9,22,3};
		int [] e2 = {0,3,4,1};
		Polynomial p2 = new Polynomial(c2,e2);
		Polynomial s = p1.add(p2);
		System.out.println("s(0.1) = " + s.evaluate(0.1));
		if(s.hasRoot(30.5))
			System.out.println("1 is a root of s");
		else
			System.out.println("1 is not a root of s");
		Polynomial pd = p1.multiply(p2);
		System.out.println("pd(3) = " + pd.evaluate(3));
		/*File file = new File("C:/Users/clare/text_poly.txt");
		try {
			Polynomial poly = new Polynomial(file);
			System.out.println(poly);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
	}
}